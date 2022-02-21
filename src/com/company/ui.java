package com.company;

import com.company.cart;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ui {
    private final cart controller;
    private final Scanner scanner;

    public ui(cart controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void launch() {
        while (true) {
            System.out.println();
            System.out.println("Select option:");
            System.out.println("1. Get product by name");
            System.out.println("2. Get product by id");
            System.out.println("3. Add new product");
            System.out.println("4. Remove product");
            System.out.println("5. Get products list");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.println("Enter option: ");
                int option = scanner.nextInt();
                switch (option) {
                    case 1:
                        getItemByName();
                    case 2:
                        getItemById();
                    case 3:
                        addItem();
                    case 4:
                        removeItemById();
                    case 5:
                        getAllItems();
                    default:
                        break;
                }
            } catch (InputMismatchException yes) {
                System.out.println("Input Must be integer");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("------------------------------------------------------------------------------------");
        }
    }

    public void getAllItems(){
        String temp = controller.getAllItems();
        System.out.println(temp);
    }

    public void getItemById(){
        System.out.println("Enter product id");
        int id = scanner.nextInt();
        String temp = controller.getItem(id);
        System.out.println(temp);
    }

    public void getItemByName(){
        System.out.println("Enter product name");
        String name = scanner.next();
        String temp = controller.getItemByName(name);
        System.out.println(temp);
    }

    public void removeItemById(){
        System.out.println("Enter id");
        int id = scanner.nextInt();
        String temp = controller.removeItemById(id);
        System.out.println(temp);
    }

    public void addItem(){
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter price");
        double price = scanner.nextDouble();
        System.out.println("Please enter rating");
        int rating = scanner.nextInt();
        String temp = controller.addItem(name, price, rating);
        System.out.println(temp);
    }
}