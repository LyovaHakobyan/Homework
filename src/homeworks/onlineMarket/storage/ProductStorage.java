package homeworks.onlineMarket.storage;

import homeworks.onlineMarket.exception.NotFoundException;
import homeworks.onlineMarket.exception.OutOfStockException;
import homeworks.onlineMarket.model.Product;
import homeworks.onlineMarket.util.StorageSerializeUtil;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ProductStorage implements Serializable {
    private final Set<Product> products = new HashSet<>();

    public ProductStorage() {
    }

    public boolean addProduct(Product product) {
        boolean added = products.add(product);
        StorageSerializeUtil.serializeProductStorage(this);
        return added;
    }

    public boolean removeProductById(String id) {
        for (Product product : products) {
            if (product.getProductId().equals(id)) {
                return products.remove(product);
            }
        }
        return false;
    }

    public Product returnProductById(String id) throws NotFoundException {
        for (Product product : products) {
            if (product.getProductId().equals(id)) {
                return product;
            }
        }
        throw new NotFoundException("no such product");
    }

    public void printAll() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void checkExistenceOfProduct(String id, int quantity) throws OutOfStockException {
        for (Product product : products) {
            if (product.getProductId().equals(id)) {
                if (quantity > product.getStockQty()) {
                    throw new OutOfStockException("no such product");
                }
            }
        }
    }

    public void buyProduct(String id, int quantity) throws OutOfStockException {
        for (Product product : products) {
            if (product.getProductId().equals(id)) {
                if (quantity > product.getStockQty()) {
                    throw new OutOfStockException("no such product");
                } else if (quantity == product.getStockQty()) {
                    removeProductById(id);
                } else {
                    product.setStockQty(product.getStockQty() - quantity);
                    StorageSerializeUtil.serializeProductStorage(this);
                }
            }
        }
    }

}

