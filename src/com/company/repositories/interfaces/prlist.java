package com.company.repositories.interfaces;
import com.company.products.Item;

import java.util.List;

public interface prlist {
    boolean createTable();

    boolean addItem(Item company);

    Item getItem(int id);

    List<Item> getAllItems();

    Item getItemByName(String name);

    boolean removeItemById(int id);
}
