package bookShop.dataLayer;

import java.io.Serializable;
import java.util.Objects;

public class DeliveryType extends BookShop implements Serializable {

    private String Type;
    private String Price;

    public DeliveryType(){
        Type = "";
        Price = "";
    }

    public DeliveryType(String Type, String  Price)
    {
        this.Price = Price;
        this.Type = Type;
    }

    public String  getPrice() { return Price; }

    public void setPrice(String  price) { Price = price; }

    public String getType() { return Type; }

    public void setType(String type) { Type = type; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryType that = (DeliveryType) o;
        return Price.equals(that.Price) &&
                Type.equals(that.Type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Type, Price);
    }

    @Override
    public String toString() {
        return Type;
    }
}
