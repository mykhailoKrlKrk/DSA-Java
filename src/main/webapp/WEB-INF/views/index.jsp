<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            color: #333;
            margin: 0;
            padding: 0;
        }
        .table {
            margin: 20px auto;
            padding: 20px;
            border-radius: 10px;
            max-width: 600px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.3);
            background-color: #fff;
        }
        h1 {
            font-size: 24px;
            margin-top: 0;
            color: #333;
        }
        a {
            color: #007bff;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
    </style>
</head>
<body>
<form method="post" id="redirect"></form>
<h1 class="table">Choose sorting algorithm</h1>
<table class="table">
    <tr>
        <th>Redirect to</th>
    </tr>
    <tr><td><a href="${pageContext.request.contextPath}/selection">Use Selection Sort</a></td></tr>
    <tr><td><a href="${pageContext.request.contextPath}/shell">Use Shell Sort</a></td></tr>
    <tr><td><a href="${pageContext.request.contextPath}/quick">Use Quick Sort</a></td></tr>
    <tr><td><a href="${pageContext.request.contextPath}/merge">Use Merge Sort</a></td></tr>
    <tr><td><a href="${pageContext.request.contextPath}/counting">Use Counting Sort</a></td></tr>
</table>
</body>
</html>
