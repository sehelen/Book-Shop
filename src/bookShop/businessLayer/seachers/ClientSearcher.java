package bookShop.businessLayer.seachers;

import bookShop.Main;
import bookShop.dataLayer.Book;
import bookShop.dataLayer.Client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClientSearcher extends BookShopSearcher {
    public ClientSearcher() {
    }

    @Override
    public int Search(String str) {
        List<Client> arrayList = new ArrayList(Main.objectLists.AllLists.get(2));
        Comparator<Client> comparator = Comparator.comparing(obj -> obj.getLastName());
        Client client= new Client();
        client.setLastName(str);
        return Collections.binarySearch(arrayList, client, comparator);
    }
}
