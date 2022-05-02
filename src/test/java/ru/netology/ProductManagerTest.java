package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

  @Test
  public void getAllTest() {
    ProductRepository repository = new ProductRepository();
    Product book = new Book(1, "Java", 150, "netology");
    Product smartphone = new Smartphone(2, "phone", 250, "nokia");
    Product book1 = new Book(3, "Java", 100, "Берт Бэйтс");
    repository.saveProduct(book);
    repository.saveProduct(smartphone);
    repository.saveProduct(book1);
    Product[] actual = repository.getAll();
    Product[] expected = {book, smartphone, book1};
    Assertions.assertArrayEquals(expected, actual);
  }

  @Test
  public void removeById() {
    ProductRepository repository = new ProductRepository();
    Product book = new Book(1, "Java", 150, "netology");
    Product smartphone = new Smartphone(2, "phone", 250, "nokia");
    Product book1 = new Book(3, "Java", 100, "Берт Бэйтс");
    repository.saveProduct(book);
    repository.saveProduct(smartphone);
    repository.saveProduct(book1);
    repository.removeById(2);
    Product[] actual = repository.getAll();
    Product[] expected = {book, book1};
    Assertions.assertArrayEquals(expected, actual);
  }


  @Test
  public void searchBy() {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book = new Book(1, "Java", 150, "netology");
    Product smartphone = new Smartphone(2, "phone", 250, "nokia");
    Product book1 = new Book(3, "Java", 100, "Берт Бэйтс");
    manager.addProduct(book);
    manager.addProduct(smartphone);
    manager.addProduct(book1);
    Product[] actual = manager.searchBy("Java");
    Product[] expected = {book, book1};
    Assertions.assertArrayEquals(expected, actual);
  }

}

