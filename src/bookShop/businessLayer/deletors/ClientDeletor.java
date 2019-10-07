package bookShop.businessLayer.deletors;

import bookShop.Main;
import bookShop.dataLayer.Book;
import bookShop.dataLayer.BookShop;
import bookShop.dataLayer.Client;
import bookShop.dataLayer.Order;

public class ClientDeletor extends BookShopDeletor {
    public ClientDeletor() {
    }

    @Override
    public void Delete(BookShop obj) {
        Main.objectLists.AllLists.get(2).remove(obj);
        for (BookShop o : Main.objectLists.AllLists.get(5)){
            Order order = (Order)o;
            Client c = (Client) obj;
            if(order.getClient().equals(c)) {
                Main.deletorList.BookShopDeletorList.get(5).Delete(order);
            }
        }
    }
}
