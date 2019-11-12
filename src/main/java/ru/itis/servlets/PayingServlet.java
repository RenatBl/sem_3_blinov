package ru.itis.servlets;

import ru.itis.dao.impl.RentDaoImpl;
import ru.itis.dao.impl.StationDaoImpl;
import ru.itis.models.Rent;
import ru.itis.models.Station;
import ru.itis.models.enums.Status;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/pay")
public class PayingServlet extends HttpServlet {
    private RentDaoImpl rentDao;
    private StationDaoImpl stationDao;

    @Override
    public void init() throws ServletException {
        this.rentDao = new RentDaoImpl();
        this.stationDao = new StationDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Rent rent = rentDao.find(Long.valueOf(req.getParameter("id"))).get();
        Station station = stationDao.find(rent.getStart_station_id()).get();
        req.setAttribute("rent", rent);
        req.setAttribute("station", station);
        req.getRequestDispatcher("/WEB-INF/templates/paying.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long rent_id = Long.valueOf(req.getParameter("id"));
        Rent rent = rentDao.find(rent_id).get();
        rent.setStatus(Status.PAID);
        System.out.println(rent.getStatus().name());
        rentDao.update(rent);
        resp.sendRedirect("/history");
    }
}
