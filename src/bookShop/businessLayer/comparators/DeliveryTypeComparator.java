package bookShop.businessLayer.comparators;

import bookShop.Main;
import bookShop.dataLayer.Author;
import bookShop.dataLayer.DeliveryType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DeliveryTypeComparator extends BookShopComparator {

    public DeliveryTypeComparator() {
    }

    @Override
    public void Compare(Integer index) {
        Comparator<DeliveryType> comparator = Comparator.comparing(obj -> obj.getType());
        List<DeliveryType> arrayList = new ArrayList(Main.objectLists.AllLists.get(index));
        Collections.sort(arrayList, comparator);
        Main.objectLists.AllLists.get(index).setAll(arrayList);
    }
}
