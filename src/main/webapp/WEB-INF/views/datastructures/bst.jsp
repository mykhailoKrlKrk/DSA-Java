<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Binary Search Tree Results</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f0f0f0;
      color: #333;
      margin: 0;
      padding: 0;
      display: flex;
      justify-content: center;
      align-items: flex-start; /* Align at the top */
      min-height: 100vh; /* Ensure full height */
    }
    .container {
      max-width: 600px;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      background-color: #fff;
      padding: 20px;
      margin: 20px;
      text-align: center;
    }
    h2 {
      font-size: 24px;
      margin-top: 0;
      color: #d9534f; /* Червоний */
    }
    input[type="text"] {
      width: calc(100% - 22px);
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 5px;
      margin-top: 10px;
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
      background-color: #f2f2f2;
    }
  </style>
</head>
<body>
<div class="container">
  <h2>Binary Search Tree Results</h2>
  <form action="${pageContext.request.contextPath}/three" method="post">
    <input type="text" name="numbers">
    <input type="submit" value="Insert Numbers into Binary Search Tree">
  </form>

  <c:if test="${binarySearchThree ne null}">
    <h2>Binary Search Tree Characteristics:</h2>
    <table>
      <tr>
        <th>Characteristic</th>
        <th>Value</th>
      </tr>
      <tr>
        <td>Height of Tree</td>
        <td>${height}</td>
      </tr>
      <tr>
        <td>Pre-order Traversal</td>
        <td>
          <c:forEach var="element" items="${preOrderTraversal}">
            ${element}
            <c:if test="${!loop.last}">,</c:if>
          </c:forEach>
        </td>
      </tr>
      <tr>
        <td>Contains value 2.0</td>
        <td>${contains}</td>
      </tr>
      <tr>
        <td>Parent Node for value 2.0</td>
        <td>${parent}</td>
      </tr>
      <tr>
        <td>Descendants Nodes for value 2.0</td>
        <td>
          <c:forEach var="element" items="${descendants}">
            ${element}
            <c:if test="${!loop.last}">,</c:if>
          </c:forEach>
        </td>
      </tr>
    </table>
  </c:if>
</div>
</body>
</html>
