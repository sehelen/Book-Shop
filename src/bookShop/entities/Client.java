package bookShop.entities;

import java.io.Serializable;
import java.util.Objects;

public class Client extends BookShop implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    public Client() {
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.phoneNumber = "";
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return firstName.equals(client.firstName) &&
                lastName.equals(client.lastName) &&
                email.equals(client.email) &&
                phoneNumber.equals(client.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, phoneNumber);
    }

    @Override
    public String toString() {
        return lastName + "  " + firstName;
    }
}
