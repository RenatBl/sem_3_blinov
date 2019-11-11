package ru.itis.servlets;

import ru.itis.dao.impl.UserDaoImpl;
import ru.itis.models.User;
import ru.itis.services.HashingPassword;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
    private UserDaoImpl userDao;
    private HashingPassword hashingPassword;

    @Override
    public void init() throws ServletException {
        this.userDao = new UserDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/WEB-INF/templates/signup.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String phoneNumber = req.getParameter("phoneNumber");
        String email = req.getParameter("email");
        try {
            userDao.save(new User(username, hashingPassword.getSaltedHash(password), name, surname, phoneNumber, email));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        resp.sendRedirect("/login");
    }
}