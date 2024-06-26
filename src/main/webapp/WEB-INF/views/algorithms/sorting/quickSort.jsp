<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quick Sort</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            color: #333;
            margin: 0;
            padding: 0;
            text-align: center;
        }
        .container {
            margin: 20px auto;
            padding: 20px;
            border-radius: 10px;
            max-width: 600px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.3);
            background-color: #fff;
        }
        h2 {
            font-size: 24px;
            margin-top: 0;
            color: #d9534f; /* Червоний */
        }
        .form-container {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
        }
        .form-container form {
            margin-bottom: 20px;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
            margin-top: 10px;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #d9534f; /* Червоний */
            color: #fff;
        }
        td {
            background-color: #31708f; /* Синій */
            color: #fff;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Quick Sort</h2>
    <div class="form-container">
        <form action="${pageContext.request.contextPath}/quick" method="post">
            <textarea name="inputArray" rows="5" cols="50"></textarea><br>
            <input type="submit" value="Sort">
        </form>
    </div>

    <c:if test="${not empty inputArray}">
        <h2>Results:</h2>
        <div class="result-container">
            <p>Input Array:</p>
            <table>
                <tr>
                    <th>Index</th>
                    <th>Value</th>
                </tr>
                <c:forEach items="${inputArray}" var="element" varStatus="status">
                    <tr>
                        <td>${status.index}</td>
                        <td>${element}</td>
                    </tr>
                </c:forEach>
            </table>
            <p>Iteration Details:</p>
            <table>
                <tr>
                    <th>Iteration</th>
                    <th>Array</th>
                </tr>
                <c:forEach items="${iterations}" var="iteration" varStatus="status">
                    <tr>
                        <td>Iteration ${status.index + 1}</td>
                        <td>
                            <c:forEach items="${iteration}" var="element">
                                ${element},
                            </c:forEach>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </c:if>
</div>
</body>
</html>
