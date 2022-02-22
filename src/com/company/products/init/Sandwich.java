package com.company.products.init;

import com.company.products.Item;

public class Sandwich extends Item{
    Item Sandwich = new Item();
    private String name;
    private double price;
    private int rating;

    public Sandwich(){
        super();
        this.name = "Cheese sauce sandwich";
        this.price = 3.50;
        this.rating = 2;
    }

    public Sandwich(String name, double price, int rating){
        super();
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int getRating() {
        return rating;
    }

    @Override
    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }
}
