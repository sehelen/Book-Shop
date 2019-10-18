package bookShop.entities;

import java.io.Serializable;
import java.util.Objects;

public class DeliveryType extends BookShop implements Serializable {

    private String type;
    private String price;

    public DeliveryType() {
        type = "";
        price = "";
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryType that = (DeliveryType) o;
        return price.equals(that.price) &&
                type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, price);
    }

    @Override
    public String toString() {
        return type;
    }
}
