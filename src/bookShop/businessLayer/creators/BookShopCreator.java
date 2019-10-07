package bookShop.businessLayer.creators;

import bookShop.dataLayer.BookShop;

public abstract class BookShopCreator {
    public BookShopCreator() {
    }

    public abstract BookShop Create();
    public abstract void AddToList(BookShop o);
}
