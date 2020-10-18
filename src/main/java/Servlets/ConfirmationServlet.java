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

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        iAccountDB accountDB = new AccountDB();
        Cookie[] cookies = request.getCookies();
        Stats stats = accountDB.stats(cookies[0].getValue());
        request.setAttribute("stats",stats);
        getServletContext().getRequestDispatcher("/confirmation.jsp").forward(request, response);
    }
}
