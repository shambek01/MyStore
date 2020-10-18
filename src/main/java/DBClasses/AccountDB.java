package DBClasses;

import Classes.Account;
import Classes.Stats;
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

                String sql = "SELECT * FROM accounts WHERE account_id=?";
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
                String sql = "INSERT INTO accounts (login, password,name,surname,email) Values (?,?,?,?,?);";
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
    public void sessionCreation(String login){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(sqlurl, sqlusername, sqlpassword)){

                String sql = "UPDATE `account_stats` SET `session_creation`=session_creation+1 WHERE account_id=(SELECT account_id FROM accounts WHERE login=?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, login);
                    preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    public void login(String login){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(sqlurl, sqlusername, sqlpassword)){
                String sql = "UPDATE `account_stats` SET `visits`=visits+1,`last_login`=CURRENT_DATE WHERE account_id=(SELECT account_id FROM accounts WHERE login=?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, login);
                    preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    public void create(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(sqlurl, sqlusername, sqlpassword)){
                String sql = "INSERT INTO `account_stats`(`account_id`,`visits`, `session_creation`, `last_login`) VALUES ((SELECT account_id FROM accounts ORDER BY account_id DESC LIMIT 1),'1','0',CURRENT_DATE )";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    public Stats stats(String login){
        Stats stats = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(sqlurl, sqlusername, sqlpassword)){

                String sql = "SELECT * FROM account_stats WHERE account_id=(SELECT account_id FROM accounts WHERE login=?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, login);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        int visits = resultSet.getInt(2);
                        int sessions = resultSet.getInt(3);
                        String last_login = resultSet.getString(4);
                        stats = new Stats(visits,sessions,last_login);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return stats;
    }

}
