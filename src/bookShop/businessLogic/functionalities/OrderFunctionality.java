package bookShop.businessLogic.functionalities;

import bookShop.Main;
import bookShop.entities.BookShop;
import bookShop.entities.Delivery;
import bookShop.entities.Order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderFunctionality implements BookShopFunctionality {
    @Override
    public BookShop create() {
        Order order = new Order();
        Main.objectLists.allLists.get(5).add(order);
        return order;
    }

    @Override
    public void delete(BookShop selectedObject) {
        Main.objectLists.allLists.get(5).remove(selectedObject);
        List<Delivery> deleteList = new ArrayList<Delivery>();
        Order a = (Order) selectedObject;
        for (BookShop b : Main.objectLists.allLists.get(3)) {
            Delivery delivery = (Delivery) b;
            if (delivery.getOrder().equals(a))
                deleteList.add(delivery);
        }
        for (Delivery d : deleteList) {
            Main.classFunctionsList.bookShopFunctionalities.get(3).delete(d);
        }
    }

    @Override
    public int search(String strTofind) {
        for (BookShop b : Main.objectLists.allLists.get(5)) {
            Order o = (Order) b;
            if (o.getId().equals(strTofind)) return Main.objectLists.allLists.get(5).indexOf(b);
        }
        return -1;
    }

    @Override
    public void sort(Integer index) {
        Comparator<Order> comparator = new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                int ID1 = Integer.parseInt(o1.getId());
                int ID2 = Integer.parseInt(o2.getId());
                if (ID1 > ID2) return 1;
                else if (ID1 < ID2) return -1;
                else return 0;
            }
        };
        List<Order> arrayList = new ArrayList(Main.objectLists.allLists.get(index));
        Collections.sort(arrayList, comparator);
        Main.objectLists.allLists.get(index).setAll(arrayList);
    }
}
