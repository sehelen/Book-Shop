package bookShop.businessLayer.comparators;

import bookShop.businessLayer.comparators.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class ComparatorList {
    public ObservableList<BookShopComparator> BookShopComparatorList = FXCollections.observableArrayList();

    public ComparatorList() {
        BookShopComparatorList.add(new AuthorComparator());
        BookShopComparatorList.add(new BookComparator());
        BookShopComparatorList.add(new ClientComparator());
        BookShopComparatorList.add(new DeliveryComparator());
        BookShopComparatorList.add(new DeliveryTypeComparator());
        BookShopComparatorList.add(new OrderComparator());
        BookShopComparatorList.add(new PublishingHouseComparator());
    }
}
