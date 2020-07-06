package co.edu.cedesistemas.ecommerce.model.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Document("order")
public class Order {
    @Id
    private String id;
    private User user;
    private Store store;
    private Status status;
    private Address shippingAddress;
    private List<OrderItem> items;
    private LocalDateTime createdAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id.equals(order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public enum Status {
        CREATED,
        ACCEPTED,
        CONFIRMED,
        CANCELLED,
        SHIPPED,
        DELIVERED
    }
}
