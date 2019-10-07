package bookShop.businessLayer.deletors;

import bookShop.Main;
import bookShop.dataLayer.Author;
import bookShop.dataLayer.Book;
import bookShop.dataLayer.BookShop;

import java.util.ArrayList;
import java.util.List;

public class AuthorDeletor extends BookShopDeletor{

    public AuthorDeletor() {
    }

    @Override
    public void Delete(BookShop selectedObject) {
        Main.objectLists.AllLists.get(0).remove(selectedObject);
        List<Book> deleteList = new ArrayList<Book>();
        Author a = (Author)selectedObject;
        for (BookShop b : Main.objectLists.AllLists.get(1)){
            Book book = (Book)b;
            if(book.getAuthor().equals(a))
                deleteList.add(book);
        }
        for (Book b: deleteList){
            Main.deletorList.BookShopDeletorList.get(1).Delete(b);
        }
    }
}
