package bookShop.businessLayer.seachers;

import bookShop.Main;
import bookShop.dataLayer.Order;
import bookShop.dataLayer.PublishingHouse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PublishingHouseSearcher extends BookShopSearcher {
    public PublishingHouseSearcher() {
    }

    @Override
    public int Search(String str) {
        List<PublishingHouse> arrayList = new ArrayList(Main.objectLists.AllLists.get(6));
        Comparator<PublishingHouse> comparator = Comparator.comparing(obj -> obj.getName());
        PublishingHouse publishingHouse = new PublishingHouse();
        publishingHouse.setName(str);
        return Collections.binarySearch(arrayList, publishingHouse, comparator);
    }
}
