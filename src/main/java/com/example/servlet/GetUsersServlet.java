package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/users")
public class GetUsersServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException
    {
        res.setContentType("text/html");//setting the content type
        PrintWriter pw=res.getWriter();//get the stream to write the data

//writing html in the stream
        pw.println("<html><body>");
        req.setAttribute("users", Warehouse.getInstance().getUsers());
        for (User addedUser : Warehouse.getInstance().getUsers()) {
            pw.println(addedUser.getFirstName() + " " + addedUser.getLastName());
            pw.println("<br>");
        }
        pw.println("</body></html>");


        pw.close();//closing the stream
    }

    //write your code here!
}
