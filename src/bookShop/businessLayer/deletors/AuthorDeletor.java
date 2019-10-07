package bookShop.businessLayer.deletors;

import bookShop.Main;
import bookShop.dataLayer.Author;
import bookShop.dataLayer.Book;
import bookShop.dataLayer.BookShop;
import bookShop.dataLayer.Order;

public class AuthorDeletor extends BookShopDeletor{

    public AuthorDeletor() {
    }

    @Override
    public void Delete(BookShop selectedObject) {
        Main.objectLists.AllLists.get(0).remove(selectedObject);
        for (BookShop b : Main.objectLists.AllLists.get(1)){
            Book book = (Book)b;
            Author a = (Author)selectedObject;
            if(book.getAuthor().equals(a)) {
                Main.deletorList.BookShopDeletorList.get(1).Delete(book);
            }
        }
    }
}
