<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome to DSA in Java</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f4f4;
            color: #fff;
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
            background-color: #ffffff;
        }
        h1 {
            font-size: 28px;
            margin-top: 0;
            color: #d9534f; /* Червоний */
        }
        a {
            color: #fff; /* Білий */
            text-decoration: none;
            transition: color 0.3s ease;
        }
        a:hover {
            color: #245269; /* Темно-синій */
            text-decoration: underline;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 15px;
            text-align: center;
            border-bottom: 1px solid #ddd;
            color: #fff; /* Білий */
        }
        th {
            background-color: #d9534f; /* Червоний */
        }
        td {
            background-color: #31708f; /* Синій */
        }
    </style>
</head>
<body>
<form method="post" id="redirect"></form>
<div class="container">
    <h1>Welcome to DSA in Java</h1>
    <table>
        <tr>
            <th>Sorting Algorithms</th>
        </tr>
        <tr><td><a href="${pageContext.request.contextPath}/selection">Selection Sort</a></td></tr>
        <tr><td><a href="${pageContext.request.contextPath}/shell">Shell Sort</a></td></tr>
        <tr><td><a href="${pageContext.request.contextPath}/quick">Quick Sort</a></td></tr>
        <tr><td><a href="${pageContext.request.contextPath}/merge">Merge Sort</a></td></tr>
        <tr><td><a href="${pageContext.request.contextPath}/counting">Counting Sort</a></td></tr>
        <tr>
            <th>Data Structures</th>
        </tr>
        <tr><td><a href="${pageContext.request.contextPath}/stack">Stack</a></td></tr>
        <tr><td><a href="${pageContext.request.contextPath}/three">Binary Search Three</a></td></tr>
        <tr>
            <th>Searching Algorithms</th>
        </tr>
        <tr><td><a href="${pageContext.request.contextPath}/binarySearch">Binary Search</a></td></tr>
        <tr><td><a href="${pageContext.request.contextPath}/kmpAlgorithm">KMP Search Algorithm</a></td></tr>
        <tr><td><a href="${pageContext.request.contextPath}/boyerMooreSearch">Boyer-Moore Search</a></td></tr>
    </table>
</div>
</body>
</html>
