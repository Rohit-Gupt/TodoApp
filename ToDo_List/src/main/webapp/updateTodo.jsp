<%@page import="com.mydata.model.Todo"%>
<%@page import="com.mydata.dao.TodoDalmpl"%>
<%@page import="com.mydata.dao.TodoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- <link rel="stylesheet" href="style.css"> -->
    <title>User Management Application</title>
    <style>

header{
    background-color: rgb(246, 86, 28);
    padding: 10px 10px;
}
body{
    margin-top: 0px;
}
footer{
    background-color: rgb(246, 86, 28);
    padding: 10px 10px;
    text-align: center;
    position: relative;
    color: aliceblue;
}
.logout{
    position: absolute;
    left: 91%;
    color: rgb(193, 195, 196);
    display: inline;
}
.todos{
    position: absolute;
    left: 7%;
    color: rgb(193, 195, 196);
    display: inline;

}
h1{
    
    position: relative;
    top: 10px;
    left: 10%;
    width: 300px;

    
}
Form,table{
    position: relative;
    left: 30%;
    width: 50px;
    
}
td{
    width: 400px;
}
.todoapp{
    color: azure;
    display: inline;
}
.javablue{
    font: 300;
    color: rgb(6, 6, 198);
}
.green{
    background-color: green;
    color:white;
}
.tbl{
    border-collapse: collapse;
    border: 1px solid gray;
}
.a{
    text-decoration: rgb(246, 248, 248);
    color: aliceblue;
}

    </style>
</head>
<body>
<%
String s = request.getParameter("title");
TodoDao td = new TodoDalmpl();
Todo t = td.viewTodoByTitle(s);

String title = (t != null) ? t.getTitle() : "";
String targetDate = (t != null && t.getTargetDate() != null) ? t.getTargetDate().toString() : "";
%>
<header><span class="todoapp">Todo App</span> <nav class="todos"> Todos</nav> <nav class="logout"><a class="a" href="Login.html">LogOut</a></nav> </header>
    <Form action="UpdateTodoServlet" method="post">
        <h1>Edit Todo</h1>
        <table>
            <tr>
                <td>
                    Todo Title
                </td>
            </tr>
            <tr>
                <td>
                    <input type="text" name="title" value="<%= title %>" readonly="readonly">
                </td>
            </tr>
            <tr>
                <td>
                    Todo Description
                </td>
            </tr>
            <tr>
                <td>
                    <input type="text" name="desc" >
                </td>
            </tr>
            <tr>
                <td>
                    Todo Status
                </td>
            </tr>
            <tr>
                <td>
                    <select name="status">
                        <option value="In Progress">In Progress&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
                        <option value="Completed">Completed&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    Todo Target Date
                </td>
            </tr>
            <tr>
                <td>
                    <input type="date" name="targetd" style="width: 160px;" value="<%= targetDate %>" readonly="readonly">
                </td>
            </tr>
            <tr>
                <td>
                    <input class="green" type="submit" value="Save">
                </td>
            </tr>
        </table>
    </Form>
<footer>&copy; <span class="todoapp">2019Copyright:</span><span class="javablue">JavaGuides</span></footer></body>
</html>