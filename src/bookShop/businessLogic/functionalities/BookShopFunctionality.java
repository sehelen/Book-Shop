package bookShop.businessLogic.functionalities;

import bookShop.entities.BookShop;

public interface BookShopFunctionality {

    /**
     * Creates a new return
     *
     * @return
     */
    BookShop create();

    /**
     * Deletes the selectedObject
     *
     * @param selectedObject
     */
    void delete(BookShop selectedObject);

    /**
     * Looks for a match with the given strTofind
     *
     * @param strTofind
     * @return
     */
    int search(String strTofind);

    /**
     * Sorts the object's list identified by index
     *
     * @param index
     */
    void sort(Integer index);
}
