package com.demo.assignment3;

import java.util.Scanner;

//Taxable interface
interface Taxable {
 double SALES_TAX = 0.07;
 double INCOME_TAX = 0.105;

 // Abstract method to calculate tax
 double calcTax();
}

//Employee class implementing Taxable interface
class Employee implements Taxable {
 private int empId;
 private String name;
 private double salary;

 // Constructor
 public Employee(int empId, String name, double salary) {
     this.empId = empId;
     this.name = name;
     this.salary = salary;
 }

 // Implementing calcTax method for income tax calculation
 @Override
 public double calcTax() {
     return salary * INCOME_TAX;
 }
}

//Product class implementing Taxable interface
class Product implements Taxable {
 private int pid;
 private double price;
 private int quantity;

 // Constructor
 public Product(int pid, double price, int quantity) {
     this.pid = pid;
     this.price = price;
     this.quantity = quantity;
 }

 // Implementing calcTax method for sales tax calculation
 @Override
 public double calcTax() {
     return price * SALES_TAX * quantity;
 }
}

//Driver class
public class MainInterface {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     // Accepting employee information
     System.out.println("Enter employee information:");
     System.out.print("Employee ID: ");
     int empId = scanner.nextInt();
     scanner.nextLine(); // Consume newline
     System.out.print("Employee Name: ");
     String empName = scanner.nextLine();
     System.out.print("Employee Salary: ");
     double empSalary = scanner.nextDouble();

     // Creating Employee object
     Employee employee = new Employee(empId, empName, empSalary);

     // Accepting product information
     System.out.println("\nEnter product information:");
     System.out.print("Product ID: ");
     int pid = scanner.nextInt();
     System.out.print("Product Price: ");
     double price = scanner.nextDouble();
     System.out.print("Product Quantity: ");
     int quantity = scanner.nextInt();

     // Creating Product object
     Product product = new Product(pid, price, quantity);

     // Calculating and printing income tax and sales tax
     System.out.println("\nIncome Tax: $" + employee.calcTax());
     System.out.println("Sales Tax: $" + product.calcTax());

     scanner.close();
 }
}
