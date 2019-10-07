package bookShop.businessLayer.creators;

import bookShop.Main;
import bookShop.dataLayer.Author;
import bookShop.dataLayer.BookShop;


public class AuthorCreator extends BookShopCreator{
    public AuthorCreator() {
    }

    @Override
    public BookShop Create() {
        return new Author();
    }

    @Override
    public void AddToList(BookShop o) {
        Author author = (Author)o;
        Main.objectLists.AllLists.get(0).add(author);
    }

}
