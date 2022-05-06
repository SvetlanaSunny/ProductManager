package ru.netology;

public class ProductRepository {


  private Product[] repository = new Product[0];

  public void saveProduct(Product item) {
    for (Product product : repository) {
      if (product.getId() ==  item.getId()) {
        throw new AlreadyExistsException("Product with this id already exists");
      }
    }
    Product[] newRepository = new Product[repository.length + 1];
    for (int i = 0; i < repository.length; i++) {
      newRepository[i] = repository[i];
    }
    newRepository[newRepository.length - 1] = item;
    repository = newRepository;

  }


  public Product[] getAll() {
    return repository;
  }

  public Product findById(int id) {
    for (Product product : repository) {
      if (product.getId() == id) {
        return product;
      }
    }
    return null;
  }

  public void removeById(int id) {
    if (findById(id) == null) {
      throw new NotFoundException("Element with id: " + id + " not found");
    }
    Product[] newRepository = new Product[repository.length - 1];
    int i = 0;
    for (Product item : repository) {
      if (item.getId() != id) {
        newRepository[i] = item;
        i++;
      }
    }
    repository = newRepository;
  }
}
