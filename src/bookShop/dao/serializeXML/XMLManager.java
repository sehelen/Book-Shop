package bookShop.dao.serializeXML;

import bookShop.Main;
import bookShop.dao.ObjectListWrapper;
import bookShop.entities.*;
import javafx.scene.control.Alert;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XMLManager {

    private static ArrayList<Class> classArray = new ArrayList<Class>(
            Arrays.asList(Author.class, Book.class, Client.class, Delivery.class, DeliveryType.class, Order.class, PublishingHouse.class)
    );

    /**
     * Uploads list identified by classIndex into xml file path
     *
     * @param path
     * @param classIndex
     */
    public static void loadDataFromFile(String path, Integer classIndex) {
        try {
            File file = new File(path);
            JAXBContext context = JAXBContext
                    .newInstance(ObjectListWrapper.class, Author.class, classArray.get(classIndex));
            Unmarshaller um = context.createUnmarshaller();

            // Чтение serializeXML из файла и демаршализация.
            ObjectListWrapper wrapper = (ObjectListWrapper) um.unmarshal(file);

            Main.objectLists.allLists.get(classIndex).clear();
            Main.objectLists.allLists.get(classIndex).setAll(wrapper.getObjects());

        } catch (Exception e) { // catches ANY exception
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not load data");
            alert.setContentText("Could not load data from file:\n");

            alert.showAndWait();
        }
    }

    /**
     * Saves list identified by classIndex into the xml file path
     *
     * @param path
     * @param classIndex
     */
    public static void saveDataToFile(String path, Integer classIndex) {
        try {
            File file = new File(path);
            JAXBContext context = JAXBContext
                    .newInstance(ObjectListWrapper.class, classArray.get(classIndex));
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Обёртываем наши данные
            ObjectListWrapper wrapper = new ObjectListWrapper();
            wrapper.setObjects((List) Main.objectLists.allLists.get(classIndex));

            // Маршаллируем и сохраняем serializeXML в файл.
            m.marshal(wrapper, file);

        } catch (Exception e) { // catches ANY exception
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not save data");
            alert.setContentText("Could not save data to file:\n");

            alert.showAndWait();
        }
    }
}
