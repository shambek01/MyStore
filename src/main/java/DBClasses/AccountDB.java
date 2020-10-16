package DBClasses;

import Classes.Account;


import java.sql.*;
import java.util.ArrayList;

public class AccountDB {
    private static String sqlurl = "jdbc:mysql://localhost/shopdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String sqlusername = "root";
    private static String sqlpassword = "";
    public static ArrayList<Account> select() {

        ArrayList<Account> accounts = new ArrayList<Account>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(sqlurl, sqlusername, sqlpassword)){

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM products");
                while(resultSet.next()){

                    int id = resultSet.getInt(1);
                    String login = resultSet.getString(2);
                    String password = resultSet.getString(3);
                    String name = resultSet.getString(4);
                    String surname = resultSet.getString(5);
                    String email = resultSet.getString(6);
                    Account account = new Account(id, login, password,name,surname,email);
                    accounts.add(account);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return accounts;
    }
    public static Account selectById(int id){
        Account account = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(sqlurl, sqlusername, sqlpassword)){

                String sql = "SELECT * FROM accounts WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        String login = resultSet.getString(2);
                        String password = resultSet.getString(3);
                        String name = resultSet.getString(4);
                        String surname = resultSet.getString(5);
                        String email = resultSet.getString(6);
                        account = new Account(id, login, password,name,surname,email);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return account;
    }
    public static Account selectByLogin(String login){
        Account account = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(sqlurl, sqlusername, sqlpassword)){

                String sql = "SELECT * FROM accounts WHERE login=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, login);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        int id = resultSet.getInt(1);
                        String password = resultSet.getString(3);
                        String name = resultSet.getString(4);
                        String surname = resultSet.getString(5);
                        String email = resultSet.getString(6);
                        account = new Account(id, login, password,name,surname,email);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return account;
    }
}
