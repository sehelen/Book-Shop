package bookShop.businessLayer.deletors;

import bookShop.Main;
import bookShop.dataLayer.Book;
import bookShop.dataLayer.BookShop;
import bookShop.dataLayer.Client;
import bookShop.dataLayer.Order;

import java.util.ArrayList;
import java.util.List;

public class ClientDeletor extends BookShopDeletor {
    public ClientDeletor() {
    }

    @Override
    public void Delete(BookShop obj) {
        Main.objectLists.AllLists.get(2).remove(obj);
        List<Order> deleteList = new ArrayList<Order>();
        Client c = (Client) obj;
        for (BookShop o : Main.objectLists.AllLists.get(5)){
            Order order = (Order)o;
            if(order.getClient().equals(c)) {
                deleteList.add(order);
            }
        }
        for (Order o: deleteList){
            Main.deletorList.BookShopDeletorList.get(5).Delete(o);
        }
    }
}
