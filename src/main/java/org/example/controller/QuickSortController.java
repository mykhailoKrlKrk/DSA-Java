package org.example.controller;

import java.io.IOException;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.algorithm.QuickSort;
import org.example.algorithm.impl.QuickSortImpl;

public class QuickSortController extends HttpServlet {
    private final QuickSort quickSort = new QuickSortImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/matrixResult.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String matrixInput = request.getParameter("matrix");
        String[] rows = matrixInput.split(";");

        int numRows = rows.length;
        int numCols = rows[0].split(",").length;
        double[][] matrix = new double[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            String[] rowValues = rows[i].split(",");
            for (int j = 0; j < numCols; j++) {
                matrix[i][j] = Double.parseDouble(rowValues[j]);
            }
        }

        quickSort.quickSortColumns(matrix, 0, numCols - 1);

        List<double[][]> iterations = ((QuickSortImpl) quickSort).getIterations();

        request.setAttribute("sortedMatrix", matrix);
        request.setAttribute("iterations", iterations);
        request.getRequestDispatcher("/WEB-INF/views/matrixResult.jsp").forward(request, response);
    }

}
