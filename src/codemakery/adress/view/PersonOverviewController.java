
package codemakery.adress.view;

import codemakery.adress.MainApp;
import codemakery.adress.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *Картa N 4890****7643 kod 008 остальные реквизиты http://w.qiwi.ru
 * @author Lama
 */
public class PersonOverviewController {
    /**
     * левая часть на PersonOverview/  Таблица всех людей.
     */
    @FXML
    private TableView<Person> personTable; 
    
    /**
     * колонка с личными именами людей из адресной книги
     */
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    
    /**
     * колонка с фамилиями из адресной книги
     */
    @FXML
    private TableColumn<Person, String> lastNameColumn;

    //Labels
    @FXML
    private Label firstnameLabel;
    
    @FXML
    private Label lastNameLabel;
    
    @FXML
    private Label streetLabel;
    
    @FXML
    private Label postalCodeLabel;
    
    @FXML
    private Label birthDayLabel;
    
    @FXML 
    private Label cityLabel;
    
    /**
     * Reference to main application
     */
    private MainApp mainApp;
    
    /**
     * the constructor is called before initialize()
     */
    public PersonOverviewController(){
        
    }
    
    /**
     * init controller class. automatically called after fxml class is loaded
     */
    @FXML
    private void initialize(){
        //init two person tabes in two columns
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().getFirstName());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().getLastName());
         // Clear person details.
    showPersonDetails(null);

    // Listen for selection changes and show the person details when changed.
    personTable.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> showPersonDetails(newValue));
        
    }
    
    /**
     * Is caled by the main app
     * @param mainApp главное приложение. Точка входа в программу
     */
    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
        
        //add observable list data to table
        personTable.setItems(mainApp.getPersonData());
    }
    
    private void showPersonDetails(Person person){
        if(person != null){
            //fill the labels with info from person object
            firstnameLabel.setText(person.getFirstName().getValue());
            lastNameLabel.setText(person.getLastName().getValue());
            streetLabel.setText(person.getStreet().getValue());
            birthDayLabel.setText(person.getBirthday().getValue().toString());
            
        } else {
            //Person is null, remove text
            firstnameLabel.setText("");
            lastNameLabel.setText("");
            birthDayLabel.setText("");
            streetLabel.setText("");
            cityLabel.setText("");
            postalCodeLabel.setText("");
        }
    }   
}
