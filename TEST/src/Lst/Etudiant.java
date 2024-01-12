package Lst;





import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Etudiant extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Gestion des etudients");

        Button creerButton = new Button("creer un compte etudient");
        Button modifierButton = new Button("modifier les infos");
        Button supprimerButton = new Button("supprimer compte etudient");
       

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



