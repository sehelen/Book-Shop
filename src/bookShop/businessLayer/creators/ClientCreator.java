package bookShop.businessLayer.creators;

import bookShop.Main;
import bookShop.dataLayer.Book;
import bookShop.dataLayer.BookShop;
import bookShop.dataLayer.Client;

public class ClientCreator extends BookShopCreator {
    public ClientCreator() {
    }

    @Override
    public BookShop Create() {
        return new Client();
    }

    @Override
    public void AddToList(BookShop o) {
        Client client = (Client) o;
        Main.objectLists.AllLists.get(2).add(client);
    }
}
