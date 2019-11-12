package ru.itis.servlets;

import javafx.util.Pair;
import ru.itis.dao.impl.BikeDaoImpl;
import ru.itis.dao.impl.ModelDaoImpl;
import ru.itis.dao.impl.StationDaoImpl;
import ru.itis.models.Bike;
import ru.itis.models.Model;
import ru.itis.models.Station;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet("/station")
public class StationServlet extends HttpServlet {
    private StationDaoImpl stationDao;
    private BikeDaoImpl bikeDao;
    private ModelDaoImpl modelDao;

    @Override
    public void init() throws ServletException {
        this.stationDao = new StationDaoImpl();
        this.bikeDao = new BikeDaoImpl();
        this.modelDao = new ModelDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") != null) {
            Optional<Station> station = stationDao.find(Long.valueOf(req.getParameter("id")));
            List<Bike> bikes = bikeDao.findAllByStationId(station.get().getId());
            Pair<Bike, Model> pair;
            List<Pair<Bike, Model>> pairs = new ArrayList<>();
            for (Bike bike : bikes) {
                pairs.add(new Pair<>(bike, modelDao.find(bike.getModel_id()).get()));
            }
            req.setAttribute("items", pairs);
            req.setAttribute("station", station.get());
        } else {
            req.setAttribute("error_no_station", "Станция не сущесвтует");
        }
        req.getServletContext().getRequestDispatcher("/WEB-INF/templates/station.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
