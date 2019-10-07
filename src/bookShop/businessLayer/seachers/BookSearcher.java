package bookShop.businessLayer.seachers;

import bookShop.Main;
import bookShop.dataLayer.Author;
import bookShop.dataLayer.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookSearcher extends BookShopSearcher{

    public BookSearcher() {
    }

    @Override
    public int Search(String str) {
        List<Book> arrayList = new ArrayList(Main.objectLists.AllLists.get(1));
        Comparator<Book> comparator = Comparator.comparing(obj -> obj.getName());
        Book book = new Book();
        book.setName(str);
        return Collections.binarySearch(arrayList, book, comparator);
    }
}
