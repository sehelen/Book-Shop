package bookShop.dataLayer;

import java.io.Serializable;
import java.util.Objects;

public class Author extends BookShop implements Serializable {

    private String Name;
    private String Country;

    public Author(){
        Name = "";
        Country = "";
    }

    public Author(String name) {
        Name = name;
    }

    public Author(String Name, String Country){
        this.Name = Name;
        this.Country = Country;
    }

    public String getName() { return Name; }

    public void setName(String name) { Name = name; }

    public String getCountry() { return Country; }

    public void setCountry(String country) { Country = country; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Name.equals(author.Name) &&
                Objects.equals(Country, author.Country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Country);
    }

    @Override
    public String toString() {
        return Name;
    }
}

