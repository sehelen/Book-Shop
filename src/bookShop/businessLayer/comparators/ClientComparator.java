package bookShop.businessLayer.comparators;

import bookShop.Main;
import bookShop.dataLayer.Author;
import bookShop.dataLayer.Client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClientComparator extends BookShopComparator {
    public ClientComparator() {
    }

    @Override
    public void Compare(Integer index) {
        Comparator<Client> comparator = Comparator.comparing(obj -> obj.getLastName());
        List<Client> arrayList = new ArrayList(Main.objectLists.AllLists.get(index));
        Collections.sort(arrayList, comparator);
        Main.objectLists.AllLists.get(index).setAll(arrayList);
    }
}
