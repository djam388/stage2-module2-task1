package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {
    User user = new User();
    public void init(){

        user.setFirstName("John");
        user.setLastName("Black");
        Warehouse.getInstance().addUser(user);
    }

    @Override
    public void doPost(HttpServletRequest req,HttpServletResponse res)
            throws IOException
    {
        res.setContentType("text/html");//setting the content type
        PrintWriter pw=res.getWriter();//get the stream to write the data

//writing html in the stream
        pw.println("<html><body>");
        pw.println("Added user(s) to Warehouse:");
        pw.println("<br>");
        pw.println("User John Black added to Warehouse");
        pw.println("<br>");
        pw.println("</body></html>");


        pw.close();//closing the stream
    }
}
