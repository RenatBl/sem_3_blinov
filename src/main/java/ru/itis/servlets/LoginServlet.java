package ru.itis.servlets;

import com.google.gson.Gson;
import ru.itis.dao.impl.UserDaoImpl;
import ru.itis.dao.impl.UserFormDao;
import ru.itis.forms.UserForm;
import ru.itis.models.User;
import ru.itis.services.Validator;
import ru.itis.services.StringEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserDaoImpl userDao;
    private UserFormDao userFormDao;

    @Override
    public void init() throws ServletException {
        this.userDao = new UserDaoImpl();
        this.userFormDao = new UserFormDao();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/templates/login.ftl").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Optional<User> user = userDao.findByUserName(username);
        HttpSession session = req.getSession();
        List<String> errors = Validator.validate(username, password, user);
        Map<String, Object> data = new HashMap<>();
        if (errors.size() == 0) {
            session.setAttribute("user", user.get().getId());
            String addToCookie;
            try {
                addToCookie = StringEncoder.getEncryptedString(username + password);
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
            this.saveAuthParam(user.get(), addToCookie);
            Cookie authParam = this.getAuthCookie(addToCookie);
            resp.addCookie(authParam);
            data.put("redirect", "/main");
        } else {
            data.put("errors", errors);
        }
        String json = new Gson().toJson(data);
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }

    private void saveAuthParam(User user, String addToCookie) {
        this.userFormDao.save(new UserForm(addToCookie, user.getId()));
    }

    private Cookie getAuthCookie(String value) {
        Cookie cookie = new Cookie("cookie", value);
        cookie.setMaxAge(-1);
        return cookie;
    }
}