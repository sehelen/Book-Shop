package bookShop.businessLogic.functionalities;

import bookShop.Main;
import bookShop.entities.BookShop;
import bookShop.entities.Delivery;
import bookShop.entities.DeliveryType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DeliveryTypeFunctionality implements BookShopFunctionality {
    @Override
    public BookShop create() {
        DeliveryType deliveryType = new DeliveryType();
        Main.objectLists.allLists.get(4).add(deliveryType);
        return deliveryType;
    }

    @Override
    public void delete(BookShop selectedObject) {
        Main.objectLists.allLists.get(4).remove(selectedObject);
        List<Delivery> deleteList = new ArrayList<Delivery>();
        DeliveryType d = (DeliveryType) selectedObject;
        for (BookShop o : Main.objectLists.allLists.get(3)) {
            Delivery delivery = (Delivery) o;
            if (delivery.getDeliveryType().equals(d)) {
                deleteList.add(delivery);
            }
        }
        for (Delivery delivery : deleteList) {
            Main.classFunctionsList.bookShopFunctionalities.get(3).delete(delivery);
        }
    }

    @Override
    public int search(String strTofind) {
        for (BookShop b : Main.objectLists.allLists.get(4)) {
            DeliveryType d = (DeliveryType) b;
            if (d.getType().equals(strTofind)) return Main.objectLists.allLists.get(4).indexOf(b);
        }
        return -1;
    }

    @Override
    public void sort(Integer index) {
        Comparator<DeliveryType> comparator = Comparator.comparing(obj -> obj.getType());
        List<DeliveryType> arrayList = new ArrayList(Main.objectLists.allLists.get(index));
        Collections.sort(arrayList, comparator);
        Main.objectLists.allLists.get(index).setAll(arrayList);
    }
}
