<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.chainsys.spring.model.UserInfo"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Details</title>
<style>
    body {
        font-family: Arial, sans-serif;
    }
    table {
        width: 80%;
        margin: 20px auto;
        border-collapse: collapse;
    }
    th, td {
        padding: 10px;
        text-align: left;
        border: 1px solid #ddd;
    }
    th {
        background-color: #f2f2f2;
    }
    input[type="search"] {
        padding: 5px;
        margin-top: 20px;
        margin-right: 10px;
    }
    button[type="submit"] {
        padding: 5px 10px;
        background-color: #4CAF50;
        color: white;
        border: none;
        cursor: pointer;
    }
</style>
</head>
<body>
    <form action="/search" style="text-align: right;">
        <input type="search" name="name" placeholder="Search by username">
        <button type="submit">Search</button>
    </form>
    <table>
        <thead>
            <tr>
                <th>S/no</th>
                <th>Name</th>
                <th>Password</th>
                <th>Email</th>
                <th>Delete</th>
                <th>Edit</th>
            </tr>
        </thead>
        <tbody>
            <% 
            List<UserInfo> users = (List<UserInfo>) request.getAttribute("userdetails");
            int i = 1;
            for (UserInfo user : users) {
            %>
            <tr>
                <td><%= i++ %></td>
                <td><%= user.getUsername() %></td>
                <td><%= user.getPassword() %></td>
                <td><%= user.getEmail() %></td>
                <td>
                    <form action="/delete">
                        <input type="hidden" name="deleteid" value="<%= user.getUserid() %>">
                        <button type="submit">Delete</button>
                    </form>
                </td>
                <td>
                    <form action="Update.jsp">
                        <input type="hidden" name="updateid" value="<%= user.getUserid() %>">
                        <button type="submit">Update</button>
                    </form>
                </td>
            </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
