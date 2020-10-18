package Servlets;

import Classes.Account;
import DBClasses.AccountDB;
import Interfaces.iAccountDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        iAccountDB accountDB = new AccountDB();
        if(accountDB.selectByLogin(login)==null){
            accountDB.insert(login,password,name,surname,email);
            response.addCookie(new Cookie("user",login));
            System.out.println("Registration is done");
            response.sendRedirect("IndexServlet");
        }
        else{
            request.setAttribute("message","Account exists");
            request.getRequestDispatcher("registration.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("registration.jsp").forward(request,response);
    }
}
