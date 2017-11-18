package BookStoreRunner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author viju
 */
public class Book {
    String name;
    String author;
    int price;
    int stock;

    Book(String name1, int price1, String author1) {
        
        name = name1 ;
        price = price1;
        author = author1 ;
    }

    void addStock(int quantity) {
        stock = stock + quantity;
    }

    void subtractStock(int quantity) {
        stock = stock - quantity;
    }

    void print() {
        System.out.println("name :" + name);
        System.out.println("price :" + price);
        System.out.println("author :" + author);
        System.out.println("stock :" + stock);
    }

    
}
