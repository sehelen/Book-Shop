package bookShop.dataLayer;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Delivery extends BookShop implements Serializable {

    private String Date;
    private DeliveryType DeliveryType;
    private String Address;
    private Order Order;

    public Delivery(){
        this.Date = "";
        this.Address = "";
    }


    public String  getDate() {
        return Date;
    }

    public void setDate(String  date) {
        Date = date;
    }

    public DeliveryType getDeliveryType() { return DeliveryType; }

    public void setDeliveryType(DeliveryType deliveryType) {
        DeliveryType = deliveryType;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public bookShop.dataLayer.Order getOrder() {
        return Order;
    }

    public void setOrder(Order order) {
        Order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return Objects.equals(Date, delivery.Date) &&
                Objects.equals(DeliveryType, delivery.DeliveryType) &&
                Objects.equals(Address, delivery.Address) &&
                Objects.equals(Order, delivery.Order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Date, DeliveryType, Address, Order);
    }

    @Override
    public String toString() {
        if (Order != null)
          return Date + "  №" + Order.getID();
        else return Date;
    }
}
