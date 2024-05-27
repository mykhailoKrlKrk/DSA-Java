<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Stack Results</title>
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
    <h2>Stack Results</h2>
    <div class="form-container">
        <form action="${pageContext.request.contextPath}/stack" method="post">
            <textarea name="stackOne" rows="5" cols="50"></textarea><br>
            <input type="submit" value="Get Stack Characteristics">
        </form>
    </div>

    <c:if test="${numberOfElements ne 0}">
        <div class="result-container">
            <h2>Results:</h2>
            <table>
                <tr>
                    <th>Characteristic</th>
                    <th>Value</th>
                </tr>
                <tr>
                    <td>Number of Elements</td>
                    <td>${numberOfElements}</td>
                </tr>
                <tr>
                    <td>Minimum Element</td>
                    <td>${min}</td>
                </tr>
                <tr>
                    <td>Maximum Element</td>
                    <td>${max}</td>
                </tr>
            </table>
        </div>
    </c:if>
</div>
</body>
</html>
