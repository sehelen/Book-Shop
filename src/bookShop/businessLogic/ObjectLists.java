package bookShop.businessLogic;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import bookShop.entities.BookShop;

import java.io.Serializable;
import java.util.List;

public class ObjectLists implements Serializable {

    public List<ObservableList<BookShop>> allLists = FXCollections.observableArrayList();

    public ObjectLists() {
        ObservableList<BookShop> authorList = FXCollections.observableArrayList();
        ObservableList<BookShop> bookShops = FXCollections.observableArrayList();
        ObservableList<BookShop> clientList = FXCollections.observableArrayList();
        ObservableList<BookShop> deliveryList = FXCollections.observableArrayList();
        ObservableList<BookShop> deliveryTypeList = FXCollections.observableArrayList();
        ObservableList<BookShop> orderList = FXCollections.observableArrayList();
        ObservableList<BookShop> publishingHouseList = FXCollections.observableArrayList();

        allLists.add(authorList);
        allLists.add(bookShops);
        allLists.add(clientList);
        allLists.add(deliveryList);
        allLists.add(deliveryTypeList);
        allLists.add(orderList);
        allLists.add(publishingHouseList);
    }

    public List<ObservableList<BookShop>> getAllLists() {
        return allLists;
    }

    public void setAllLists(List<ObservableList<BookShop>> allLists) {
        this.allLists = allLists;
    }
}
