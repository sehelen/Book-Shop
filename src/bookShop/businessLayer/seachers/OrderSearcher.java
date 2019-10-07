package bookShop.businessLayer.seachers;

import bookShop.Main;
import bookShop.dataLayer.Author;
import bookShop.dataLayer.Order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderSearcher extends BookShopSearcher  {
    public OrderSearcher() {
    }

    @Override
    public int Search(String str) {
        List<Order> arrayList = new ArrayList(Main.objectLists.AllLists.get(5));
        Comparator<Order> comparator = Comparator.comparing(obj -> obj.getID());
        Order order = new Order();
        order.setID(str);
        return Collections.binarySearch(arrayList, order, comparator);
    }
}
