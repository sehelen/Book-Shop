package bookShop.entities;

import java.io.Serializable;
import java.util.Objects;

public class Order extends BookShop implements Serializable {

    private String id;
    private Client client;
    private Book book;
    private String priceSum;
    private String paymentMethod;

    public Order() {
        this.id = "";
        this.priceSum = "";
        this.paymentMethod = "";
        this.book = new Book();
        this.client = new Client();
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public bookShop.entities.Book getBook() {
        return book;
    }

    public void setBook(bookShop.entities.Book book) {
        this.book = book;
    }

    public String getPriceSum() {
        return priceSum;
    }

    public void setPriceSum(String priceSum) {
        this.priceSum = priceSum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id.equals(order.id) &&
                priceSum.equals(order.priceSum) &&
                client.equals(order.client) &&
                book.equals(order.book) &&
                paymentMethod.equals(order.paymentMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, book, priceSum, paymentMethod);
    }

    @Override
    public String toString() {
        return "№" + id + "  " +
                client + ":  " +
                book;
    }
}

