package ru.job4j.dream.servlet;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.store.MemStore;
import ru.job4j.dream.store.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CandidateServlet")
public class CandidateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        PsqlStore.instOf().save(new Candidate(
                Integer.parseInt(request.getParameter("id")),
                request.getParameter("name")));
        response.sendRedirect(request.getContextPath() + "/candidates/candidates.do");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("candidates", PsqlStore.instOf().findAllCandidates());
        request.getRequestDispatcher("candidates.jsp").forward(request, response);
    }
}
