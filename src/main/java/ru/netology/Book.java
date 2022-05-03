package ru.netology;

public class Book extends Product {
  String author;

  public Book(int id, String title, int price, String author) {
    super(id, title, price);
    this.author = author;
  }

    public boolean matches(String search){
    if (super.matches(search)) {
      return true;
    }
      return author.contains(search);
    }
}
