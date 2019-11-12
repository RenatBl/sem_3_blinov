package ru.itis.servlets;

import ru.itis.dao.impl.BikeDaoImpl;
import ru.itis.dao.impl.RentDaoImpl;
import ru.itis.dao.impl.UserDaoImpl;
import ru.itis.models.Bike;
import ru.itis.models.Rent;
import ru.itis.models.User;
import ru.itis.models.enums.Status;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;

@WebServlet("/rent")
public class RentServlet extends HttpServlet {
    private RentDaoImpl rentDao;
    private BikeDaoImpl bikeDao;
    @Override
    public void init() throws ServletException {
        this.rentDao = new RentDaoImpl();
        this.bikeDao = new BikeDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("time", LocalDateTime.now());
        Long id = Long.valueOf(req.getParameter("id"));
        req.setAttribute("id", id);
        req.getRequestDispatcher("/WEB-INF/templates/rent.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Rent rent;
        Long bikeId = Long.valueOf(req.getParameter("id"));
        System.out.println(bikeId);
        HttpSession session = req.getSession();
        Long userId = (Long) session.getAttribute("user");
        System.out.println(userId);
        Bike bike = bikeDao.find(bikeId).get();
        LocalDateTime start_time = LocalDateTime.now().minusHours((long)(Math.random() * 9));
        LocalDateTime finish_time = LocalDateTime.now();
        System.out.println(finish_time);
        Integer time;
        if (finish_time.getHour() - start_time.getHour() > 0) {
            time = finish_time.getHour() - start_time.getHour();
        } else {
            time = 1;
        }
        System.out.println(time);
        Double cost = bike.getPrice() * time;
        Status status = Status.UNPAID;
        rent = new Rent(userId, bikeId, bike.getStation_id(), time, cost, start_time,
                finish_time, status);
        rentDao.save(rent);
        resp.sendRedirect("/main");
    }
}
