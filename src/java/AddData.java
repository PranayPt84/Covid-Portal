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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author pranay
 */
public class AddData extends HttpServlet {

    public void doGet(HttpServletRequest req,HttpServletResponse res){
                 try{
                     
            
            Class.forName("com.mysql.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost/covidportal","root","12345");
             String sql=" insert into coviddata (CountryName , ActiveCase ,Deths,TotalCase) values(?,?,?,?)";     
        PreparedStatement pstmt= con.prepareStatement(sql);
       pstmt.setString(1, req.getParameter("CountryName"));
       pstmt.setString(2, req.getParameter("ActiveCase"));
       pstmt.setString(3, req.getParameter("Deths"));
       pstmt.setString(4, req.getParameter("TotalCase"));
       pstmt.executeUpdate();
       PrintWriter out=res.getWriter();
       out.print("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"\n" +
"<head>\n" +
"    <meta charset=\"UTF-8\">\n" +
"    <meta name=\"viewport\" content=\"width=, initial-scale=1.0\">\n" +
"    <title>Data_Added</title>\n" +
"    <style>\n" +
"        body {\n" +
"            margin: 0px;\n" +
"            padding: 0px;\n" +
"            background-color: black;\n" +
"            color: white;\n" +
"            font-family: Georgia, 'Times New Roman', Times, serif;\n" +
"        }\n" +
"\n" +
"        .container {\n" +
"            height: 40vh;\n" +
"            width: 100%;\n" +
"            background-color: #32ad09;\n" +
"            margin-top: 0px;\n" +
"            padding: 0px;\n" +
"\n" +
"        }\n" +
"\n" +
"        h2 {\n" +
"            text-align: center;\n" +
"            font-size: 30px;\n" +
"            position: relative;\n" +
"            top: 13vh;\n" +
"            margin: 0px;\n" +
"\n" +
"        }\n" +
"    </style>\n" +
"</head>\n" +
"\n" +
"<body>\n" +
"    <div class=\"container\">\n" +
"        <h2>\n" +
"            Successfully Data Added !!\n" +
"        </h2>\n" +
"    </div>\n" +
"</body>\n" +
"\n" +
"</html>");
    }
          
                            
      catch(Exception e){
          e.printStackTrace();
      }
   
             
      
    }
}
