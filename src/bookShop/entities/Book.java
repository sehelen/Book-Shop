package bookShop.entities;

import java.io.Serializable;
import java.util.Objects;

public class Book extends BookShop implements Serializable {

    private String name;
    private Author author;
    private String price;
    private String publishingYear;
    private PublishingHouse publishingHouse;

    public Book() {
        name = "";
        price = "";
        publishingYear = "";
        author = new Author();
        publishingHouse = new PublishingHouse();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(String publishingYear) {
        this.publishingYear = publishingYear;
    }

    public PublishingHouse getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(PublishingHouse publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) &&
                Objects.equals(author, book.author) &&
                Objects.equals(price, book.price) &&
                Objects.equals(publishingYear, book.publishingYear) &&
                Objects.equals(publishingHouse, book.publishingHouse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, price, publishingYear, publishingHouse);
    }

    @Override
    public String toString() {
        return "\"" + name + "\"   " + author;
    }
}