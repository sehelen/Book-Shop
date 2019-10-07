package bookShop.businessLayer.deletors;

import bookShop.Main;
import bookShop.dataLayer.*;

import java.util.ArrayList;
import java.util.List;

public class OrderDeletor extends  BookShopDeletor {
    public OrderDeletor() {
    }

    @Override
    public void Delete(BookShop obj) {
        Main.objectLists.AllLists.get(5).remove(obj);
        List<Delivery> deleteList = new ArrayList<Delivery>();
        Order a = (Order) obj;
        for (BookShop b : Main.objectLists.AllLists.get(3)){
            Delivery delivery = (Delivery) b;
            if(delivery.getOrder().equals(a))
                deleteList.add(delivery);
        }
        for (Delivery d: deleteList){
            Main.deletorList.BookShopDeletorList.get(3).Delete(d);
        }
    }
}
