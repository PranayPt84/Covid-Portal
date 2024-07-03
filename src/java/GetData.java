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

public class GetData extends HttpServlet{
    

   
        public void procesRequest(HttpServletRequest req, HttpServletResponse res ) throws ServletException , IOException{
               try{
            Class.forName("com.mysql.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost/covidportal","root","12345");
              Statement stmt= con.createStatement();
                String country=req.getParameter("country");
              String sql="select * from CovidData where CountryName='"+country+"'"; 
            ResultSet rs= stmt.executeQuery(sql);
            PrintWriter out=res.getWriter();
            out.print("<html lang=\"en\">\n" +
"\n" +
"<head>\n" +
"    <meta charset=\"UTF-8\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    <title>Output_Page</title>\n" +
"    <style>\n" +
"        body {\n" +
"            background-color: black;\n" +
"            color: white;\n" +
"            font-family: Georgia, 'Times New Roman', Times, serif;\n" +
"        }\n" +
"\n" +
"        h2 {\n" +
"            width: 63vw;\n" +
"            text-align: center;\n" +
"            margin: 14vh auto;\n" +
"            font-size: 54px;\n" +
"            background-color: rgb(117 117 197);\n" +
"            color: black;\n" +
"            border-radius: 21px;\n" +
"        }\n" +
"\n" +
"        .box {\n" +
"            width: 70vw;\n" +
"            margin: 0vh auto;\n" +
"        }\n" +
"\n" +
"        .box h3 {\n" +
"            position: relative;\n" +
"            font-size: 32px;\n" +
"            padding: 10px;\n" +
"            left: 3vw;\n" +
"            width: 64vw;\n" +
"            border-radius: 10px;\n" +
"            background-color: #647bbe;\n" +
"        }\n" +
"\n" +
"        table {\n" +
"            text-align: center;\n" +
"            font-size: 21px;\n" +
"        }\n" +
"\n" +
"        .tcontainer {\n" +
"            text-align: center;\n" +
"            width: 65vw;\n" +
"            position: relative;\n" +
"            left: 3vw;\n" +
"        }\n" +
"\n" +
"        thead {\n" +
"            margin: 5px;\n" +
"            padding: 2px;\n" +
"        }\n" +
"\n" +
"        th {\n" +
"            padding: 18px 40px;\n" +
"\n" +
"\n" +
"        }\n" +
"\n" +
"        td {\n" +
"            padding: 17px 14px;\n" +
"        }\n" +
"    </style>\n" +
"</head>\n" +
"\n" +
"<body>");
            out.print(" <h2>Covid Portal of "+country+"</h2>");
            out.print(" <div class=\"box\">\n" +
"        <h3>The Detail of "+country+" is :-</h3>\n" +
"        <div class=\"tcontainer\">\n" +
"            <table border=\"1\">\n" +
"                <thead>\n" +
"                    <th>Sno</th>\n" +
"                    <th>Country_Name</th>\n" +
"                    <th>Active_Case</th>\n" +
"                    <th>Total_Dath</th>\n" +
"                    <th>Total_Case</th>\n" +
"                </thead>\n" +
"                <tbody>\n" +
"                    <tr>");
            rs.next();
           out.print("  <td>"+rs.getString(1)+"</td>");
           out.print("  <td>"+rs.getString(2)+"</td>");
           out.print("  <td>"+rs.getString(3)+"</td>");
           out.print("  <td>"+rs.getString(4)+"</td>");
           out.print("  <td>"+rs.getString(5)+"</td>");
            out.print(" </tr>\n" +
"                </tbody>\n" +
"            </table>\n" +
"        </div>\n" +
"    </div>\n" +
"</body>\n" +
"\n" +
"</html>");
            
               }
        catch(Exception e){
            e.printStackTrace();
            
        }               
        }
        public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
            procesRequest(req,res);
        }
         public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
            procesRequest(req,res);
        }
}
