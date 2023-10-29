package homeworks.onlineMarket.models;

public class Product {
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
    public String toString() {
        return "Product Id:" + productId + " Name:" + productName + " Description:" + productDescription + " Price:" + productPrice + "  Quantity:" + stockQty + " Type:" + productType;
    }
}
