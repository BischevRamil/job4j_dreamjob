package ru.job4j.dream.servlet;

import ru.job4j.dream.model.Post;
import ru.job4j.dream.store.Store;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("posts", Store.instOf().findAllPosts());
        request.getRequestDispatcher("posts.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Store.instOf().save(new Post(
                Integer.parseInt(request.getParameter("id")),
                request.getParameter("name"),
                request.getParameter("description"),
                request.getParameter("created")));
        response.sendRedirect(request.getContextPath() + "/posts/posts.do");
    }
}
