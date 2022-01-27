package DAO.domain;

import java.util.Objects;

public class Product {
    private int id;
    private final String dishName;
    private final String price;
    private final String description;
    private final String category;
    private final String picture;

    public Product(String dishName, String price, String description, String category, String picture) {
        this.dishName = dishName;
        this.price = price;
        this.description = description;
        this.category = category;
        this.picture = picture;
    }

    public Product(int id, String dishName, String price, String picture){
        this.id = id;
        this.dishName = dishName;
        this.price = price;
        this.picture = picture;
        this.description = "";
        this.category = "";
    }

    public Product(int id, String dishName, String price, String description, String category, String picture) {
        this.id = id;
        this.dishName = dishName;
        this.price = price;
        this.description = description;
        this.category = category;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public String getDishName() {
        return dishName;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getPicture() {
        return picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (!Objects.equals(dishName, product.dishName)) return false;
        if (!Objects.equals(price, product.price)) return false;
        if (!Objects.equals(description, product.description)) return false;
        if (!Objects.equals(category, product.category)) return false;
        return Objects.equals(picture, product.picture);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dishName != null ? dishName.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        return result;
    }
}
