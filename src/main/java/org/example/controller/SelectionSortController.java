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

public class SelectionSortController extends HttpServlet {
    private final SelectionSort selectionSort = new SelectionSortImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/selectionSort.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] inputArrayString = request.getParameter("inputArray").split(",");

        int[] inputArray = Arrays.stream(inputArrayString)
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] inputArrayCopy = Arrays.copyOf(inputArray, inputArray.length);
        List<int[]> iterations = selectionSort.selectionSort(inputArray);

        request.setAttribute("inputArray", inputArrayCopy);
        request.setAttribute("iterations", iterations);
        request.getRequestDispatcher("/WEB-INF/views/selectionSort.jsp").forward(request, response);
    }
}
