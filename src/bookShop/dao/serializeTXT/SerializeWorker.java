package bookShop.dao.serializeTXT;

import bookShop.Main;
import bookShop.dao.ObjectListWrapper;
import bookShop.entities.BookShop;

import java.io.IOException;
import java.util.List;

import static bookShop.Main.objectLists;

public class SerializeWorker {

    private static String path = "D:\\1. Учеба\\3 курс\\5 сем\\ВТ\\BookShop\\dataFiles\\";

    /**
     * Uploads all the lists from the txt files
     */
    public static void load() {
        Serializer<List<BookShop>> loader = new Serializer<>();
        try {
            objectLists.allLists.get(0).setAll(loader.load(path + "AuthorsSerializer.txt"));
            objectLists.allLists.get(1).setAll(loader.load(path + "BooksSerializer.txt"));
            objectLists.allLists.get(2).setAll(loader.load(path + "ClientsSerializer.txt"));
            objectLists.allLists.get(3).setAll(loader.load(path + "DeliveriesSerializer.txt"));
            objectLists.allLists.get(4).setAll(loader.load(path + "DeliveryTypesSerializer.txt"));
            objectLists.allLists.get(5).setAll(loader.load(path + "OrdersSerializer.txt"));
            objectLists.allLists.get(6).setAll(loader.load(path + "PublishingHousesSerializer.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves all the lists to the txt files
     */
    public static void save() {
        Serializer<List<BookShop>> saver = new Serializer<>();
        try {
            saver.save((List) Main.objectLists.allLists.get(0), path + "AuthorsSerializer.txt");
            saver.save((List) Main.objectLists.allLists.get(1), path + "BooksSerializer.txt");
            saver.save((List) Main.objectLists.allLists.get(2), path + "ClientsSerializer.txt");
            saver.save((List) Main.objectLists.allLists.get(3), path + "DeliveriesSerializer.txt");
            saver.save((List) Main.objectLists.allLists.get(4), path + "DeliveryTypesSerializer.txt");
            saver.save((List) Main.objectLists.allLists.get(5), path + "OrdersSerializer.txt");
            saver.save((List) Main.objectLists.allLists.get(6), path + "PublishingHousesSerializer.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
