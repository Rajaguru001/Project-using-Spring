<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello</title>
</head>
<body>
<form action="/Register" >
 <table>
   	  
   	   <th>Login Page</th>
       
            <tr>
            
                <td>UserName</td>
                <td><input type="text" name="name" placeholder="UserName" required  pattern="[a-zA-Z]+"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" placeholder="Password"  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#&$]).{5,}" required ></td>
            </tr>
             <tr>
                <td>Email</td>
                <td><input type="email" name="email" placeholder="email" required ></td>
            </tr>
            
            <input type="submit" value="click">
            
           
        </table>
</form> 
</body>
</html>