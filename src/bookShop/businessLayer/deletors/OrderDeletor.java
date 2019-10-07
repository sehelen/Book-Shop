package bookShop.businessLayer.deletors;

import bookShop.Main;
import bookShop.dataLayer.BookShop;

public class OrderDeletor extends  BookShopDeletor {
    public OrderDeletor() {
    }

    @Override
    public void Delete(BookShop obj) {
        Main.objectLists.AllLists.get(5).remove(obj);
    }
}
