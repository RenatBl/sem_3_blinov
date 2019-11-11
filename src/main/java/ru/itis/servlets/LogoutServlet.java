package ru.itis.servlets;

import ru.itis.dao.impl.UserDaoImpl;
import ru.itis.dao.impl.UserFormDao;
import ru.itis.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private UserDaoImpl userDao;
    private UserFormDao userFormDao;

    @Override
    public void init() throws ServletException {
        this.userDao = new UserDaoImpl();
        this.userFormDao = new UserFormDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        HttpSession session = req.getSession();
        Long id = (Long) session.getAttribute("user");
        if (id != null) {
            Optional<User> user = userDao.find(id);
            if (user.isPresent()) {
                userFormDao.delete(user.get().getId());
            } else {
                throw new IllegalStateException("Пользователя не найден в базе данных");
            }
        } else {
            throw new IllegalStateException("Неавторизованый пользователь попытался выйти");
        }

        session.removeAttribute("user");
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setValue("");
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
        }
        req.getRequestDispatcher("/WEB-INF/templates/login.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
