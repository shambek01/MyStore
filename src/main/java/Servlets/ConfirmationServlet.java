package Servlets;

import Classes.Stats;
import DBClasses.AccountDB;
import Interfaces.iAccountDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ConfirmationServlet")
public class ConfirmationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        iAccountDB accountDB = new AccountDB();
        Cookie[] cookies = request.getCookies();
        Stats stats = accountDB.stats(cookies[0].getValue());
        System.out.println(cookies[0].getValue());
        System.out.println(stats.visits);
        System.out.println(stats.last_visit);
        System.out.println(stats.sessions);
        request.setAttribute("stats",stats);
        request.getRequestDispatcher("confirmation.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
