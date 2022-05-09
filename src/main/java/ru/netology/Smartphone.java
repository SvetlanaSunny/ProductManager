package ru.netology;

public class Smartphone extends Product {

  String manufacturer;

  public Smartphone(int id, String title, int price, String manufacturer) {
    super(id, title, price);
    this.manufacturer = manufacturer;
  }
}
