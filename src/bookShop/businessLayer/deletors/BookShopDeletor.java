package bookShop.businessLayer.deletors;

import bookShop.dataLayer.BookShop;

public abstract class BookShopDeletor {
    public BookShopDeletor() {
    }

    public abstract void Delete(BookShop obj);
}
