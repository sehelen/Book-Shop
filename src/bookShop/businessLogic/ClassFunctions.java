package bookShop.businessLogic;

import bookShop.businessLogic.functionalities.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ClassFunctions {
    public ObservableList<BookShopFunctionality> bookShopFunctionalities = FXCollections.observableArrayList();

    public ClassFunctions() {
        bookShopFunctionalities.add(new AuthorFunctionality());
        bookShopFunctionalities.add(new BookFunctionality());
        bookShopFunctionalities.add(new ClientFunctionality());
        bookShopFunctionalities.add(new DeliveryFunctionality());
        bookShopFunctionalities.add(new DeliveryTypeFunctionality());
        bookShopFunctionalities.add(new OrderFunctionality());
        bookShopFunctionalities.add(new PublishingHouseFunctionaliry());
    }
}
