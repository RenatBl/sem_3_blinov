package ru.itis.servlets;

import javafx.util.Pair;
import ru.itis.dao.impl.RentDaoImpl;
import ru.itis.dao.impl.StationDaoImpl;
import ru.itis.models.Rent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/history")
public class HistoryServlet extends HttpServlet {
    private RentDaoImpl rentDao;
    private StationDaoImpl stationDao;

    @Override
    public void init() throws ServletException {
        this.rentDao = new RentDaoImpl();
        this.stationDao = new StationDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Long user_id = (Long) session.getAttribute("user");
        List<Rent> rents = rentDao.findAllByUserId(user_id);
        List<Pair<String, Rent>> pairs = new ArrayList<>();
        int total = rents.size();
        System.out.println(total);
        int unpaid = 0;
        for (Rent rent: rents) {
            pairs.add(new Pair<>(stationDao.find(rent.getStart_station_id()).get().getName(), rent));
            if (!rent.isPaid()) {
                unpaid++;
            }
        }

        if (!rents.isEmpty()) {
            req.setAttribute("rents", pairs);
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
