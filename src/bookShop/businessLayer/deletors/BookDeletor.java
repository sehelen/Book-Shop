package bookShop.businessLayer.deletors;

import bookShop.Main;
import bookShop.dataLayer.Author;
import bookShop.dataLayer.Book;
import bookShop.dataLayer.BookShop;
import bookShop.dataLayer.Order;

public class BookDeletor extends BookShopDeletor {
    public BookDeletor() {
    }

    @Override
    public void Delete(BookShop obj) {
        Main.objectLists.AllLists.get(1).remove(obj);
        for (BookShop o : Main.objectLists.AllLists.get(5)){
            Order order = (Order)o;
            System.out.println(order.getBook().toString());
            Book b = (Book) obj;
            if(order.getBook().equals(b)) {
                Main.deletorList.BookShopDeletorList.get(5).Delete(order);
            }
        }
    }
}
