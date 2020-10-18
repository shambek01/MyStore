package DBClasses;

import Classes.Account;
import Classes.Category;
import Interfaces.iCategoryDB;

import java.sql.*;
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
    public Category selectByID(int id){
        Category category = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(sqlurl, sqlusername, sqlpassword)){

                String sql = "SELECT * FROM categories WHERE category_id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        String name = resultSet.getString(2);
                        category = new Category(id, name);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return category;

    }
}
