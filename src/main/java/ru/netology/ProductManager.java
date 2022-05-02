package ru.netology;

public class ProductManager {
  private ProductRepository repository;

  public ProductManager(ProductRepository repository) {
    this.repository = repository;
  }

  public void addProduct(Product item) {
    repository.saveProduct(item);
  }

  // метод определения соответствия товара product запросу search
  public boolean matches(Product product, String search) {
    if (product.getName().contains(search)) {
      return true;
    } else {
      return false;
    }
  }

  public Product[] searchBy(String text) {
    Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
    for (Product product : repository.getAll()) {
      if (matches(product, text)) {
        // "добавляем в конец" массива result продукт product
      Product[] searchResults = new Product[result.length+1];
      for (int i=0; i< result.length; i++){
        searchResults[i] = result[i];
      }
      searchResults[searchResults.length-1]=product;
      result = searchResults;
      }
    }
    return result;
  }


}
