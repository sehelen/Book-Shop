package bookShop.businessLayer.creators;

import bookShop.Main;
import bookShop.dataLayer.BookShop;
import bookShop.dataLayer.Delivery;
import bookShop.dataLayer.PublishingHouse;

public class PublishingHouseCreator extends BookShopCreator {
    public PublishingHouseCreator() {
    }

    @Override
    public BookShop Create() {
        return new PublishingHouse();
    }

    @Override
    public void AddToList(BookShop o) {
        PublishingHouse publishingHouse = (PublishingHouse) o;
        Main.objectLists.AllLists.get(6).add(publishingHouse);
    }
}
