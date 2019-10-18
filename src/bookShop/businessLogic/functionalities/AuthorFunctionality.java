package bookShop.businessLogic.functionalities;

import bookShop.Main;
import bookShop.entities.Author;
import bookShop.entities.Book;
import bookShop.entities.BookShop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AuthorFunctionality implements BookShopFunctionality {
    @Override
    public BookShop create() {
        Author author = new Author();
        Main.objectLists.allLists.get(0).add(author);
        return author;
    }

    @Override
    public void delete(BookShop selectedObject) {
        Main.objectLists.allLists.get(0).remove(selectedObject);
        List<Book> deleteList = new ArrayList<Book>();
        Author a = (Author) selectedObject;
        for (BookShop b : Main.objectLists.allLists.get(1)) {
            Book book = (Book) b;
            if (book.getAuthor().equals(a))
                deleteList.add(book);
        }
        for (Book b : deleteList) {
            Main.classFunctionsList.bookShopFunctionalities.get(1).delete(b);
        }
    }

    @Override
    public int search(String strTofind) {
        /*List<Author> arrayList = new ArrayList(Main.objectLists.allLists.get(0));
        Comparator<Author> comparator = Comparator.comparing(obj -> obj.getName());
        Author a = new Author();
        a.setName(strTofind);
        return Collections.binarySearch(arrayList, a, comparator);*/

        for (BookShop b : Main.objectLists.allLists.get(0)) {
            Author a = (Author) b;
            if (a.getName().equals(strTofind)) return Main.objectLists.allLists.get(0).indexOf(a);
        }
        return -1;
    }

    @Override
    public void sort(Integer index) {
        Comparator<Author> comparator = Comparator.comparing(obj -> obj.getName());
        List<Author> arrayList = new ArrayList(Main.objectLists.allLists.get(index));
        Collections.sort(arrayList, comparator);
        Main.objectLists.allLists.get(index).setAll(arrayList);
    }
}
