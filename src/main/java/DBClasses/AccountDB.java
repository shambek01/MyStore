package DBClasses;

import Classes.Account;
import Interfaces.iAccountDB;


import java.sql.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class AccountDB implements iAccountDB {
    private static String sqlurl = "jdbc:mysql://localhost/mystoredb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String sqlusername = "root";
    private static String sqlpassword = "";
    public PriorityQueue<Account> select() {

        PriorityQueue<Account> accounts = new PriorityQueue<Account>();
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
    public Account selectById(int id){
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
    public Account selectByLogin(String login){
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



    public int insert(String login, String password, String name, String surname, String email){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(sqlurl, sqlusername, sqlpassword)){
                String sql = "INSERT INTO accounts (login, password,name,surname,email) Values (?,?,?,?,?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, login);
                    preparedStatement.setString(2, password);
                    preparedStatement.setString(3, name);
                    preparedStatement.setString(4, surname);
                    preparedStatement.setString(5, email);
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
}
