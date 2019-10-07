package bookShop.businessLayer.deletors;

import bookShop.Main;
import bookShop.dataLayer.*;

public class PublishingHouseDeletor extends  BookShopDeletor {
    public PublishingHouseDeletor() {
    }

    @Override
    public void Delete(BookShop obj) {
        Main.objectLists.AllLists.get(6).remove(obj);
        for (BookShop o : Main.objectLists.AllLists.get(1)){
            Book book = (Book)o;
            PublishingHouse p = (PublishingHouse) obj;
            if(book.getPublishingHouse().equals(p)) {
                Main.deletorList.BookShopDeletorList.get(1).Delete(book);
            }
        }
    }
}
