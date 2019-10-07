package bookShop;

import bookShop.businessLayer.XMLManager;
import bookShop.businessLayer.deletors.DeletorList;
import bookShop.businessLayer.seachers.SearcherList;
import bookShop.dataLayer.*;
import bookShop.businessLayer.comparators.ComparatorList;
import bookShop.businessLayer.creators.FactoryList;
import bookShop.dataLayer.ObjectLists;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class Main extends Application {

    private String path = "D:\\1. Учеба\\3 курс\\5 сем\\ВТ\\BookShop\\dataFiles\\";
    public static Stage primaryStage;
    public static FactoryList factoryList = new FactoryList();
    public static ComparatorList comparatorList = new ComparatorList();
    public static SearcherList searcherList = new SearcherList();
    public static DeletorList deletorList = new DeletorList();
    public static ObjectLists objectLists = new ObjectLists();
    public static ArrayList<Class> classArray = new ArrayList<Class>(
            Arrays.asList(Author.class, Book.class, Client.class, Delivery.class, DeliveryType.class, Order.class, PublishingHouse.class)
    );
    public static ArrayList<String> classNamesArray = new ArrayList<String>(
            Arrays.asList("Авторы", "Книги", "Клиенты", "Доставки", "Виды доставок", "Заказы", "Издательства")
    );
    public static ObservableList<String> classList = FXCollections.observableArrayList(classNamesArray);

    @Override
    public void start(Stage primaryStage) throws Exception{

        LoadAllData();

        this.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("viewLayer/Main.fxml"));
        primaryStage.setTitle("Book Shop");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        SaveAllData();
        super.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void LoadAllData(){
        XMLManager.loadDataFromFile(path + "Authors.txt", 0);
        XMLManager.loadDataFromFile(path + "Books.txt", 1);
        XMLManager.loadDataFromFile(path + "Clients.txt", 2);
        XMLManager.loadDataFromFile(path + "Deliveries.txt", 3);
        XMLManager.loadDataFromFile(path + "DeliveryTypes.txt", 4);
        XMLManager.loadDataFromFile(path + "Orders.txt", 5);
        XMLManager.loadDataFromFile(path + "PublishingHouses.txt", 6);
    }

    public  void SaveAllData(){
        XMLManager.saveDataToFile(path + "Authors.txt", 0);
        XMLManager.saveDataToFile(path + "Books.txt", 1);
        XMLManager.saveDataToFile(path + "Clients.txt", 2);
        XMLManager.saveDataToFile(path + "Deliveries.txt", 3);
        XMLManager.saveDataToFile(path + "DeliveryTypes.txt", 4);
        XMLManager.saveDataToFile(path + "Orders.txt", 5);
        XMLManager.saveDataToFile(path + "PublishingHouses.txt", 6);
    }
}
