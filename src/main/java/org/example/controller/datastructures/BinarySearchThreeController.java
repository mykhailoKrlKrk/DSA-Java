package org.example.controller.datastructures;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.example.datastructures.BinarySearchThree;
import org.example.datastructures.impl.BinarySearchThreeImpl;


public class BinarySearchThreeController extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/datastructures/bst.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        BinarySearchThree binarySearchThree = new BinarySearchThreeImpl();

        String[] numbers = req.getParameter("numbers").split(",");
        List<Double> list = Arrays.stream(numbers)
                .map(Double::parseDouble)
                .toList();

        for (Double element : list) {
            binarySearchThree.insert(element);
        }

        int height = binarySearchThree.height();
        ArrayList<Double> preOrderTraversal = binarySearchThree.DFSPreOrder();
        boolean contains = binarySearchThree.contains(2.0);
        Double node = binarySearchThree.findNode(2.0).value;
        Double parent = binarySearchThree.getParent(node).value;
        ArrayList<Double> descendants = binarySearchThree.getDescendants(node);

        req.setAttribute("binarySearchThree", binarySearchThree);
        req.setAttribute("height", height);
        req.setAttribute("preOrderTraversal", preOrderTraversal);
        req.setAttribute("contains", contains);
        req.setAttribute("parent", parent);
        req.setAttribute("descendants", descendants);

        req.getRequestDispatcher("/WEB-INF/views/datastructures/bst.jsp")
                .forward(req, resp);
    }
}
