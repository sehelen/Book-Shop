package bookShop.businessLayer.creators;

import bookShop.Main;
import bookShop.dataLayer.BookShop;
import bookShop.dataLayer.Delivery;
import bookShop.dataLayer.DeliveryType;

public class DeliveryTypeCreator extends BookShopCreator {
    public DeliveryTypeCreator() {
    }

    @Override
    public BookShop Create() {
        return new DeliveryType();
    }

    @Override
    public void AddToList(BookShop o) {
        DeliveryType deliveryType = (DeliveryType) o;
        Main.objectLists.AllLists.get(4).add(deliveryType);
    }
}
