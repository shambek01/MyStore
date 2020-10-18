package Classes;

public class Product {
    private int productId;
    private String description;
    private int price;

    public Product(int productId, String description, int price, String productImage, int category) {
        this.productId = productId;
        this.description = description;
        this.price = price;
        this.productImage = productImage;
        this.categoryId = category;
    }

    private String productImage;
    private int categoryId;
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int category) {
        this.categoryId = category;
    }


}
