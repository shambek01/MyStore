package Servlets;

import Classes.Product;
import DBClasses.ProductDB;
import Interfaces.iProductDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

@WebServlet(name = "FetchByCategoryServlet")
public class FetchByCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        iProductDB productDB = new ProductDB();
        String category = request.getParameter("category");
        int categoryId = Integer.parseInt(category);
        System.out.println(categoryId);
        HashMap<Integer,Product> products = productDB.selectByCategory(categoryId);
        System.out.println(products);
        request.setAttribute("products", products);
        getServletContext().getRequestDispatcher("/products.jsp").forward(request, response);
    }
}
