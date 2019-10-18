package bookShop.entities;

import java.io.Serializable;
import java.util.Objects;

public class Delivery extends BookShop implements Serializable {

    private String date;
    private DeliveryType deliveryType;
    private String address;
    private Order order;

    public Delivery() {
        this.date = "";
        this.address = "";
        this.deliveryType = new DeliveryType();
        this.order = new Order();
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public bookShop.entities.Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return Objects.equals(date, delivery.date) &&
                Objects.equals(deliveryType, delivery.deliveryType) &&
                Objects.equals(address, delivery.address) &&
                Objects.equals(order, delivery.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, deliveryType, address, order);
    }

    @Override
    public String toString() {
        if (order != null)
            return date + "  №" + order.getId();
        else return date;
    }
}
