package org.example.controller.sorting;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.example.algorithm.sorting.ShallSort;
import org.example.algorithm.sorting.impl.ShellSortImpl;

public class ShellSortController extends HttpServlet {
    private final ShallSort shallSort = new ShellSortImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/algorithms/sorting/shellSort.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] inputArrayStr = request.getParameter("inputArray").split(",");
        int[] inputArray = Arrays.stream(inputArrayStr)
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] inputArrayCopy = Arrays.copyOf(inputArray, inputArray.length);
        List<int[]> ints = shallSort.shallSort(inputArray);

        request.setAttribute("inputArray", inputArrayCopy);
        request.setAttribute("iterations", ints);

        request.getRequestDispatcher("/WEB-INF/views/algorithms/sorting/shellSort.jsp").forward(request, response);
    }
}
