package org.example.controller.search;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.example.algorithm.search.KMPAlgorithm;
import org.example.algorithm.search.impl.KMPAlgorithmImpl;

public class KMPAlgorithmController extends HttpServlet {
    public static final KMPAlgorithm kmpAlgorithm= new KMPAlgorithmImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/algorithms/search/kmpResult.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String[] text1Array = req.getParameterValues("text1");
        String[] text2Array = req.getParameterValues("text2");

        if (text1Array != null && text2Array != null) {
            String text1 = String.join(" ", text1Array).toLowerCase();
            String text2 = String.join(" ", text2Array).toLowerCase();

            KMPAlgorithm.Result result = kmpAlgorithm.findShortestWordAndIndex(text1, text2);

            req.setAttribute("result", result);
        }

        req.getRequestDispatcher("/WEB-INF/views/algorithms/search/kmpResult.jsp")
                .forward(req, resp);

    }
}
