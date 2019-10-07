package bookShop.businessLayer.deletors;

import bookShop.Main;
import bookShop.dataLayer.BookShop;
import bookShop.dataLayer.Client;
import bookShop.dataLayer.Delivery;
import bookShop.dataLayer.Order;

public class DeliveryDeletor extends BookShopDeletor {
    public DeliveryDeletor() {
    }

    @Override
    public void Delete(BookShop obj) {
        Main.objectLists.AllLists.get(3).remove(obj);
        for (BookShop o : Main.objectLists.AllLists.get(5)){
            Order order = (Order)o;
            Delivery d = (Delivery) obj;
            if(order.getDelivery().equals(d)) {
                Main.deletorList.BookShopDeletorList.get(5).Delete(order);
            }
        }
    }
}
