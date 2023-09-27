package org.example.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.example.algorithm.SelectionSort;
import org.example.algorithm.impl.SelectionSortImpl;

public class SortingController extends HttpServlet {
    private final SelectionSort selectionSort = new SelectionSortImpl();


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/selection.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productData = request.getParameter("productData");

        List<String> products = Arrays.asList(productData.split("\n"));
        List<String> sortedAndFilteredProducts = selectionSort.sortAndFilterProducts(products);

        request.setAttribute("products", products);
        request.setAttribute("result", sortedAndFilteredProducts);

        request.getRequestDispatcher("/WEB-INF/views/selection.jsp").forward(request, response);
    }
}
