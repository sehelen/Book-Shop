package bookShop.businessLayer.deletors;

import bookShop.Main;
import bookShop.dataLayer.*;

public class DeliveryTypeDeletor extends BookShopDeletor {
    public DeliveryTypeDeletor() {
    }

    @Override
    public void Delete(BookShop obj) {
        Main.objectLists.AllLists.get(4).remove(obj);
        for (BookShop o : Main.objectLists.AllLists.get(3)){
            Delivery delivery = (Delivery) o;
            DeliveryType d = (DeliveryType) obj;
            if(delivery.getDeliveryType().equals(d)) {
                Main.deletorList.BookShopDeletorList.get(3).Delete(delivery);
            }
        }
    }
}
