package Interfaces;

import Classes.Account;
import Classes.Stats;

import java.util.ArrayList;
import java.util.PriorityQueue;

public interface iAccountDB {
    PriorityQueue<Account> select();
    Account selectById(int id);
    Account selectByLogin(String login);
    int insert(String login, String password, String name, String surname, String email);
    void sessionCreation(String login);
    void login(String login);
    void create();
    Stats stats(String login);

}
