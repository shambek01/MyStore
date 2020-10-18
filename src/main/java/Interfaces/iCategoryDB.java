package Interfaces;

import Classes.Category;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;

public interface iCategoryDB {
    HashSet<Category> select();
    Category selectByID(int id);
}
