package ru.itis.servlets;

import ru.itis.dao.impl.BikeDaoImpl;
import ru.itis.dao.impl.ModelDaoImpl;
import ru.itis.models.Bike;
import ru.itis.models.Model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/bike")
public class BikeServlet extends HttpServlet {
    private ModelDaoImpl modelDao;
    private BikeDaoImpl bikeDao;

    @Override
    public void init() throws ServletException {
        this.bikeDao = new BikeDaoImpl();
        this.modelDao = new ModelDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<Bike> bike = bikeDao.find(Long.valueOf(req.getParameter("id")));
        Optional<Model> model = modelDao.find(bike.get().getModel_id());
        req.setAttribute("bike", bike.get());
        req.setAttribute("model", model.get());
        req.getServletContext().getRequestDispatcher("/WEB-INF/templates/bike.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
