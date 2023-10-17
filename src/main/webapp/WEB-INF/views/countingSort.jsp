<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Shallow Sort Results</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f0f0f0;
      color: #333;
      margin: 0;
      padding: 0;
    }
    .input-block, .output-block {
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
      color: #333;
    }
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
    table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 10px;
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
<div class="input-block">
  <h2>Enter an array of integers (comma-separated):</h2>
  <form action="${pageContext.request.contextPath}/counting" method="post">
    <textarea name="inputArray" rows="5" cols="50"></textarea><br>
    <input type="submit" value="Sort">
  </form>
</div>

<c:if test="${not empty inputArray}">
  <div class="output-block">
    <h2>Results:</h2>
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
</body>
</html>