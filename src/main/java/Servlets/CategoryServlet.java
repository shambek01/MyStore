package Servlets;

import Classes.Category;
import DBClasses.CategoryDB;
import Interfaces.iCategoryDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;

@WebServlet(name = "CategoryServlet")
public class CategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String shopname = getServletContext().getInitParameter("shopname");
        iCategoryDB categoryDB = new CategoryDB();
        HashSet<Category> categories = categoryDB.select();
        request.setAttribute("shopname",shopname);
        request.setAttribute("categories", categories);
        getServletContext().getRequestDispatcher("/header.jsp").forward(request, response);
    }
}
