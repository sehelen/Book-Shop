package bookShop.businessLayer;

import bookShop.Main;
import bookShop.dataLayer.Author;
import bookShop.dataLayer.ObjectListWrapper;
import javafx.scene.control.Alert;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class XMLManager {

    public static void loadDataFromFile(String path, Integer classIndex) {
        try {
            File file = new File(path);
            JAXBContext context = JAXBContext
                    .newInstance(ObjectListWrapper.class, Author.class, Main.classArray.get(classIndex));
            Unmarshaller um = context.createUnmarshaller();

            // Чтение XML из файла и демаршализация.
            ObjectListWrapper wrapper = (ObjectListWrapper) um.unmarshal(file);

            Main.objectLists.AllLists.get(classIndex).clear();
            Main.objectLists.AllLists.get(classIndex).setAll(wrapper.getObjects());

        } catch (Exception e) { // catches ANY exception
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not load data");
            alert.setContentText("Could not load data from file:\n");

            alert.showAndWait();
        }
    }


    public static void saveDataToFile(String path, Integer classIndex) {
        try {
            File file = new File(path);
            JAXBContext context = JAXBContext
                    .newInstance(ObjectListWrapper.class, Main.classArray.get(classIndex));
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Обёртываем наши данные
            ObjectListWrapper wrapper = new ObjectListWrapper();
            wrapper.setObjects((List) Main.objectLists.AllLists.get(classIndex));

            // Маршаллируем и сохраняем XML в файл.
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
