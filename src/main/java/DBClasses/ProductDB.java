package DBClasses;
import Classes.Product;

import java.sql.*;
import java.util.ArrayList;

public class ProductDB {
    private static String url = "jdbc:mysql://localhost/shopdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String username = "root";
    private static String password = "";
    public static ArrayList<Product> select() {

        ArrayList<Product> products = new ArrayList<Product>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM products");
                while(resultSet.next()){

                    int id = resultSet.getInt(1);
                    String description = resultSet.getString(2);
                    int price = resultSet.getInt(3);
                    String productImage = resultSet.getString(4);
                    String category = resultSet.getString(5);
                    Product product = new Product(id, description, price,productImage,category);
                    products.add(product);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return products;
    }
}
