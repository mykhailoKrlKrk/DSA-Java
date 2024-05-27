package org.example.controller.search;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.example.algorithm.search.BoyerMooreSearch;
import org.example.algorithm.search.impl.BoyerMooreSearchImpl;

public class BoyerMooreSearchController extends HttpServlet {
    public static final BoyerMooreSearch boyerMooreSearch = new BoyerMooreSearchImpl();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/algorithms/search/boyerMooreSearch.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String text1 = req.getParameter("text1");
        String text2 = req.getParameter("text2");


        List<Integer> searchResults = boyerMooreSearch.search(text1, text2);

        req.setAttribute("searchResults", searchResults);
        req.getRequestDispatcher("/WEB-INF/views/algorithms/search/boyerMooreSearch.jsp")
                .forward(req, resp);
    }
}
