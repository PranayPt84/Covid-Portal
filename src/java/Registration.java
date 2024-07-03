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
 
public class Registration extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            PrintWriter out=response.getWriter();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/covidportal","root","12345");
            String sql="insert into registration values(?,?,?,?,?)";
          PreparedStatement ps=  con.prepareStatement(sql);
       String uid=request.getParameter("uid");
       String password=request.getParameter("password");
          String confirmpassword=request.getParameter("confirmpassword");
          String mail=request.getParameter("mail");
          String name=request.getParameter("name");
          String number=request.getParameter("number");
          if(password.equals(confirmpassword)){
          ps.setString(1, uid);
          ps.setString(2, password);
          ps.setString(3, mail);
          ps.setString(4, name);
          ps.setString(5, number);
          
          ps.executeUpdate();
          
         
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
"</html> ");
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
"        <h2>Please check  Password!!</h2>\n" +
"    </div>\n" +
"</body>\n" +
"</html> " );
          }
          
        }
          catch (Exception e){
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
