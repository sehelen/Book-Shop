package bookShop.viewLayer;

import bookShop.Main;
import bookShop.businessLayer.comparators.BookShopComparator;
import bookShop.businessLayer.creators.BookShopCreator;
import bookShop.businessLayer.deletors.BookShopDeletor;
import bookShop.businessLayer.seachers.BookShopSearcher;;
import bookShop.dataLayer.BookShop;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Type;


import static bookShop.Main.classList;

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



    @FXML
    private void initialize() {
        choiceBox.setVisible(false);
        textFieldEdit.setVisible(false);
        btnSave.setVisible(false);
        btnCancel.setVisible(false);
        classListView.setItems(classList);
        classListView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showObjects(newValue));

    }

    private void showObjects(String name){
        textFieldEdit.setVisible(false);
        choiceBox.setVisible(false);
        textFieldEdit.clear();
        btnSave.setVisible(false);
        btnCancel.setVisible(false);
        propertyTable.setItems(null);
        selectedClass = Main.classNamesArray.indexOf(name);
        ObservableList<BookShop> objList = FXCollections.observableArrayList(Main.objectLists.AllLists.get(selectedClass));
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

    private void showProperties() throws NoSuchFieldException, IllegalAccessException{
        if (objListView.getSelectionModel().getSelectedIndex() > -1){
            ObservableList<Property> propertyList = FXCollections.observableArrayList();
            Field[] fields = selectedObject.getClass().getDeclaredFields();
            for (Field f: fields){
                f.setAccessible(true);
                Object value = f.get(selectedObject);
                if (value != null) propertyList.add(new Property(f.getName(),value.toString()));
                else propertyList.add(new Property(f.getName(),""));
            }
            nameColumn.setCellValueFactory(new PropertyValueFactory<Property, String>("name"));
            valueColumn.setCellValueFactory(new PropertyValueFactory<Property, String>("value"));
            propertyTable.setItems(propertyList);
        }
    }

    @FXML
    private void handleCreateObject(){
        BookShopCreator newCreator =  Main.factoryList.BookShopCreatorsList.get(selectedClass);
        BookShop newObj = newCreator.Create();
        newCreator.AddToList(newObj);
        objListView.setItems(Main.objectLists.AllLists.get(selectedClass));
    }

    @FXML
    private void handleDeleteObject(){
        BookShopDeletor deletor = Main.deletorList.BookShopDeletorList.get(selectedClass);
        deletor.Delete(selectedObject);
        //обновляем view список
        showObjects(classListView.getSelectionModel().getSelectedItem());
        //objListView.refresh();
    }

    @FXML
    private void handleEditObject() throws NoSuchFieldException{
        Property property = propertyTable.getSelectionModel().getSelectedItem();
        this.selectedFieldName = property.getName();
        Field field = selectedObject.getClass().getDeclaredField(property.getName());
        Type fieldT = field.getType();
        if (((Class) fieldT).getName().equals("java.lang.String"))
        {
            textFieldEdit.setVisible(true);
            btnSave.setVisible(true);
            btnCancel.setVisible(true);
        }
        else
        {
            ShowChoiceBox((Class)fieldT);
        }
     }


    public void ShowChoiceBox(Class className)
    {
        Integer index = Main.classArray.indexOf(className);
        ObservableList<BookShop> objList = FXCollections.observableArrayList(Main.objectLists.AllLists.get(index));
        choiceBox.setItems(objList);
        choiceBox.setVisible(true);
        btnSave.setVisible(true);
        btnCancel.setVisible(true);
    }

    public void clickCancel(){
        choiceBox.setVisible(false);
        textFieldEdit.setVisible(false);
        textFieldEdit.clear();
        btnSave.setVisible(false);
        btnCancel.setVisible(false);
    }

    public void clickSave(){
        if (choiceBox.isVisible()) {
            try {
                SaveChanges(choiceBox.getValue());
                choiceBox.setVisible(false);
                btnSave.setVisible(false);
                btnCancel.setVisible(false);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        else if (textFieldEdit.isVisible()) {
            try {
                SaveChanges(textFieldEdit.getText());
                textFieldEdit.setVisible(false);
                textFieldEdit.clear();
                btnSave.setVisible(false);
                btnCancel.setVisible(false);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
    }

    public void SaveChanges(Object value) throws NoSuchFieldException{
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

    public void clickFind(){
        BookShopSearcher searcher = Main.searcherList.BookShopSearcherList.get(selectedClass);
        Integer index = searcher.Search(textFieldFind.getText());
        if (index < 0) {
            propertyTable.setItems(null);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("No object found");
            alert.setContentText("Could not find an object by \"" + textFieldFind.getText() + "\"");
            alert.showAndWait();
        }
        else{
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

    public void clickSort(){
        BookShopComparator comparator = Main.comparatorList.BookShopComparatorList.get(selectedClass);
        comparator.Compare(selectedClass);
        objListView.refresh();
        showObjects(classListView.getSelectionModel().getSelectedItem());
    }
}
