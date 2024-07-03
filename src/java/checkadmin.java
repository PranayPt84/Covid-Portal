/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author pranay
 */
public class checkadmin extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res){
       try{
           Class.forName("com.mysql.jdbc.Driver");
          Connection con= DriverManager.getConnection("jdbc:mysql://localhost/covidportal","root","12345");
          Statement stmt=con.createStatement();
            String uid=req.getParameter("uid");
             String password=req.getParameter("password");
             String sql="select * from admininfo";
             ResultSet rs=stmt.executeQuery(sql);
             PrintWriter out=res.getWriter();
             while(rs.next()){
                 String s1=rs.getString(2);
                 String s2=rs.getString(3);
                 if(s1.equals(uid) && s2.equals(password)){
                      // Redirect to example.html
        String contextPath = req.getContextPath(); // Context path of the web application
        String destinationUrl = contextPath + "/Add_data.html";

        // Perform the redirect
        res.sendRedirect(destinationUrl);
        break;
                 }
                 else{
                   out.print("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"<head>\n" +
"    <meta charset=\"UTF-8\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    <title>Invali_Userid_Password</title>\n" +
"    <style>\n" +
"        *{\n" +
"            margin: 0px;\n" +
"            padding: 0px;\n" +
"\n" +
"        }\n" +
"        body{\n" +
"            background-color: black;\n" +
"            color: white;\n" +
"            font-family: Georgia, 'Times New Roman', Times, serif;\n" +
"        }\n" +
"        .box{\n" +
"            width: 100%;\n" +
"            height: 56vh;\n" +
"            background-color: azure;\n" +
"\n" +
"        }\n" +
"        h2{\n" +
"            text-align: center;\n" +
"            font-size: 40px;\n" +
"            position: relative;\n" +
"            color: red;\n" +
"            top: 20vh;\n" +
"        }\n" +
"    </style>\n" +
"</head>\n" +
"<body>\n" +
"    <div class=\"box\">\n" +
"        <h2>Please enter valid Admins login Password!!</h2>\n" +
"    </div>\n" +
"</body>\n" +
"</html>"); 
                    break;
                 }
             }
       }
       catch(Exception e){
           e.printStackTrace();
       }
    }
}
