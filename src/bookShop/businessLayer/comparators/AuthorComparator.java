package bookShop.businessLayer.comparators;

import bookShop.Main;
import bookShop.dataLayer.Author;
import bookShop.dataLayer.BookShop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AuthorComparator extends BookShopComparator{

    public AuthorComparator() {
    }

    @Override
    public void Compare(Integer index) {
        Comparator<Author> comparator = Comparator.comparing(obj -> obj.getName());
        List<Author> arrayList = new ArrayList(Main.objectLists.AllLists.get(index));
        Collections.sort(arrayList, comparator);
        Main.objectLists.AllLists.get(index).setAll(arrayList);
    }
}
