package bookShop.businessLayer.seachers;

import bookShop.Main;
import bookShop.dataLayer.Book;
import bookShop.dataLayer.Delivery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DeliverySearcher extends BookShopSearcher  {
    public DeliverySearcher() {
    }

    @Override
    public int Search(String str) {
        List<Delivery> arrayList = new ArrayList(Main.objectLists.AllLists.get(3));
        Comparator<Delivery> comparator = Comparator.comparing(obj -> obj.getDate());
        Delivery delivery = new Delivery();
        delivery.setDate(str);
        return Collections.binarySearch(arrayList, delivery, comparator);
    }
}
