package bookShop.businessLayer.creators;

import bookShop.Main;
import bookShop.dataLayer.Book;
import bookShop.dataLayer.BookShop;

public class BookCreator extends BookShopCreator{
    public BookCreator() {
    }

    @Override
    public BookShop Create() {
        return new Book();
    }

    @Override
    public void AddToList(BookShop o) {
        Book book = (Book)o;
        Main.objectLists.AllLists.get(1).add(book);
    }
}
