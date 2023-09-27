<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sorting and Filtering Products</title>
    <style>
        /* Загальні стилі */
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            color: #333;
            margin: 0;
            padding: 0;
        }
        /* Стилізуємо форму */
        form {
            margin: 20px;
            text-align: center;
        }
        /* Стилізуємо вхідний і вихідний блоки */
        .input-block, .output-block {
            margin: 20px auto;
            padding: 20px;
            border-radius: 10px;
            max-width: 600px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.3);
            background-color: #fff;
        }
        /* Стилі для заголовків */
        h2 {
            font-size: 24px;
            margin-top: 0;
            color: #333;
        }
        /* Стилізуємо кнопку */
        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        /* Стилізуємо списки */
        ul {
            list-style-type: none;
            padding: 0;
        }
        li {
            margin: 5px 0;
            background-color: #f9f9f9;
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ddd;
            color: #333;
        }
        /* Додав стилі для кольорового розмежування */
        li:nth-child(odd) {
            background-color: #e5e5e5;
        }
    </style>
</head>
<body>
<div class="input-block">
    <h2>Enter a list of products:</h2>
    <form action="${pageContext.request.contextPath}/selection" method="post">
        <textarea name="productData" rows="5" cols="50"></textarea><br>
        <input type="submit" value="Sort and Filter">
    </form>
</div>

<c:if test="${not empty result}">
    <div class="output-block">
        <h2>Result:</h2>
        <p>Вхідний масив:</p>
        <ul>
            <c:forEach items="${products}" var="product">
                <li>${product}</li>
            </c:forEach>
        </ul>
        <p>Результат:</p>
        <ul>
            <c:forEach items="${result}" var="product">
                <li>${product}</li>
            </c:forEach>
        </ul>
    </div>
</c:if>
</body>
</html>
