<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>KMP Algorithm</title>

    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
            background-color: #f5f5f5;
        }

        .container {
            width: 400px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            box-sizing: border-box;
        }

        h2 {
            color: #333;
            text-align: center;
        }

        form {
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 10px;
            font-size: 14px;
            color: #555;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 14px;
        }

        input[type="submit"] {
            width: 100%;
            padding: 12px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        p {
            margin-bottom: 10px;
            text-align: center;
            font-size: 14px;
            color: #555;
        }

        h3 {
            color: #333;
            text-align: center;
            margin-top: 20px;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
            font-size: 14px;
            color: #333;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>KMP Algorithm</h2>

    <form action="${pageContext.request.contextPath}/kmpAlgorithm" method="post">
        <label>Enter Text 1:</label>
        <input type="text" name="text1" required>

        <label>Enter Text 2:</label>
        <input type="text" name="text2" required>

        <input type="submit" value="Submit">
    </form>

    <c:if test="${not empty result}">
        <h3>KMP Algorithm Result:</h3>
        <p>Shortest Word: ${result.shortestWord}</p>
        <p>Index in Text 2: ${result.index}</p>
    </c:if>
</div>

</body>
</html>
