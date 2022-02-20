package com.company;

import com.company.products.Item;
import com.company.repositories.interfaces.prlist;

import java.util.List;

public class cart {
    private final prlist repo;

    public cart(prlist repo){
        this.repo = repo;
    }

    public String addItem(String name, double price, int rating){
        Item item = new Item(name, price, rating);
        boolean created = repo.addItem(item);
        return (created ? "Item was created" : "Item creation has failed");
    }

    public String getItem(int id){
        Item item = repo.getItem(id);
        return (item == null ? "Item was not found" : item.toString());
    }

    public String getItemByName(String name){
        Item item = repo.getItemByName(name);
        return (item == null ? "Item was not found" : item.toString());
    }

    public String getAllItems(){
        List<Item> items = repo.getAllItems();
        return (items.size() == 0 ? "Items weren't found" : items.toString());
    }

    public String removeItemById(int id){
        boolean deleted = repo.removeItemById(id);
        return deleted ? "Item was deleted" : "Item deletion has failed";
    }

    public void createTable(){
        boolean created = repo.createTable();
        System.out.println(created ? "Table item was created" : "Table creation has failed");
    }
}
