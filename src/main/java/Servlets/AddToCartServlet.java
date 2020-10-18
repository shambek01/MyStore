package Servlets;

import Classes.Product;
import DBClasses.AccountDB;
import DBClasses.ProductDB;
import Interfaces.iAccountDB;
import Interfaces.iProductDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.PriorityQueue;

@WebServlet(name = "AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession cartsession = request.getSession();
        cartsession.setMaxInactiveInterval(60);
        HashMap<Product,Integer> cart = (HashMap<Product, Integer>) cartsession.getAttribute("cart");
        String product = request.getParameter("productid");
        int productId = Integer.parseInt(product);
        String count = request.getParameter("amount");
        int amount = Integer.parseInt(count);
        Cookie[] cookies = request.getCookies();

        System.out.println(cookies[0].getValue());
        iProductDB productDB = new ProductDB();
        iAccountDB accountDB = new AccountDB();
        try{
            if(cart==null){
                cart = new HashMap<>();
                cart.put(productDB.selectById(productId),amount);
                accountDB.sessionCreation(cookies[0].getValue());
                cartsession.setAttribute("cart",cart);
            }
            else{
                    cart.put(productDB.selectById(productId),amount);
                    cartsession.setAttribute("cart",cart);
            }
        }
        finally {
            System.out.println(cart);
            System.out.println(cartsession.getAttribute("cart"));
            response.sendRedirect("cart.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
