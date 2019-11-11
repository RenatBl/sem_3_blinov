package ru.itis.servlets;

import ru.itis.dao.impl.RentDaoImpl;
import ru.itis.models.Rent;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class PayingServlet extends HttpServlet {
    private RentDaoImpl rentDao;

    @Override
    public void init() throws ServletException {
        this.rentDao = new RentDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<Rent> rent = rentDao.find(Long.valueOf(req.getParameter("id")));
        req.setAttribute("rent", rent);
        req.getRequestDispatcher("/WEB-INF/templates/paying.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
