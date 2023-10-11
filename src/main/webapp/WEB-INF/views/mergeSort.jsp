<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Merge Sort Example</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
            background-color: #f0f0f0;
            color: #333;
            margin: 0;
        }

        h1 {
            color: #333;
        }

        form {
            margin-bottom: 20px;
        }

        input[type="text"] {
            padding: 10px;
            width: 200px;
        }

        button[type="submit"] {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }

        button[type="submit"]:hover {
            background-color: #45a049;
        }

        h3 {
            margin-top: 20px;
            color: #333;
        }

        p {
            color: #555;
        }

        /* Додані стилі для таблиці */
        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<form action="/merge" method="post">
    Enter integers separated by commas:
    <input type="text" name="inputArray">
    <button type="submit">Sort</button>
</form>

<h3>Input Array:</h3>
<p>${inputArray}</p>

<h3>Sorted Array:</h3>
<p>${sortedArray}</p>

<h3>Intermediate Iterations:</h3>
<table>
    <tr>
        <th>Iteration</th>
        <th>Array</th>
    </tr>
    <c:forEach items="${intermediateIterations}" var="iteration" varStatus="status">
        <tr>
            <td>Iteration ${status.index + 1}</td>
            <td>
                    ${fn:join(iteration, ', ')}
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
