<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Boyer-Moore Search Results</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            text-align: center;
        }

        h2 {
            color: #333;
        }

        form {
            margin: 20px auto;
            width: 50%;
        }

        label {
            display: block;
            margin-bottom: 5px;
            text-align: left;
        }

        input[type="text"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
        }

        input[type="submit"] {
            padding: 8px 15px;
            background-color: #007bff;
            color: #fff;
            border: none;
            cursor: pointer;
        }

        p {
            margin-bottom: 10px;
            text-align: left;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            margin: 20px auto;
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

<h2>Boyer-Moore Search Results</h2>

<div>
    <%-- Форма для вводу двох рядків тексту --%>
    <form action="${pageContext.request.contextPath}/boyerMooreSearch" method="post">
        <label>Enter Text 1:</label>
        <input type="text" name="text1" required><br>

        <label>Enter Text 2:</label>
        <input type="text" name="text2" required><br>

        <input type="submit" value="Submit">
    </form>
</div>

<c:if test="${not empty searchResults}">
    <h3>Boyer-Moore Search Results:</h3>
    <p>Enter Text 1: ${param.text1}</p>
    <p>Enter Text 2: ${param.text2}</p>
    <p>Indexes in descending order: ${searchResults}</p>
</c:if>

</body>
</html>
