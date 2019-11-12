package ru.itis.servlets;

import ru.itis.dao.impl.UserDaoImpl;
import ru.itis.dao.impl.UserFormDao;
import ru.itis.forms.UserForm;
import ru.itis.models.User;
import ru.itis.services.StringEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/templates/login.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Optional<User> user = userDao.findByUserName(username);
        HttpSession session = req.getSession();
        if (user.isPresent()) {
            session.setAttribute("user", user.get().getId());
            String addToCookie;
            try {
                addToCookie = StringEncoder.getEncryptedString(username + password);
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
            this.saveParam(user.get(), addToCookie);
            Cookie cookie = this.getCookie(addToCookie);
            resp.addCookie(cookie);
            resp.sendRedirect("/main");
        } else {
            resp.sendRedirect("/login");
        }
    }

    private void saveParam(User user, String addToCookie) {
        this.userFormDao.save(new UserForm(addToCookie, user.getId()));
    }

    private Cookie getCookie(String value) {
        Cookie cookie = new Cookie("cookie", value);
        cookie.setMaxAge(-1);
        return cookie;
    }
}