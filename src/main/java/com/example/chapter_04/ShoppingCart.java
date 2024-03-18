package com.example.chapter_04;

public class ShoppingCart {

    String password;
    String[] items;

    public ShoppingCart(String[] items) {
        password = null;
        this.items = items;
    }

    public ShoppingCart(String[] items, String password) {
        this.password = password;
        this.items = items;
    }

    public String addItem(String item) {
        // Add item to the shopping cart
        return "added an item";
    }

    public String addItem(String[] items){
        // Add items to the shopping cart
        return "added items";
    }

}
