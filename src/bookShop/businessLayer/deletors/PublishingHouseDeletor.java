package bookShop.businessLayer.deletors;

import bookShop.Main;
import bookShop.dataLayer.*;

import java.util.ArrayList;
import java.util.List;

public class PublishingHouseDeletor extends  BookShopDeletor {
    public PublishingHouseDeletor() {
    }

    @Override
    public void Delete(BookShop obj) {
        Main.objectLists.AllLists.get(6).remove(obj);
        List<Book> deleteList = new ArrayList<Book>();
        PublishingHouse p = (PublishingHouse) obj;
        for (BookShop o : Main.objectLists.AllLists.get(1)){
            Book book = (Book)o;
            if(book.getPublishingHouse().equals(p)) {
                deleteList.add(book);
            }
        }
        for (Book b: deleteList){
            Main.deletorList.BookShopDeletorList.get(1).Delete(b);
        }
    }
}
