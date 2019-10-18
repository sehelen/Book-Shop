package bookShop.businessLogic.functionalities;

import bookShop.Main;
import bookShop.entities.Book;
import bookShop.entities.BookShop;
import bookShop.entities.PublishingHouse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PublishingHouseFunctionaliry implements BookShopFunctionality {
    @Override
    public BookShop create() {
        PublishingHouse publishingHouse = new PublishingHouse();
        Main.objectLists.allLists.get(6).add(publishingHouse);
        return publishingHouse;
    }

    @Override
    public void delete(BookShop selectedObject) {
        Main.objectLists.allLists.get(6).remove(selectedObject);
        List<Book> deleteList = new ArrayList<Book>();
        PublishingHouse p = (PublishingHouse) selectedObject;
        for (BookShop o : Main.objectLists.allLists.get(1)) {
            Book book = (Book) o;
            if (book.getPublishingHouse().equals(p)) {
                deleteList.add(book);
            }
        }
        for (Book b : deleteList) {
            Main.classFunctionsList.bookShopFunctionalities.get(1).delete(b);
        }
    }

    @Override
    public int search(String strTofind) {
        for (BookShop b : Main.objectLists.allLists.get(6)) {
            PublishingHouse p = (PublishingHouse) b;
            if (p.getName().equals(strTofind)) return Main.objectLists.allLists.get(6).indexOf(b);
        }
        return -1;
    }

    @Override
    public void sort(Integer index) {
        Comparator<PublishingHouse> comparator = Comparator.comparing(obj -> obj.getName());
        List<PublishingHouse> arrayList = new ArrayList(Main.objectLists.allLists.get(index));
        Collections.sort(arrayList, comparator);
        Main.objectLists.allLists.get(index).setAll(arrayList);
    }
}
