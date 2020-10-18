package Interfaces;

import Classes.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public interface iProductDB {
    ArrayList<Product> select();
    HashMap<Integer,Product> selectByCategory(int categoryId);
    Product selectById(int productId);
}
