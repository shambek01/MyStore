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

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        iAccountDB accountDB = new AccountDB();
        try{
            Account account = accountDB.selectByLogin(login);
            if(account.getPassword().equals(password)){
                response.addCookie(new Cookie("user",login));
                accountDB.login(login);
                System.out.println("Login is done");
                response.sendRedirect("IndexServlet");
            }
            else{
                request.setAttribute("message","Wrong login or password");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        }
        catch (Exception e){
            request.setAttribute("message","Wrong login or password");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }
}
