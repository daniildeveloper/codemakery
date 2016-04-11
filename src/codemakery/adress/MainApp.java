package codemakery.adress;

import codemakery.adress.model.Person;
import codemakery.adress.view.PersonOverviewController;
import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Lama
 */
public class MainApp extends Application {
    /**
     * Главное окно, букв. главная сцена
     */
    private Stage primaryStage;
    
    /**
     * Слой с менюшкой на которой прикрепляется adress list
     */
    private BorderPane rootLayout;
    
    
   /**
    * the data as an observable List of Persons
    */
    private ObservableList<Person> personData = FXCollections.observableArrayList();
    
    /**
     * Constructor
     */
    public MainApp(){
        //add some sample data
        personData.add(new Person("Hans", "Muster"));
        personData.add(new Person("Hans", "Hitler"));        
    }
    

    @Override
    public void start(Stage primaryStage) {
      this.primaryStage = primaryStage;
      this.primaryStage.setTitle("Address app");
              
      initRootLaoyut();
      
      showPersonOverview();
    }
    
    /**
     * Init root Layout from view/RootLayout.fxml
     */
    public void initRootLaoyut(){
        try{
            /**
             * load root laout from fxml file
             */
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            /**
             * show the scene containing the root layout
             */
            Scene s = new Scene(rootLayout);
            primaryStage.setScene(s);
            primaryStage.show();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    /**
     * show the personoverview inside the rootlayout
     */
    public void showPersonOverview(){
        try {
            //load personOverview
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PersonOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();
            
            //set personOverview into the center of root layout
            rootLayout.setCenter(personOverview);
            
            //give the controller access to the main app
            PersonOverviewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * @return the personData
     */
    public ObservableList<Person> getPersonData() {
        return personData;
    }
    
}
