package bookShop.businessLogic.functionalities;

import bookShop.Main;
import bookShop.entities.BookShop;
import bookShop.entities.Delivery;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DeliveryFunctionality implements BookShopFunctionality {
    @Override
    public BookShop create() {
        Delivery delivery = new Delivery();
        Main.objectLists.allLists.get(3).add(delivery);
        return delivery;
    }

    @Override
    public void delete(BookShop selectedObject) {
        Main.objectLists.allLists.get(3).remove(selectedObject);
    }

    @Override
    public int search(String strTofind) {
        for (BookShop b : Main.objectLists.allLists.get(3)) {
            Delivery d = (Delivery) b;
            if (d.getDate().equals(strTofind)) return Main.objectLists.allLists.get(3).indexOf(b);
        }
        return -1;
    }

    @Override
    public void sort(Integer index) {
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
        List<Delivery> arrayList = new ArrayList(Main.objectLists.allLists.get(index));
        Collections.sort(arrayList, comparator);
        Main.objectLists.allLists.get(index).setAll(arrayList);
    }
}
