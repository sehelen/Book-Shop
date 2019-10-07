package bookShop.businessLayer.deletors;

import bookShop.Main;
import bookShop.dataLayer.BookShop;
import bookShop.dataLayer.Client;
import bookShop.dataLayer.Delivery;
import bookShop.dataLayer.Order;

import java.util.ArrayList;
import java.util.List;

public class DeliveryDeletor extends BookShopDeletor {
    public DeliveryDeletor() {
    }

    @Override
    public void Delete(BookShop obj) {
        Main.objectLists.AllLists.get(3).remove(obj);
        List<Order> deleteList = new ArrayList<Order>();
        Delivery d = (Delivery) obj;
        for (BookShop o : Main.objectLists.AllLists.get(5)){
            Order order = (Order)o;
            if(order.getDelivery().equals(d)) {
                deleteList.add(order);
            }
        }
        for (Order o: deleteList){
            Main.deletorList.BookShopDeletorList.get(5).Delete(o);
        }
    }
}
