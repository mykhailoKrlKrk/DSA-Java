package org.example.controller.search;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.example.algorithm.search.BinarySearch;
import org.example.algorithm.search.impl.BinarySearchImpl;

public class BinarySearchController extends HttpServlet {
    public static final BinarySearch binarySearch = new BinarySearchImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/algorithms/search/binarySearch.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String[] booksArray = req.getParameter("booksArray").split(",");

        String[] pricesArray = req.getParameter("prices").split(",");
        List<Integer> prices = Arrays.stream(pricesArray).map(Integer::parseInt).toList();

        String targetBook = req.getParameter("book");


        int price = binarySearch.binarySearchBookPrice(booksArray, prices, targetBook);
        List<String[]> iterations = binarySearch.getIterations();

        req.setAttribute("books", booksArray);
        req.setAttribute("prices", prices);
        req.setAttribute("bookToFind", targetBook);
        req.setAttribute("targetPrice", price);
        req.setAttribute("iterations", iterations);

        req.getRequestDispatcher("/WEB-INF/views/algorithms/search/binarySearch.jsp")
                .forward(req, resp);

    }
}
