package Lst;





import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Filiere extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Gestion des filieres");

        Button creerButton = new Button("creer une nouvelle filiere");
        Button modifierButton = new Button("modifier Filiere");
        Button supprimerButton = new Button("supprimer filiere");
       

        creerButton.setOnAction(e -> System.out.println("Afficher interface étudiants"));
        modifierButton.setOnAction(e -> System.out.println("Afficher interface filières"));
        supprimerButton.setOnAction(e -> System.out.println("Afficher interface modules"));
        
        VBox layout = new VBox(10);
        layout.getChildren().addAll(creerButton, modifierButton, supprimerButton);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}



