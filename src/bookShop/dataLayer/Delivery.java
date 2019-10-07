package bookShop.dataLayer;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Delivery extends BookShop implements Serializable {

    private String Date;
    private DeliveryType DeliveryType;
    private String Address;

    public Delivery(){
        this.Date = "";
        this.Address = "";
    }

    public Delivery(String Date, DeliveryType DeliveryType, String Address)
    {
        this.Address = Address;
        this.Date = Date;
        this.DeliveryType = DeliveryType;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return Date.equals(delivery.Date) &&
                DeliveryType.equals(delivery.DeliveryType) &&
                Address.equals(delivery.Address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Date, DeliveryType, Address);
    }

    @Override
    public String toString() {
        return Date;
    }
}
