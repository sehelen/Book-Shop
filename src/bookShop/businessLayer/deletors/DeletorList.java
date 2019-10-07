package bookShop.businessLayer.deletors;

import bookShop.businessLayer.seachers.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DeletorList {
    public ObservableList<BookShopDeletor> BookShopDeletorList = FXCollections.observableArrayList();

    public DeletorList() {
        BookShopDeletorList.add(new AuthorDeletor());
        BookShopDeletorList.add(new BookDeletor());
        BookShopDeletorList.add(new ClientDeletor());
        BookShopDeletorList.add(new DeliveryDeletor());
        BookShopDeletorList.add(new DeliveryTypeDeletor());
        BookShopDeletorList.add(new OrderDeletor());
        BookShopDeletorList.add(new PublishingHouseDeletor());
    }
}
