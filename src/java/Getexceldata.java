

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Getexceldata extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/vnd.ms-excel");
        FileInputStream fis=new FileInputStream("E:\\AdvExcelfile\\Class5thdata.xlsx");
        int a=fis.available();
        byte b[]=new byte[a];
        fis.read(b);
        ServletOutputStream out= response.getOutputStream();
        out.write(b);
        out.close();
    }
    

   protected void doGet(HttpServletRequest req ,HttpServletResponse res) throws ServletException, IOException{
      processRequest(req,res);
}  
   protected void doPost(HttpServletRequest req ,HttpServletResponse res) throws ServletException, IOException{
      processRequest(req,res);
}  
}

