package ru.itis.servlets;

import javafx.util.Pair;
import ru.itis.dao.impl.CommentDaoImpl;
import ru.itis.dao.impl.UserDaoImpl;
import ru.itis.models.Comment;
import ru.itis.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/comments")
public class CommentServlet extends HttpServlet {
    private CommentDaoImpl commentDao;
    private UserDaoImpl userDao;

    @Override
    public void init() throws ServletException {
        this.commentDao = new CommentDaoImpl();
        this.userDao = new UserDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Comment> comments = commentDao.findAll();
        Pair<Comment, User> pair;
        List<Pair<Comment, User>> pairs = new ArrayList<>();
        for (Comment comment: comments) {
            User user = userDao.find(comment.getUserId()).get();
            pair = new Pair<>(comment, user);
            pairs.add(pair);
        }
        req.setAttribute("items", pairs);
        req.getRequestDispatcher("/WEB-INF/templates/comments.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Comment comment;
        String text = (String) req.getAttribute("text");
        LocalDateTime date = LocalDateTime.now();
        HttpSession session = req.getSession();
        Long userId = (Long) session.getAttribute("user");
        comment = new Comment(text, userId, date);
        commentDao.save(comment);
        req.getServletContext().getRequestDispatcher("/comments").forward(req, resp);
    }
}
