package bookShop.dataLayer;

import java.io.Serializable;
import java.util.Objects;

public class PublishingHouse extends BookShop implements Serializable {
    private String Name;
    private String Country;
    private String FoundationYear;

    public PublishingHouse(){
        this.Name = "";
        this.Country = "";
        this.FoundationYear = "";
    }

    public PublishingHouse(String name) {
        Name = name;
    }

    public PublishingHouse(String Name, String Country, String  FoundationYear)
    {
        this.Country = Country;
        this.FoundationYear = FoundationYear;
        this.Name = Name;
    }

    public String getName() { return Name; }

    public void setName(String name) { Name = name; }

    public String getCountry() { return Country; }

    public void setCountry(String country) { Country = country; }

    public String  getFoundationYear() { return FoundationYear; }

    public void setFoundationYear(String  foundationYear) { FoundationYear = foundationYear; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublishingHouse that = (PublishingHouse) o;
        return FoundationYear.equals(that.FoundationYear) &&
                Name.equals(that.Name) &&
                Objects.equals(Country, that.Country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Country, FoundationYear);
    }

    @Override
    public String toString() {
        return Name;
    }
}
