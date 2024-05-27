package org.example.controller.datastructures;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.example.datastructures.Stack;
import org.example.datastructures.impl.StackImpl;

public class StackController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/datastructures/stack.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stackOne = request.getParameter("stackOne");

        Stack stack = new StackImpl();

        List<Double> numbersOne = Arrays.stream(stackOne.split(","))
                .map(Double::parseDouble)
                .toList();

        for (Double number : numbersOne) {
            stack.push(number);
        }
        int numberOfElements = stack.size();
        Double min = stack.findMin();
        Double max = stack.findMax();

        request.setAttribute("numberOfElements", numberOfElements);
        request.setAttribute("min", min);
        request.setAttribute("max", max);

        request.getRequestDispatcher("/WEB-INF/views/datastructures/stack.jsp")
                .forward(request, response);
    }
}
