package bookShop.businessLayer.deletors;

import bookShop.Main;
import bookShop.dataLayer.*;

import java.util.ArrayList;
import java.util.List;

public class DeliveryTypeDeletor extends BookShopDeletor {
    public DeliveryTypeDeletor() {
    }

    @Override
    public void Delete(BookShop obj) {
        Main.objectLists.AllLists.get(4).remove(obj);
        List<Delivery> deleteList = new ArrayList<Delivery>();
        DeliveryType d = (DeliveryType) obj;
        for (BookShop o : Main.objectLists.AllLists.get(3)){
            Delivery delivery = (Delivery) o;
            if(delivery.getDeliveryType().equals(d)) {
               deleteList.add(delivery);
            }
        }
        for (Delivery delivery : deleteList){
            Main.deletorList.BookShopDeletorList.get(3).Delete(delivery);
        }
    }
}
