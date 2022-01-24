package DAO.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {
    private int id;
    private final List<Product> dishes;
    private final String phoneNumber;
    private final String consumerName;
    private final String orderTime;
    private final String status;

    public Order(ArrayList<Product> dishes, String phoneNumber, String consumerName, String time, String status) {
        this.dishes = dishes;
        this.phoneNumber = phoneNumber;
        this.consumerName = consumerName;
        this.orderTime = time;
        this.status = status;
    }

    public Order(int id, ArrayList<Product> dishes, String phoneNumber, String consumerName, String time, String status) {
        this.id = id;
        this.dishes = dishes;
        this.phoneNumber = phoneNumber;
        this.consumerName = consumerName;
        this.orderTime = time;
        this.status = status;
    }

    public String getFullOrderName(){
        StringBuilder fullOrderName = new StringBuilder(dishes.get(0).getDishName());
        for (int i = 1;i < dishes.size();i++){
            fullOrderName.append(",").append(dishes.get(i).getDishName());
        }
        return fullOrderName.toString();
    }

    public String getFullOrderPrice(){
        int fullOrderPrice = 0;
        for (Product product:dishes) {
            fullOrderPrice += Integer.parseInt(product.getPrice());
        }
        return String.valueOf(fullOrderPrice);
    }

    public int getId() {
        return id;
    }

    public List<Product> getDishes() {
        return dishes;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (!Objects.equals(dishes, order.dishes)) return false;
        if (!Objects.equals(phoneNumber, order.phoneNumber)) return false;
        if (!Objects.equals(consumerName, order.consumerName)) return false;
        if (!Objects.equals(orderTime, order.orderTime)) return false;
        return Objects.equals(status, order.status);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dishes != null ? dishes.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (consumerName != null ? consumerName.hashCode() : 0);
        result = 31 * result + (orderTime != null ? orderTime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
