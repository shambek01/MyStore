package Interfaces;

import Classes.Account;

import java.util.ArrayList;
import java.util.PriorityQueue;

public interface iAccountDB {
    PriorityQueue<Account> select();
    Account selectById(int id);
    Account selectByLogin(String login);
    int insert(String login, String password, String name, String surname, String email);
}
