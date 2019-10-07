package bookShop.businessLayer.comparators;

import bookShop.Main;
import bookShop.dataLayer.Author;
import bookShop.dataLayer.Order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderComparator extends BookShopComparator {

    public OrderComparator() {
    }

    @Override
    public void Compare(Integer index) {
        Comparator<Order> comparator = new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                int ID1 = Integer.parseInt(o1.getID());
                int ID2 = Integer.parseInt(o2.getID());
                if (ID1 > ID2) return 1;
                else if (ID1 < ID2) return -1;
                else return 0;
            }
        };
        List<Order> arrayList = new ArrayList(Main.objectLists.AllLists.get(index));
        Collections.sort(arrayList, comparator);
        Main.objectLists.AllLists.get(index).setAll(arrayList);
    }
}
