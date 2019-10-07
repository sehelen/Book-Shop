package bookShop.businessLayer.seachers;

import bookShop.Main;
import bookShop.businessLayer.comparators.AuthorComparator;
import bookShop.dataLayer.Author;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AuthorSearcher extends BookShopSearcher {
    public AuthorSearcher() {
    }

    @Override
    public int Search(String strTofind) {
        List<Author> arrayList = new ArrayList(Main.objectLists.AllLists.get(0));
        Comparator<Author> comparator = Comparator.comparing(obj -> obj.getName());
        Author a = new Author();
        a.setName(strTofind);
        return Collections.binarySearch(arrayList, a, comparator);
    }
}
