package bookShop.businessLayer.seachers;

import bookShop.businessLayer.comparators.BookShopComparator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SearcherList {
    public ObservableList<BookShopSearcher> BookShopSearcherList = FXCollections.observableArrayList();

    public SearcherList() {
        BookShopSearcherList.add(new AuthorSearcher());
        BookShopSearcherList.add(new BookSearcher());
        BookShopSearcherList.add(new ClientSearcher());
        BookShopSearcherList.add(new DeliverySearcher());
        BookShopSearcherList.add(new DeliveryTypeSearcher());
        BookShopSearcherList.add(new OrderSearcher());
        BookShopSearcherList.add(new PublishingHouseSearcher());
    }
}
