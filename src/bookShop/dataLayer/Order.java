package bookShop.dataLayer;

import java.io.Serializable;
import java.util.Objects;

public class Order extends BookShop implements Serializable {

    private String ID;
    private Client Client;
    private Book Book;
    private String PriceSum;
    private String PaymentMethod;

    public Order(){
        this.ID = "";
        this.PriceSum = "";
        this.PaymentMethod = "";
    }


    public Client getClient() {
        return Client;
    }

    public void setClient(Client client) { Client = client; }

    public bookShop.dataLayer.Book getBook() {
        return Book;
    }

    public void setBook(bookShop.dataLayer.Book book) {
        Book = book;
    }

    public String  getPriceSum() {
        return PriceSum;
    }

    public void setPriceSum(String  priceSum) {
        PriceSum = priceSum;
    }

    public String  getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        PaymentMethod = paymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return ID.equals(order.ID)&&
                PriceSum.equals(order.PriceSum) &&
                Client.equals(order.Client) &&
                Book.equals(order.Book) &&
                PaymentMethod.equals(order.PaymentMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, Client, Book, PriceSum, PaymentMethod);
    }

    @Override
    public String toString() {
        return  "№" + ID + "  " +
                Client + ":  " +
                Book;
    }
}

