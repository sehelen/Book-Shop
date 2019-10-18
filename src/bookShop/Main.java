package bookShop;

import bookShop.dao.serializeTXT.SerializeWorker;
import bookShop.businessLogic.ClassFunctions;
import bookShop.businessLogic.ObjectLists;
import bookShop.dao.serializeXML.XMLWorker;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage primaryStage;
    public static ClassFunctions classFunctionsList = new ClassFunctions();
    public static ObjectLists objectLists = new ObjectLists();

    @Override
    public void start(Stage primaryStage) throws Exception {

        //XMLWorker.load();
        SerializeWorker.load();

        this.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("view/Main.fxml"));
        primaryStage.setTitle("Book Shop");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        //XMLWorker.save();
        //SerializeWorker.save();
        super.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
