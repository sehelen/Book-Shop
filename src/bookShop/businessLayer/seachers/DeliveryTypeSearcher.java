package bookShop.businessLayer.seachers;

import bookShop.Main;
import bookShop.dataLayer.Author;
import bookShop.dataLayer.DeliveryType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DeliveryTypeSearcher extends BookShopSearcher  {
    public DeliveryTypeSearcher() {
    }

    @Override
    public int Search(String str) {
        List<DeliveryType> arrayList = new ArrayList(Main.objectLists.AllLists.get(4));
        Comparator<DeliveryType> comparator = Comparator.comparing(obj -> obj.getType());
        DeliveryType deliveryType = new DeliveryType();
        deliveryType.setType(str);
        return Collections.binarySearch(arrayList, deliveryType, comparator);
    }
}
