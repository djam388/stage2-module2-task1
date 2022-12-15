package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
            throws IOException, ServletException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        if (firstName != null && lastName != null ) {
            Warehouse.getInstance().addUser(new User(firstName, lastName));
        }
        req.setAttribute("user", new User(firstName, lastName));
        res.setContentType("text/html");//setting the content type
        PrintWriter pw=res.getWriter();//get the stream to write the data
        pw.println("<html><body>");
        pw.println("<br>");
        pw.println("User number added to Warehouse: " + Warehouse.getInstance().getUsers().size());
        pw.println("<br>");

        RequestDispatcher reqd = req.getRequestDispatcher("add");
        reqd.forward(req, res);

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
