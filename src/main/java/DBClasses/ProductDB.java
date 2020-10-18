package DBClasses;
import Classes.Account;
import Classes.Product;
import Interfaces.iProductDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class ProductDB implements iProductDB {
    private static String sqlurl = "jdbc:mysql://localhost/mystoredb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String sqlusername = "root";
    private static String sqlpassword = "";
    public ArrayList<Product> select() {

        ArrayList<Product> products = new ArrayList<Product>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(sqlurl, sqlusername, sqlpassword)){

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM products");
                while(resultSet.next()){

                    int id = resultSet.getInt(1);
                    String description = resultSet.getString(2);
                    int price = resultSet.getInt(3);
                    String productImage = resultSet.getString(4);
                    int categoryId = resultSet.getInt(5);
                    Product product = new Product(id, description, price,productImage,categoryId);
                    products.add(product);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return products;
    }

    public HashMap<Integer ,Product> selectByCategory(int categoryId) {
        HashMap<Integer,Product> products = new HashMap<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(sqlurl, sqlusername, sqlpassword)){

                String sql = "SELECT * FROM products WHERE category_id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, categoryId);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        int id = resultSet.getInt(1);
                        String description = resultSet.getString(2);
                        int price = resultSet.getInt(3);
                        String productImage = resultSet.getString(4);
                        Product product = new Product(id, description, price,productImage,categoryId);
                        products.put(id,product);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return products;
    }
    public Product selectById(int productId) {
        Product product = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(sqlurl, sqlusername, sqlpassword)){

                String sql = "SELECT * FROM products WHERE product_id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, productId);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        String description = resultSet.getString(2);
                        int price = resultSet.getInt(3);
                        String productImage = resultSet.getString(4);
                        int categoryId = resultSet.getInt(5);
                        product = new Product(productId, description, price,productImage,categoryId);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return product;
    }
}
