package org.example.controller.sorting;

import java.io.IOException;

import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.algorithm.sorting.QuickSort;
import org.example.algorithm.sorting.impl.QuickSortImpl;

public class QuickSortController extends HttpServlet {
    private final QuickSort quickSort = new QuickSortImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/algorithms/sorting/quickSort.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] inputArrayStr = request.getParameter("inputArray").split(",");
        int[] inputArray = Arrays.stream(inputArrayStr)
                .mapToInt(Integer::parseInt)
                .toArray();



        int[] inputArrayCopy = Arrays.copyOf(inputArray, inputArray.length);
        quickSort.quickSort(inputArray, 0, inputArray.length - 1);
        List<int[]> iterations = quickSort.getIterations();

        request.setAttribute("inputArray", inputArrayCopy);
        request.setAttribute("iterations", iterations);

        request.getRequestDispatcher("/WEB-INF/views/algorithms/sorting/quickSort.jsp").forward(request, response);
    }

}
