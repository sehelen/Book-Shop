package bookShop.businessLayer.creators;

import bookShop.Main;
import bookShop.dataLayer.BookShop;
import bookShop.dataLayer.Delivery;
import bookShop.dataLayer.Order;

public class OrderCreator extends BookShopCreator {
    public OrderCreator() {
    }

    @Override
    public BookShop Create() {
        return new Order();
    }

    @Override
    public void AddToList(BookShop o) {
        Order order = (Order) o;
        Main.objectLists.AllLists.get(5).add(order);
    }
}
