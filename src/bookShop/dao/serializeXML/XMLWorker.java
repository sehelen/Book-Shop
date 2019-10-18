package bookShop.dao.serializeXML;

public class XMLWorker {

    private static String path = "D:\\1. Учеба\\3 курс\\5 сем\\ВТ\\BookShop\\dataFiles\\";

    /**
     * Uploads all the lists from xml files
     */
    public static void load() {
        XMLManager.loadDataFromFile(path + "Authors.txt", 0);
        XMLManager.loadDataFromFile(path + "Books.txt", 1);
        XMLManager.loadDataFromFile(path + "Clients.txt", 2);
        XMLManager.loadDataFromFile(path + "Deliveries.txt", 3);
        XMLManager.loadDataFromFile(path + "DeliveryTypes.txt", 4);
        XMLManager.loadDataFromFile(path + "Orders.txt", 5);
        XMLManager.loadDataFromFile(path + "PublishingHouses.txt", 6);
    }

    /**
     * save all the list to the xml files
     */
    public static void save() {
        XMLManager.saveDataToFile(path + "Authors.txt", 0);
        XMLManager.saveDataToFile(path + "Books.txt", 1);
        XMLManager.saveDataToFile(path + "Clients.txt", 2);
        XMLManager.saveDataToFile(path + "Deliveries.txt", 3);
        XMLManager.saveDataToFile(path + "DeliveryTypes.txt", 4);
        XMLManager.saveDataToFile(path + "Orders.txt", 5);
        XMLManager.saveDataToFile(path + "PublishingHouses.txt", 6);
    }
}
