package bookShop.businessLayer.comparators;

import bookShop.Main;
import bookShop.dataLayer.Author;
import bookShop.dataLayer.Delivery;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DeliveryComparator extends BookShopComparator{
    public DeliveryComparator() {
    }

    @Override
    public void Compare(Integer index) {
        Comparator<Delivery> comparator = new Comparator<Delivery>() {
            @Override
            public int compare(Delivery o1, Delivery o2) {
                DateFormat format = new SimpleDateFormat("dd.mm.yyyy");
                try {
                    Date date1 = format.parse(o1.getDate());
                    Date date2 = format.parse(o2.getDate());
                    return date1.compareTo(date2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return o1.getDate().compareTo(o2.getDate());
            }
        };
        List<Delivery> arrayList = new ArrayList(Main.objectLists.AllLists.get(index));
        Collections.sort(arrayList, comparator);
        Main.objectLists.AllLists.get(index).setAll(arrayList);
    }
}
