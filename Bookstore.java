package BookStoreRunner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */;

import java.util.Scanner;

/**
 *
 * @author viju
 */
class BookStore {

    Book books[] = new Book[100];
    Bill bills[] = new Bill[100];
    int count = 0;
    int billcount = 0 ;
    
    void addBill(Bill b)
    {
      bills[billcount++] = b ;
    }

    void addBook(Book b) {
        books[count++] = b;
    }

    void printAllBook() {
        for (int i = 0; i < count; i++) {
            books[i].print();
        }
    }

    Book search(String name) {
        for (int i = 0; i < count; i++) {
            if (name.equals(books[i].name)) {
                return books[i];
            }
        }
        return null;
    }

    void addnewStock(String name, int quantity) {
        Book b = search(name);
        if (b != null) {
            b.addStock(quantity);
        }
    }

    Book sellBook(String name , int quantity) {
        Book b = search(name);
        if (b != null) {
            b.subtractStock(quantity);
                   
        }
        return b;
    }
};

/*class Book {
  
};
*/

class Bill {
    int bnumber ;
    int count= 0 ;
    Book books[]  = new Book[50];
    int quantities[] = new int[50];
    int totalamount = 0;
    
    void addBook(Book b , int quantity)
    {
      books[count] = b ;
      quantities[count]= quantity ;
      
      count++ ;     
    }
       
       
    void totalamount(int amount )
    {
      totalamount = totalamount + amount;
    }

    void printbill() {
        
        for(int i =0 ; i < count ; i++)
        {
        System.out.println(books[i] + " :" + quantities[i]);
        System.out.println(totalamount);
        
        
        }
                
    }

};

class BookStoreRunner {

    public static void main(String[] args, Bill Bill) {
        int choice;
        int quantity ;
        BookStore bookstore = new BookStore();
        Scanner in = new Scanner(System.in);
        while (true) {

            System.out.println("1.Add New Book\n");
            System.out.println("2.Add Stock of existing book\n");
            System.out.println("3.Print All Book\n");
            System.out.println("4.search the Book\n");
            System.out.println("5.Sell a book in stock\n");
            System.out.println("6.Exit\n");

            System.out.println("Enter your choice from the above menu:");
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the name of the book: ");
                    String name = in.next();
                    System.out.println("Enter the price of the book: ");
                    int price = in.nextInt();
                    System.out.println("Enter the author of the book: ");
                    String author = in.next();
                    Book book = new Book(name ,price ,author);
                    bookstore.addBook(book);
                    break;

                case 2:
                    System.out.println("Enter a book name");
                    name = in.next();
                    System.out.println("How many add book to the stock");
                    quantity = in.nextInt();
                    bookstore.addnewStock(name, quantity);
                    break;
                case 3:
                    bookstore.printAllBook();
                    break;
                case 4:
                    System.out.println("Enter the name of the book:");
                    name = in.next();
                    Book b = bookstore.search(name);

                    if (b != null) {
                        b.print();
                    } else {
                        System.out.println("book not found");
                    }
                case 5:
                     String add = "yes"  ;
                    while(add.equals("yes"))
                    {
                    
                    System.out.println("Enter book name to buy: ");
                    name = in.next();
                   System.out.println("How many  book to buy :");
                   quantity = in.nextInt();
                    b = bookstore.sellBook(name , quantity);
                    Bill bill = new Bill();
                     bill.addBook(b ,quantity) ;
                    
                     int amount = b.price * quantity ;
                     bill.totalamount(amount);
                     
                     System.out.println("Add more: ");
                     add = in.next();
                     
                    }
                    Bill bb = bill.printbill();
                    bookstore.addBill(bb);
                    break ;
                             
                         
                case 6:
                    System.exit(0);
            }
        }
    }
};
