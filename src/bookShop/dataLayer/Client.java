package bookShop.dataLayer;

import java.io.Serializable;
import java.util.Objects;

public class Client extends BookShop implements Serializable {

    private String FirstName;
    private String LastName;
    private String Email;
    private String PhoneNumber;

    public Client(){
        this.FirstName = "";
        this.LastName = "";
        this.Email = "";
        this.PhoneNumber = "";
    }


    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return FirstName.equals(client.FirstName) &&
                LastName.equals(client.LastName) &&
                Email.equals(client.Email) &&
                PhoneNumber.equals(client.PhoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FirstName, LastName, Email, PhoneNumber);
    }

    @Override
    public String toString() {
        return LastName + "  " + FirstName;
    }
}
