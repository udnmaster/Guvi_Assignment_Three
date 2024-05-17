package com.demo.assignment3;

import java.util.Scanner;

//Book class
class Book {
 private int bookID;
 private String title;
 private String author;
 private boolean isAvailable;

 // Constructor
 public Book(int bookID, String title, String author) {
     this.bookID = bookID;
     this.title = title;
     this.author = author;
     this.isAvailable = true;
 }

 // Getter methods
 public int getBookID() {
     return bookID;
 }

 public String getTitle() {
     return title;
 }

 public String getAuthor() {
     return author;
 }

 public boolean isAvailable() {
     return isAvailable;
 }

 // Method to mark book as available
 public void markAvailable() {
     isAvailable = true;
 }

 // Method to mark book as not available
 public void markNotAvailable() {
     isAvailable = false;
 }

 // Method to display book information
 public void displayInfo() {
     System.out.println("Book ID: " + bookID);
     System.out.println("Title: " + title);
     System.out.println("Author: " + author);
     System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
     System.out.println();
 }
}

//Library class
class Library {
 private Book[] books;
 private int capacity;
 private int size;

 // Constructor
 public Library(int capacity) {
     this.capacity = capacity;
     this.books = new Book[capacity];
     this.size = 0;
 }

 // Method to add a book to the library
 public void addBook(Book book) {
     if (size < capacity) {
         books[size++] = book;
         System.out.println("Book added successfully.");
     } else {
         System.out.println("Library is full. Cannot add more books.");
     }
 }

 // Method to remove a book from the library
 public void removeBook(int bookID) {
     boolean found = false;
     for (int i = 0; i < size; i++) {
         if (books[i].getBookID() == bookID) {
             books[i] = null;
             found = true;
             break;
         }
     }
     if (found) {
         System.out.println("Book removed successfully.");
     } else {
         System.out.println("Book with ID " + bookID + " not found in the library.");
     }
 }

 // Method to search for a book by its ID
 public void searchBook(int bookID) {
     boolean found = false;
     for (Book book : books) {
         if (book != null && book.getBookID() == bookID) {
             book.displayInfo();
             found = true;
             break;
         }
     }
     if (!found) {
         System.out.println("Book with ID " + bookID + " not found in the library.");
     }
 }

 // Method to display all books in the library
 public void displayBooks() {
     for (Book book : books) {
         if (book != null) {
             book.displayInfo();
         }
     }
 }
}

//Main class
public class LibrarySystem {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     // Create a library with a capacity of 10 books
     Library library = new Library(10);

     int choice;
     do {
         System.out.println("1. Add a book");
         System.out.println("2. Remove a book");
         System.out.println("3. Search for a book");
         System.out.println("4. Display all books");
         System.out.println("5. Exit");
         System.out.print("Enter your choice: ");
         choice = scanner.nextInt();

         switch (choice) {
             case 1:
                 System.out.print("Enter book ID: ");
                 int bookID = scanner.nextInt();
                 scanner.nextLine(); // Consume newline
                 System.out.print("Enter title: ");
                 String title = scanner.nextLine();
                 System.out.print("Enter author: ");
                 String author = scanner.nextLine();
                 Book newBook = new Book(bookID, title, author);
                 library.addBook(newBook);
                 break;
             case 2:
                 System.out.print("Enter book ID to remove: ");
                 int removeID = scanner.nextInt();
                 library.removeBook(removeID);
                 break;
             case 3:
                 System.out.print("Enter book ID to search: ");
                 int searchID = scanner.nextInt();
                 library.searchBook(searchID);
                 break;
             case 4:
                 System.out.println("All books in the library:");
                 library.displayBooks();
                 break;
             case 5:
                 System.out.println("Exiting program. Goodbye!");
                 break;
             default:
                 System.out.println("Invalid choice. Please enter a number between 1 and 5.");
         }
     } while (choice != 5);

     scanner.close();
 }
}
