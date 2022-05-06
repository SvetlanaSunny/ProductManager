package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

  @Test
  public void searchBook() {
    Product book = new Book(1, "Java", 150, "netology");
    boolean expected = true;
    boolean actual = book.matches("netology");
    assertEquals(expected, actual);
  }

  @Test
  public void searchBook1() {
    Product book = new Book(1, "Java", 150, "netology");
    boolean expected = true;
    boolean actual = book.matches("Java");
    assertEquals(expected, actual);
  }

  @Test
  public void searchSmartphone() {
    Product smartphone = new Smartphone(2, "phone", 250, "nokia");
    boolean expected = true;
    boolean actual = smartphone.matches("nokia");
    assertEquals(expected, actual);
  }

  @Test
  public void searchSmartphone1() {
    Product smartphone = new Smartphone(2, "phone", 250, "nokia");
    boolean expected = true;
    boolean actual = smartphone.matches("phone");
    assertEquals(expected, actual);
  }

  @Test
  public void removeByIdTest() {
    ProductRepository repository = new ProductRepository();
    Product book = new Book(2, "Java", 150, "netology");
    Product smartphone = new Smartphone(3, "phone", 250, "nokia");
    Product book1 = new Book(5, "Java", 100, "Берт Бэйтс");
    repository.saveProduct(book);
    repository.saveProduct(smartphone);
    repository.saveProduct(book1);
    repository.removeById(5);
    Product[] actual = repository.getAll();
    Product[] expected = {book, smartphone};
    Assertions.assertArrayEquals(expected, actual);
  }

  @Test
  public void removeByIdNonExistent() {
    ProductRepository repository = new ProductRepository();
    Product book = new Book(2, "Java", 150, "netology");
    Product smartphone = new Smartphone(3, "phone", 250, "nokia");
    Product book1 = new Book(5, "Java", 100, "Берт Бэйтс");
    repository.saveProduct(book);
    repository.saveProduct(smartphone);
    repository.saveProduct(book1);

    assertThrows(NotFoundException.class,() ->{
      repository.removeById(6);
    });

  }
}

