package bookShop.dataLayer;

import bookShop.Main;
import bookShop.businessLayer.creators.BookShopCreator;

import java.io.Serializable;
import java.util.Objects;

public class Book extends BookShop implements Serializable {

    private String Name;
    private Author Author;
    private String Price;
    private String PublishingYear;
    private PublishingHouse PublishingHouse;

    public Book(){
        Name = "";
        Price = "";
        PublishingYear = "";
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Author getAuthor() {
        return Author;
    }

    public void setAuthor(Author author) {
        Author = author;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getPublishingYear() {
        return PublishingYear;
    }

    public void setPublishingYear(String publishingYear) {
        PublishingYear = publishingYear;
    }

    public PublishingHouse getPublishingHouse() {
        return PublishingHouse;
    }

    public void setPublishingHouse(PublishingHouse publishingHouse) {
        PublishingHouse = publishingHouse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(Name, book.Name) &&
                Objects.equals(Author, book.Author) &&
                Objects.equals(Price, book.Price) &&
                Objects.equals(PublishingYear, book.PublishingYear) &&
                Objects.equals(PublishingHouse, book.PublishingHouse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Author, Price, PublishingYear, PublishingHouse);
    }

    @Override
    public String toString() {
        return "\"" + Name + "\"   " + Author;
    }
}