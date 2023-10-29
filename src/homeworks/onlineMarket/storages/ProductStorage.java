package homeworks.onlineMarket.storages;

import homeworks.onlineMarket.exceptions.NotFoundException;
import homeworks.onlineMarket.exceptions.OutOfStockException;
import homeworks.onlineMarket.interfaces.Printable;
import homeworks.onlineMarket.models.Product;

public class ProductStorage implements Printable {
    private Product[] products;
    private int size;

    public ProductStorage() {
        products = new Product[10];
        size = 0;
    }

    public void addProduct(Product product) {
        if (size == products.length - 1) {
            extend();
        }
        products[size++] = product;
    }

    public void removeProductById(String id) throws NotFoundException {
        int numberOfProducts = 0;
        for (int i = 0; i < size; i++) {
            if (products[i].getProductId().equals(id)) {
                for (int j = i; j < size - 1; j++) {
                    products[j] = products[j + 1];
                }
                numberOfProducts++;
                size--;
                break;
            }
        }
        if (numberOfProducts == 0) {
            throw new NotFoundException();
        }
    }

    public Product returnProductById(String id) throws NotFoundException {
        for (int i = 0; i < size; i++) {
            if (products[i].getProductId().equals(id)) {
                return products[i];
            }
        }
        throw new NotFoundException();
    }

    @Override
    public void printAll() {
        for (int i = 0; i < size; i++) {
            System.out.println(products[i]);
        }
    }

    public void checkExistenceOfProduct(String id, int quantity) throws OutOfStockException {
        for (int i = 0; i < size; i++) {
            if (products[i].getProductId().equals(id)) {
                if (quantity > products[i].getStockQty()) {
                    throw new OutOfStockException();
                }
            }
        }
    }

    public void buyProduct(String id, int quantity) throws OutOfStockException {
        for (int i = 0; i < size; i++) {
            if (products[i].getProductId().equals(id)) {
                if (quantity > products[i].getStockQty()) {
                    throw new OutOfStockException();
                } else if (quantity == products[i].getStockQty()) {
                    try {
                        removeProductById(id);
                    } catch (NotFoundException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    products[i].setStockQty(products[i].getStockQty() - quantity);
                }
            }
        }
    }

    private void extend() {
        Product[] temp = new Product[products.length + 10];
        System.arraycopy(products, 0, temp, 0, size);
        products = temp;
    }
}
