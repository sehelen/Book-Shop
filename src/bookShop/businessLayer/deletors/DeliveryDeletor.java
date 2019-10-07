package bookShop.businessLayer.deletors;

import bookShop.Main;
import bookShop.dataLayer.BookShop;

public class DeliveryDeletor extends BookShopDeletor {
    public DeliveryDeletor() {
    }

    @Override
    public void Delete(BookShop obj) {
        Main.objectLists.AllLists.get(3).remove(obj);
    }
}
