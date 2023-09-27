<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quick Sort</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
        }
        h1 {
            color: #333;
        }
        label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
        }
        #matrix {
            width: 100%;
            padding: 10px;
        }
        input[type="submit"] {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        table {
            margin-top: 20px;
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<h1>Quick Sort Matrix</h1>

<form action="/quick" method="post">
    <label for="matrix">Enter matrix (semicolon-separated rows, comma-separated values):</label><br>
    <textarea id="matrix" name="matrix" rows="5" cols="40">2,3,0;1,3,0;1,2.4;</textarea><br><br>
    <input type="submit" value="Sort">
</form>

<%
    double[][] sortedMatrix = (double[][]) request.getAttribute("sortedMatrix");
    List<double[][]> iterations = (List<double[][]>) request.getAttribute("iterations");

    if (sortedMatrix != null) {
%>
<h3>Sorted Matrix:</h3>
<table border="1">
    <% for (double[] matrixRow : sortedMatrix) { %>
    <tr>
        <% for (double element : matrixRow) { %>
        <td><%= element %></td>
        <% } %>
    </tr>
    <% } %>
</table>
<%
    }

    if (iterations != null && !iterations.isEmpty()) {
        int iterationNumber = 1;
        for (double[][] iteration : iterations) {
%>
<h3>Iteration <%= iterationNumber %>:</h3>
<table border="1">
    <% for (double[] matrixRow : iteration) { %>
    <tr>
        <% for (double element : matrixRow) { %>
        <td><%= element %></td>
        <% } %>
    </tr>
    <% } %>
</table>
<%
            iterationNumber++;
        }
    }
%>

</body>
</html>
