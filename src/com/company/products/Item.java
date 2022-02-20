package com.company.products;

public class Item {
    private int id;
    private String name;
    private double price;
    private int rating;

    public Item(){

    }

    public Item(String name, double price, int rating){
        setName(name);
        setPrice(price);
        setRating(rating);
    }
    public Item(int id, String name, double price, int rating){
        setId(id);
        setName(name);
        setPrice(price);
        setRating(rating);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }
}
