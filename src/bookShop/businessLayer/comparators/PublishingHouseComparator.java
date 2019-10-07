package bookShop.businessLayer.comparators;

import bookShop.Main;
import bookShop.dataLayer.Author;
import bookShop.dataLayer.PublishingHouse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PublishingHouseComparator extends BookShopComparator {
    public PublishingHouseComparator() {
    }

    @Override
    public void Compare(Integer index) {
        Comparator<PublishingHouse> comparator = Comparator.comparing(obj -> obj.getName());
        List<PublishingHouse> arrayList = new ArrayList(Main.objectLists.AllLists.get(index));
        Collections.sort(arrayList, comparator);
        Main.objectLists.AllLists.get(index).setAll(arrayList);
    }
}
