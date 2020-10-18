package DBClasses;

import Classes.Category;
import Interfaces.iCategoryDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Queue;

public class CategoryDB implements iCategoryDB {
    private static String sqlurl = "jdbc:mysql://localhost/mystoredb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String sqlusername = "root";
    private static String sqlpassword = "";

    public HashSet<Category> select(){
        HashSet<Category> categories = new HashSet<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(sqlurl, sqlusername, sqlpassword)){

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM categories");
                while(resultSet.next()){

                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    Category category = new Category(id,name);
                    categories.add(category);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return categories;
    }
}
