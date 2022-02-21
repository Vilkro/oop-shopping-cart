package com.company;

import com.company.repositories.interfaces.prlist;
import com.company.repositories.repository;
import com.company.data.interfaces.IDB;
import com.company.data.postresql;
import com.company.products.Item;
import com.company.Product;
import com.company.cart;
import com.company.ui;

public class Main {

    public static void main(String[] args) {
        IDB db = new postresql();
        prlist repo = new repository(db);
        cart controller = new cart(repo);
        ui userInterface = new ui(controller);
        userInterface.launch();
    }
}
