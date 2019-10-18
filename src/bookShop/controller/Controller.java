package bookShop.controller;

import bookShop.Main;
import bookShop.businessLogic.functionalities.BookShopFunctionality;
import bookShop.entities.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

public class Controller {

    @FXML
    private ListView<String> classListView;

    @FXML
    private ListView<BookShop> objListView;

    @FXML
    private TableView<Property> propertyTable;
    @FXML
    private TableColumn<Property, String> nameColumn = new TableColumn<>();
    @FXML
    private TableColumn<Property, String> valueColumn = new TableColumn<>();

    @FXML
    private Label className;

    @FXML
    private ChoiceBox choiceBox;

    @FXML
    private TextField textFieldFind;

    @FXML
    private TextField textFieldEdit;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancel;

    private String selectedFieldName;
    private BookShop selectedObject;
    private Integer selectedClass;
    private ArrayList<String> classNamesArray = new ArrayList<String>(
            Arrays.asList("Authors", "Books", "Clients", "Delivery", "Delivery Types", "Orders", "Publishing Houses")
    );

    @FXML
    private void initialize() {
        choiceBox.setVisible(false);
        textFieldEdit.setVisible(false);
        btnSave.setVisible(false);
        btnCancel.setVisible(false);

        ObservableList<String> classList = FXCollections.observableArrayList(classNamesArray);
        classListView.setItems(classList);
        classListView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showObjects(newValue));
    }

    /**
     * Shows all objects of the class
     *
     * @param name Name of the class
     */
    private void showObjects(String name) {
        textFieldEdit.setVisible(false);
        choiceBox.setVisible(false);
        textFieldEdit.clear();
        btnSave.setVisible(false);
        btnCancel.setVisible(false);
        propertyTable.setItems(null);
        selectedClass = classNamesArray.indexOf(name);
        ObservableList<BookShop> objList = FXCollections.observableArrayList(Main.objectLists.allLists.get(selectedClass));
        className.setText("Объекты класса \"" + name + "\"");
        objListView.setItems(objList);
        objListView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    try {
                        selectedObject = newValue;
                        showProperties();
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
    }

    /**
     * Shows all properties of selected object
     *
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    private void showProperties() throws NoSuchFieldException, IllegalAccessException {
        if (objListView.getSelectionModel().getSelectedIndex() > -1) {
            ObservableList<Property> propertyList = FXCollections.observableArrayList();
            Field[] fields = selectedObject.getClass().getDeclaredFields();
            for (Field f : fields) {
                f.setAccessible(true);
                Object value = f.get(selectedObject);
                if (value != null) propertyList.add(new Property(f.getName(), value.toString()));
                else propertyList.add(new Property(f.getName(), ""));
            }
            nameColumn.setCellValueFactory(new PropertyValueFactory<Property, String>("name"));
            valueColumn.setCellValueFactory(new PropertyValueFactory<Property, String>("value"));
            propertyTable.setItems(propertyList);
        }
    }

    @FXML
    private void handleCreateObject() {
        BookShopFunctionality creator = Main.classFunctionsList.bookShopFunctionalities.get(selectedClass);
        creator.create();
        objListView.setItems(Main.objectLists.allLists.get(selectedClass));
    }

    @FXML
    private void handleDeleteObject() {
        BookShopFunctionality deletor = Main.classFunctionsList.bookShopFunctionalities.get(selectedClass);
        deletor.delete(selectedObject);
        //обновляем view список
        showObjects(classListView.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void handleEditObject() throws NoSuchFieldException {
        Property property = propertyTable.getSelectionModel().getSelectedItem();
        this.selectedFieldName = property.getName();
        Field field = selectedObject.getClass().getDeclaredField(property.getName());
        try {
            field.setAccessible(true);
            if (field.get(selectedObject) instanceof String) {
                textFieldEdit.setVisible(true);
                btnSave.setVisible(true);
                btnCancel.setVisible(true);
            } else {
                showChoiceBox(field.getType());
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the objects of class, which can be chosen
     *
     * @param className Name of the class
     */
    public void showChoiceBox(Class className) {
        ArrayList<Class> classArray = new ArrayList<Class>(
                Arrays.asList(Author.class, Book.class, Client.class, Delivery.class, DeliveryType.class, Order.class, PublishingHouse.class)
        );
        Integer index = classArray.indexOf(className);
        ObservableList<BookShop> objList = FXCollections.observableArrayList(Main.objectLists.allLists.get(index));
        choiceBox.setItems(objList);
        choiceBox.setVisible(true);
        btnSave.setVisible(true);
        btnCancel.setVisible(true);
    }

    /**
     * Cancels process of editing
     */
    public void clickCancel() {
        choiceBox.setVisible(false);
        textFieldEdit.setVisible(false);
        textFieldEdit.clear();
        btnSave.setVisible(false);
        btnCancel.setVisible(false);
    }

    public void clickSave() {
        if (choiceBox.isVisible()) {
            try {
                saveChanges(choiceBox.getValue());
                choiceBox.setVisible(false);
                btnSave.setVisible(false);
                btnCancel.setVisible(false);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        } else if (textFieldEdit.isVisible()) {
            try {
                saveChanges(textFieldEdit.getText());
                textFieldEdit.setVisible(false);
                textFieldEdit.clear();
                btnSave.setVisible(false);
                btnCancel.setVisible(false);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveChanges(Object value) throws NoSuchFieldException {
        Field field = selectedObject.getClass().getDeclaredField(selectedFieldName);
        field.setAccessible(true);
        try {
            field.set(selectedObject, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            showProperties();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        objListView.refresh();
    }

    public void clickFind() {
        BookShopFunctionality searcher = Main.classFunctionsList.bookShopFunctionalities.get(selectedClass);
        Integer index = searcher.search(textFieldFind.getText());
        if (index < 0) {
            propertyTable.setItems(null);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("No object found");
            alert.setContentText("Could not find an object by \"" + textFieldFind.getText() + "\"");
            alert.showAndWait();
        } else {
            selectedObject = objListView.getItems().get(index);
            objListView.getSelectionModel().select(index);
            try {
                showProperties();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        textFieldFind.clear();
    }

    public void clickSort() {
        BookShopFunctionality sorter = Main.classFunctionsList.bookShopFunctionalities.get(selectedClass);
        sorter.sort(selectedClass);
        objListView.refresh();
        showObjects(classListView.getSelectionModel().getSelectedItem());
    }
}
