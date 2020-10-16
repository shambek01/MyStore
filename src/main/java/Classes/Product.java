package Classes;

public class Product {
    private int productId;
    private String description;
    private int price;

    public Product(int productId, String description, int price, String productImage, String category) {
        this.productId = productId;
        this.description = description;
        this.price = price;
        this.productImage = productImage;
        this.category = category;
    }

    private String productImage;
    private String category;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


}
