package com.company;

import com.company.cart;

import java.sql.Date;
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
            System.out.println("1. ");
            System.out.println("2. ");
            System.out.println("3. ");
            System.out.println("4. ");
            System.out.println("5. ");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.println("Enter option: ");
                int option = scanner.nextInt();
                switch (option) {
                    case 1:
                        ff();
                    case 2:
                        ff();
                    case 3:
                        ff();
                    case 4:
                        ff();
                    case 5:
                        ff();
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
}