package bookShop.businessLayer.creators;

import bookShop.Main;
import bookShop.dataLayer.Book;
import bookShop.dataLayer.BookShop;
import bookShop.dataLayer.Delivery;

public class DeliveryCreator extends BookShopCreator {
    public DeliveryCreator() {
    }

    @Override
    public BookShop Create() {
        return new Delivery();
    }

    @Override
    public void AddToList(BookShop o) {
        Delivery delivery = (Delivery) o;
        Main.objectLists.AllLists.get(3).add(delivery);
    }
}
