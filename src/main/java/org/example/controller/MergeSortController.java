package org.example.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.example.algorithm.MergeSort;
import org.example.algorithm.impl.MergeSortImpl;

public class MergeSortController extends HttpServlet {
    private final MergeSort mergeSort = new MergeSortImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/mergeSort.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] inputArrayStr = request.getParameter("inputArray").split(",");
        int[] inputArray = Arrays.stream(inputArrayStr)
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] inputArrayCopy = Arrays.copyOf(inputArray, inputArray.length);
        mergeSort.mergeSort(inputArray, 0, inputArray.length - 1);

        List<int[]> intermediateIterations = ((MergeSortImpl) mergeSort).getIntermediateIterations();

        request.setAttribute("inputArray", Arrays.toString(inputArrayCopy));
        request.setAttribute("iterations", intermediateIterations);

        request.getRequestDispatcher("/WEB-INF/views/mergeSort.jsp").forward(request, response);
    }
}
