package bookShop.entities;

import java.io.Serializable;
import java.util.Objects;

public class PublishingHouse extends BookShop implements Serializable {
    private String name;
    private String country;
    private String foundationYear;

    public PublishingHouse() {
        this.name = "";
        this.country = "";
        this.foundationYear = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(String foundationYear) {
        this.foundationYear = foundationYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublishingHouse that = (PublishingHouse) o;
        return foundationYear.equals(that.foundationYear) &&
                name.equals(that.name) &&
                Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country, foundationYear);
    }

    @Override
    public String toString() {
        return name;
    }
}
