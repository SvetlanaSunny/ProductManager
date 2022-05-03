package ru.netology;

public class Smartphone extends Product{

  String manufacturer;

  public Smartphone(int id, String title, int price, String manufacturer){
    super(id, title, price);
    this.manufacturer = manufacturer;
  }
  public boolean matches(String search){
    if (super.matches(search)) {
      return true;
    }
    return manufacturer.contains(search);
  }
}
