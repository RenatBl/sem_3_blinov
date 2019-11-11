package ru.itis.servlets;

import ru.itis.dao.impl.StationDaoImpl;
import ru.itis.models.Station;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    private StationDaoImpl stationDao;

    @Override
    public void init() throws ServletException {
        stationDao = new StationDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Station> stations = stationDao.findAll();
        if (!stations.isEmpty()) {
            req.setAttribute("stations", stations);
        } else {
            req.setAttribute("error_no_stations", "Станции не найдены");
        }
        req.getServletContext().getRequestDispatcher("/WEB-INF/templates/main.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
