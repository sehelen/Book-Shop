package bookShop.businessLogic.functionalities;

import bookShop.Main;
import bookShop.entities.BookShop;
import bookShop.entities.Client;
import bookShop.entities.Order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClientFunctionality implements BookShopFunctionality {
    @Override
    public BookShop create() {
        Client client = new Client();
        Main.objectLists.allLists.get(2).add(client);
        return client;
    }

    @Override
    public void delete(BookShop selectedObject) {
        Main.objectLists.allLists.get(2).remove(selectedObject);
        List<Order> deleteList = new ArrayList<Order>();
        Client c = (Client) selectedObject;
        for (BookShop o : Main.objectLists.allLists.get(5)) {
            Order order = (Order) o;
            if (order.getClient().equals(c)) {
                deleteList.add(order);
            }
        }
        for (Order o : deleteList) {
            Main.classFunctionsList.bookShopFunctionalities.get(5).delete(o);
        }
    }

    @Override
    public int search(String strTofind) {
        for (BookShop b : Main.objectLists.allLists.get(2)) {
            Client c = (Client) b;
            if (c.getLastName().equals(strTofind)) return Main.objectLists.allLists.get(2).indexOf(c);
        }
        return -1;
    }

    @Override
    public void sort(Integer index) {
        Comparator<Client> comparator = Comparator.comparing(obj -> obj.getLastName());
        List<Client> arrayList = new ArrayList(Main.objectLists.allLists.get(index));
        Collections.sort(arrayList, comparator);
        Main.objectLists.allLists.get(index).setAll(arrayList);
    }
}
