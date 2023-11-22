<%@page import="com.mydata.model.Todo"%>
<%@page import="java.util.List"%>
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
    width: 500px;
    
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
table,tr,td{
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
    <header><span class="todoapp">Todo App</span> <nav class="todos"> Todos</nav> <nav class="logout"><a class="a" href="Login.jsp">LogOut</a></nav> </header>
    <Form action="AddTodo.html">
        <h1>List of Todos</h1>
        <hr>
        <input type="submit" value="Add Todo" class="green" >
    </Form>
    <table>
        <tr>
            <td>
                Title
            </td>
            <td>
                Target Date
            </td>
            <td>
                Todo Status 
            </td>
            <td>
                Actions
            </td>
        </tr>
        <%
        TodoDao td = new TodoDalmpl();
        List<Todo> list = td.viewAllTodo();
        for(Todo t:list){
        %>
        <tr>
            <td>
                <%=t.getTitle() %>
            </td>
            <td>
                <%=t.getTargetDate()%>
            </td>
            <td>
                <%=t.getStatus() %>
            </td>
            <td>
            <a href="updateTodo.jsp?title=<%=t.getTitle() %>&status=<%=t.getStatus() %>">Edit</a>
            </td>
            <td>
             <a href="deleteTodo.jsp?title=<%=t.getTitle() %>">Delete</a>
            </td>
        </tr>
        <%}%>
    </table>
    <br>
    <br>
    
    
<footer>&copy; <span class="todoapp">2019Copyright:</span><span class="javablue">JavaGuides</span></footer>
    
</body>
</html>