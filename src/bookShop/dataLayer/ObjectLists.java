package bookShop.dataLayer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import bookShop.dataLayer.BookShop;

import java.util.List;

public class ObjectLists {

    public List<ObservableList<BookShop>> AllLists = FXCollections.observableArrayList();

    public ObjectLists() {
        ObservableList<BookShop> AuthorList = FXCollections.observableArrayList();
        ObservableList<BookShop> BookList = FXCollections.observableArrayList();
        ObservableList<BookShop> ClientList = FXCollections.observableArrayList();
        ObservableList<BookShop> DeliveryList = FXCollections.observableArrayList();
        ObservableList<BookShop> DeliveryTypeList = FXCollections.observableArrayList();
        ObservableList<BookShop> OrderList = FXCollections.observableArrayList();
        ObservableList<BookShop> PublishingHouseList = FXCollections.observableArrayList();

        AllLists.add(AuthorList);
        AllLists.add(BookList);
        AllLists.add(ClientList);
        AllLists.add(DeliveryList);
        AllLists.add(DeliveryTypeList);
        AllLists.add(OrderList);
        AllLists.add(PublishingHouseList);
    }

    public List<ObservableList<BookShop>> getAllLists() {
        return AllLists;
    }

    public void setAllLists(List<ObservableList<BookShop>> allLists) {
        AllLists = allLists;
    }
}
