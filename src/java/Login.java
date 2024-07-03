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
        public class Login extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        try {
             Class.forName("com.mysql.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost/covidportal","root","12345");
          Statement stmt=con.createStatement();
                String sql="select uid , password from registration"; 
               ResultSet rs=stmt.executeQuery(sql);
            String uid=request.getParameter("uid");
            String password=request.getParameter("password");
              rs.next();
              String s1=rs.getString(1);
              String s2=rs.getString(2);
            if(s1.equals(uid) && s2.equals(password)){
               String path= request.getContextPath();
               String finalPath=path+"/Getinfo";
               response.sendRedirect(finalPath);
            }
            else{
                out.println("<!DOCTYPE html>\n" +
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
"        <h2>Plese enter valid login Password!!</h2>\n" +
"    </div>\n" +
"</body>\n" +
"</html>");
            }
                
        }
        catch(Exception e){
                out.println(e);
                }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
