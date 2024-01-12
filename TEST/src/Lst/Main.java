package Lst;




import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Gestion Universitaire");

        Button etudiantButton = new Button("Étudiants");
        Button filiereButton = new Button("Filières");
        Button moduleButton = new Button("Modules");
        Button departementButton = new Button("Départements");
        Button enseignantButton = new Button("Enseignants");

        // Lier le bouton Étudiants à la classe EtudiantInterface
        etudiantButton.setOnAction(e -> openEtudiantInterface());

        filiereButton.setOnAction(e -> openfiliereInterface());
        moduleButton.setOnAction(e -> openmoduleInterface());
        departementButton.setOnAction(e -> opendepartementInterface());
        enseignantButton.setOnAction(e -> openenseignantInterface());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(etudiantButton, filiereButton, moduleButton, departementButton, enseignantButton);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    // Méthode pour ouvrir l'interface étudiant
    private void openEtudiantInterface() {
        Etudiant etudiantInterface = new Etudiant();
        etudiantInterface.start(new Stage());
    }
    private void openfiliereInterface() {
        Filiere filiereInterface = new Filiere();
        filiereInterface.start(new Stage());
    }
     private void openmoduleInterface() {
         Module moduleInterface = new Module();
        moduleInterface.start(new Stage());
    }
     private void opendepartementInterface() {
         Departement departementInterface = new Departement();
        departementInterface.start(new Stage());
    }
      private void openenseignantInterface() {
         Enseignant enseignantInterface = new Enseignant();
        enseignantInterface.start(new Stage());
    }
     
}


