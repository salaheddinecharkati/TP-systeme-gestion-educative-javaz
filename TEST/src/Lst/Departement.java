package Lst;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Departement extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Gestion departement");

        Button creerButton = new Button("creer un nouveau departement");
        Button modifierButton = new Button("modifier departement");
        Button supprimerButton = new Button("supprimer departement");
       

        creerButton.setOnAction(e -> openCreerdepartementInterface());
        modifierButton.setOnAction(e -> openModifierdepartementInterface());
        supprimerButton.setOnAction(e -> openSupprimerdepartementInterface());
        
        VBox layout = new VBox(10);
        layout.getChildren().addAll(creerButton, modifierButton, supprimerButton);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
     private void openCreerdepartementInterface() {
       Creerdepartement creerdepartementInterface = new Creerdepartement();
        creerdepartementInterface.start(new Stage());}
     private void openModifierdepartementInterface() {
       Modifierdepartement modifierdepartementInterface = new Modifierdepartement();
        modifierdepartementInterface.start(new Stage());}
     private void openSupprimerdepartementInterface() {
       Supprimerdepartement supprimerdepartementInterface = new Supprimerdepartement();
        supprimerdepartementInterface.start(new Stage());}
   
}



