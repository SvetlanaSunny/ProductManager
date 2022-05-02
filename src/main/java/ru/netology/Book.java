package ru.netology;

public class Book extends Product {
  String author;

  public Book(int id, String title, int price, String author) {
    super(id, title, price);
    this.author = author;
  }

}
