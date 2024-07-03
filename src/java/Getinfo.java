
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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Getinfo extends HttpServlet {
  public void procesRequest(HttpServletRequest req, HttpServletResponse res)
  throws ServletException,IOException, ClassNotFoundException, SQLException{
   Class.forName("com.mysql.jdbc.Driver");
   Connection con=DriverManager.getConnection("jdbc:mysql://localhost/covidportal","root","12345");
    Statement stmt=con.createStatement();
    String sql="select countryname from coviddata";
    ResultSet rs=stmt.executeQuery(sql);
    PrintWriter out=res.getWriter();
      out.print("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"\n" +
"<head>\n" +
"    <meta charset=\"UTF-8\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    <title> Get Covid info</title>\n" +
"    <style>\n" +
"        * {\n" +
"            margin: 0px;\n" +
"            padding: 0px;\n" +
"        }\n" +
"\n" +
"        body {\n" +
"\n" +
"            background-color: black;\n" +
"            color: white;\n" +
"            font-family: Georgia, 'Times New Roman', Times, serif;\n" +
"        }\n" +
"\n" +
"        h2 {\n" +
"            width: 43vw;\n" +
"            margin: 50px auto;\n" +
"            font-size: 50px;\n" +
"            position: relative;\n" +
"            top: 10vh;\n" +
"        }\n" +
"\n" +
"        p {\n" +
"            width: 100%;\n" +
"            text-align: center;\n" +
"            font-size: 26px;\n" +
"            margin: 2vh 0vw;\n" +
"            padding: 4px;\n" +
"            position: relative;\n" +
"            top: 5vh;\n" +
"        }\n" +
"\n" +
"        .container {\n" +
"            width: 30vw;\n" +
"            height: 53vh;\n" +
"            margin: 20px auto;\n" +
"\n" +
"            position: relative;\n" +
"            top: 10vh;\n" +
"        }\n" +
"\n" +
"        #select {\n" +
"            width: 75%;\n" +
"            text-align: center;\n" +
"            padding: 6px;\n" +
"            font-size: 20px;\n" +
"            border-radius: 10px;\n" +
"            border-width: 6px;\n" +
"            border-style: inset;\n" +
"            border-color: light-dark(rgb(118, 118, 118), rgb(133, 133, 133));\n" +
"            position: relative;\n" +
"            left: 3vw;\n" +
"            top: 10vh;\n" +
"        }\n" +
"\n" +
"        #submit {\n" +
"            display: block;\n" +
"            /* background-color: blue; */\n" +
"            width: 50%;\n" +
"\n" +
"            cursor: pointer;\n" +
"            border-radius: 7px;\n" +
"            text-align: center;\n" +
"            padding: 6px;\n" +
"            background-color: rgb(110, 110, 245);\n" +
"            margin: 5vh auto;\n" +
"            font-size: 20px;\n" +
"            position: relative;\n" +
"            top: 10vh;\n" +
"        }\n" +
"\n" +
"        .navbar {\n" +
"            width: 100%;\n" +
"            background-color: blue;\n" +
"            border-radius: 15px;\n" +
"            display: flex;\n" +
"            justify-content: center;\n" +
"            position: relative;\n" +
"            top: 40px;\n" +
"\n" +
"        }\n" +
"\n" +
"        ul {\n" +
"            width: 66vw;\n" +
"            display: flex;\n" +
"            justify-content: space-around;\n" +
"            padding: 10px;\n" +
"\n" +
"        }\n" +
"\n" +
"        li {\n" +
"            list-style: none;\n" +
"\n" +
"        }\n" +
"\n" +
"\n" +
"        a {\n" +
"            color: black;\n" +
"            text-decoration: none;\n" +
"            margin: 2px 0px;\n" +
"            padding: 4px 15px;\n" +
"            border-radius: 8px;\n" +
"            background-color: white;\n" +
"            font-weight: bold;\n" +
"        }\n" +
"\n" +
"        li a:hover,\n" +
"        li a.active {\n" +
"            background-color: blue;\n" +
"            color: rgb(165, 160, 160);\n" +
"            text-decoration: underline;\n" +
"\n" +
"\n" +
"        }\n" +
"    </style>\n" +
"</head>\n" +
"\n" +
"<body>\n" +
"    <div class=\"navbar\">\n" +
"        <ul>\n" +
"            <li><a href=\"Covid_portalHomePage.html\" class=\"active\">Home_Page</a></li>\n" +
"            <li><a href=\"Registration.html\">Registration_page</a></li>\n" +
"            <li><a href=\"Admin_page.html\">Admin_login</a></li>\n" +
"            <li><a href=\"\">Any_Help</a></li>\n" +
"        </ul>\n" +
"    </div>\n" +
"    <h2> Get Covid info From here</h2>\n" +
"\n" +
"    <div class=\"container\">\n" +
"        <p>Get more info Country vise Fill the name of Country for more details</p>\n" +
"        <form action=\"GetData\" method=\"get\">\n" +
"            <!-- <input type=\"text\" placeholder=\" Enter Country Name\" name=\"t1\"><br><br> -->\n" +
"            <select name=\"country\" id=\"select\">\n" +
"                <option value=\"\">Select_Country_Name</option>");
       while(rs.next()){  
        out.print("<option value=\""+rs.getString(1)+"\">"+rs.getString(1)+"</option>");
  }
       out.print("  </select>\n" +
"            <input type=\"submit\" value=\"Submit_Now\" id=\"submit\">\n" +
"        </form>\n" +
"    </div>\n" +
"</body>\n" +
"\n" +
"</html>");
  }
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
      try {
          procesRequest(req,res);
      } catch (ClassNotFoundException ex) {
          Logger.getLogger(Getinfo.class.getName()).log(Level.SEVERE, null, ex);
      } catch (SQLException ex) {
          Logger.getLogger(Getinfo.class.getName()).log(Level.SEVERE, null, ex);
      }
}
public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
      try {
          procesRequest(req,res);
      } catch (ClassNotFoundException ex) {
          Logger.getLogger(Getinfo.class.getName()).log(Level.SEVERE, null, ex);
      } catch (SQLException ex) {
          Logger.getLogger(Getinfo.class.getName()).log(Level.SEVERE, null, ex);
      }
}
          }