package bookShop.businessLogic.functionalities;

import bookShop.Main;
import bookShop.entities.Book;
import bookShop.entities.BookShop;
import bookShop.entities.Order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookFunctionality implements BookShopFunctionality {
    @Override
    public BookShop create() {
        Book book = new Book();
        Main.objectLists.allLists.get(1).add(book);
        return book;
    }

    @Override
    public void delete(BookShop selectedObject) {
        Main.objectLists.allLists.get(1).remove(selectedObject);
        List<Order> deleteList = new ArrayList<Order>();
        Book b = (Book) selectedObject;
        for (BookShop o : Main.objectLists.allLists.get(5)) {
            Order order = (Order) o;
            if (order.getBook().equals(b)) {
                deleteList.add(order);
            }
        }
        for (Order o : deleteList) {
            Main.classFunctionsList.bookShopFunctionalities.get(5).delete(o);
        }
    }

    @Override
    public int search(String strTofind) {
        for (BookShop b : Main.objectLists.allLists.get(1)) {
            Book book = (Book) b;
            if (book.getName().equals(strTofind)) return Main.objectLists.allLists.get(1).indexOf(b);
        }
        return -1;
    }

    @Override
    public void sort(Integer index) {
        Comparator<Book> comparator = Comparator.comparing(obj -> obj.getName());
        List<Book> arrayList = new ArrayList(Main.objectLists.allLists.get(index));
        Collections.sort(arrayList, comparator);
        Main.objectLists.allLists.get(index).setAll(arrayList);
    }
}
