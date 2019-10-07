package bookShop.businessLayer.comparators;

import bookShop.Main;
import bookShop.dataLayer.Author;
import bookShop.dataLayer.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookComparator  extends BookShopComparator {
    public BookComparator() {
    }

    @Override
    public void Compare(Integer index) {
        Comparator<Book> comparator = Comparator.comparing(obj -> obj.getName());
        List<Book> arrayList = new ArrayList(Main.objectLists.AllLists.get(index));
        Collections.sort(arrayList, comparator);
        Main.objectLists.AllLists.get(index).setAll(arrayList);
    }
}
