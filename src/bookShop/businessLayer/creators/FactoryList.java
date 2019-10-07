package bookShop.businessLayer.creators;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import bookShop.businessLayer.creators.*;

import java.util.ArrayList;

public class FactoryList {

    public ObservableList<BookShopCreator> BookShopCreatorsList = FXCollections.observableArrayList();
    public FactoryList() {
        BookShopCreatorsList.add(new AuthorCreator());
        BookShopCreatorsList.add(new BookCreator());
        BookShopCreatorsList.add(new ClientCreator());
        BookShopCreatorsList.add(new DeliveryCreator());
        BookShopCreatorsList.add(new DeliveryTypeCreator());
        BookShopCreatorsList.add(new OrderCreator());
        BookShopCreatorsList.add(new PublishingHouseCreator());
    }
}
