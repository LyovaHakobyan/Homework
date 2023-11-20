package homeworks.onlineMarket.model;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {
    private String productId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private int stockQty;
    private ProductType productType;

    public Product(String productId, String productName, String productDescription, double productPrice, int stockQty, ProductType productType) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.stockQty = stockQty;
        this.productType = productType;
    }

    public int getStockQty() {
        return stockQty;
    }

    public void setStockQty(int stockQty) {
        this.stockQty = stockQty;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Double.compare(productPrice, product.productPrice) != 0) return false;
        if (stockQty != product.stockQty) return false;
        if (!Objects.equals(productId, product.productId)) return false;
        if (!Objects.equals(productName, product.productName)) return false;
        if (!Objects.equals(productDescription, product.productDescription))
            return false;
        return productType == product.productType;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (productDescription != null ? productDescription.hashCode() : 0);
        temp = Double.doubleToLongBits(productPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + stockQty;
        result = 31 * result + (productType != null ? productType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product Id:" + productId + " Name:" + productName + " Description:" + productDescription + " Price:" + productPrice + "  Quantity:" + stockQty + " Type:" + productType;
    }
}
