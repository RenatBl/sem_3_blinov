package ru.itis.servlets;

import ru.itis.dao.impl.RentDaoImpl;
import ru.itis.models.Rent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/history")
public class HistoryServlet extends HttpServlet {
    private RentDaoImpl rentDao;

    @Override
    public void init() throws ServletException {
        this.rentDao = new RentDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Rent> rents = rentDao.findAll();
        int total = rents.size();
        int unpaid = 0;
        for (Rent rent: rents) {
            if (!rent.isPaid()) {
                unpaid++;
            }
        }
        if (!rents.isEmpty()) {
            req.setAttribute("rents", rents);
            req.setAttribute("total", total);
            req.setAttribute("unpaid", unpaid);
        } else {
            req.setAttribute("error_no_rents", "Заказы отсутствуют");
        }
        req.getServletContext().getRequestDispatcher("/WEB-INF/templates/history.ftl").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
