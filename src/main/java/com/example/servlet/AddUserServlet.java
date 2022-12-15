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
    public void init(){
        Warehouse.getInstance().addUser(new User("John", "Black"));
    }
    @Override
    public void doGet(HttpServletRequest req,HttpServletResponse res)
            throws IOException
    {
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        if (firstName != null && lastName != null ) {
            Warehouse.getInstance().addUser(new User(firstName, lastName));
        }
        res.setContentType("text/html");//setting the content type
        PrintWriter pw=res.getWriter();//get the stream to write the data
        pw.println("<html><body>");
        pw.println("<br>");
        pw.println("User number added to Warehouse: " + Warehouse.getInstance().getUsers().size());
        pw.println("<br>");


    }
    @Override
    public void doPost(HttpServletRequest req,HttpServletResponse res)
            throws IOException
    {
        res.setContentType("text/html");//setting the content type
        PrintWriter pw=res.getWriter();//get the stream to write the data

        pw.println("<html><body>");
        pw.println("Added user(s) to Warehouse:");
        pw.println("<br>");

//writing html in the stream
        pw.println("<html><body>");
        pw.println("<br>");
        pw.println("User number added to Warehouse: " + Warehouse.getInstance().getUsers().size());
        pw.println("<br>");
        pw.println("</body></html>");


        pw.close();//closing the stream
    }
}
