package bookShop.businessLayer.deletors;

import bookShop.Main;
import bookShop.dataLayer.Author;
import bookShop.dataLayer.Book;
import bookShop.dataLayer.BookShop;
import bookShop.dataLayer.Order;

import java.util.ArrayList;
import java.util.List;

public class BookDeletor extends BookShopDeletor {
    public BookDeletor() {
    }

    @Override
    public void Delete(BookShop obj) {
        Main.objectLists.AllLists.get(1).remove(obj);
        List<Order> deleteList = new ArrayList<Order>();
        Book b = (Book) obj;
        for (BookShop o : Main.objectLists.AllLists.get(5)){
            Order order = (Order)o;
            if(order.getBook().equals(b)) {
               deleteList.add(order);
            }
        }
        for (Order o: deleteList){
            Main.deletorList.BookShopDeletorList.get(5).Delete(o);
        }
    }
}
