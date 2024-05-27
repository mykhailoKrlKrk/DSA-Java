<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Binary Search Results</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        h2 {
            color: #d9534f; /* Червоний */
        }

        form {
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        input[type="text"] {
            width: 300px;
            padding: 5px;
            margin-bottom: 10px;
        }

        input[type="submit"] {
            padding: 8px 15px;
            background-color: #d9534f; /* Червоний */
            color: #fff;
            border: none;
            cursor: pointer;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
            color: #333;
        }

        p {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>

<h2>Binary Search Results</h2>

<div>
    <%-- Форма для вводу масиву книг та книги для пошуку --%>
    <form action="${pageContext.request.contextPath}/binarySearch" method="post">
        <label>Enter books (format: book:price, separated by commas):</label>
        <input type="text" name="booksArray" required><br>

        <label>Enter prices (comma-separated):</label>
        <input type="text" name="prices" required><br>

        <label>Enter the book to search:</label>
        <input type="text" name="book" required><br>

        <input type="submit" value="Search">
    </form>
</div>

<%-- Виведення результатів --%>
<c:if test="${not empty books}">
    <h3>Search Results:</h3>
    <p>Array of books:</p>
    <table>
        <tr>
            <th>Index</th>
            <th>Value</th>
        </tr>
        <c:forEach items="${books}" var="book" varStatus="status">
            <tr>
                <td>${status.index}</td>
                <td>${book}</td>
            </tr>
        </c:forEach>
    </table>

    <p>Array of prices:</p>
    <table>
        <tr>
            <th>Index</th>
            <th>Value</th>
        </tr>
        <c:forEach items="${prices}" var="price" varStatus="status">
            <tr>
                <td>${status.index}</td>
                <td>${price}</td>
            </tr>
        </c:forEach>
    </table>

    <p>Book to search: ${bookToFind}</p>
    <p>Book price: ${targetPrice}</p>
</c:if>

<h3>Search Iterations:</h3>
<table>
    <tr>
        <th>Iteration</th>
        <th>Array</th>
    </tr>
    <c:forEach items="${iterations}" var="iteration" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>
                <c:forEach items="${iteration}" var="element">
                    ${element}
                </c:forEach>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
