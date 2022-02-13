package com.company;
import com.company.products.Item;
import java.util.InputMismatchException;

public class Product {
    private Item item;
    private int quantity;

    public Product(){
        quantity = 0;
    }

    public Product(Item item, int quantity){
        this.item = item;
        this.quantity = quantity;
    }
    public Item getItem(){
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void plusItem() throws Exception {
        if(this.getQuantity() + 1 > 8) throw new Exception("No more products left");
        this.quantity++;
    }

    public void minusItem() throws Exception {
        if(this.getQuantity() - 1 < 0) throw new Exception("Minimum is 0");
        this.quantity--;
    }
}
