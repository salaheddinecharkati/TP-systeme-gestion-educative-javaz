package Lst;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Modifierdepartement extends Application {

    private TextField idField;
    private TextField nouveauNomField;
    private TextField nouveauResponsableField;
    private TextField nouvelleFiliereField;
    private Button modifierButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Modifier Entités");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        // Créer les éléments de l'interface
        Label idLabel = new Label("ID:");
        GridPane.setConstraints(idLabel, 0, 0);

        idField = new TextField();
        GridPane.setConstraints(idField, 1, 0);

        Label nouveauNomLabel = new Label("Nouveau Nom:");
        GridPane.setConstraints(nouveauNomLabel, 0, 1);

        nouveauNomField = new TextField();
        GridPane.setConstraints(nouveauNomField, 1, 1);

        Label nouveauResponsableLabel = new Label("Nouveau Responsable:");
        GridPane.setConstraints(nouveauResponsableLabel, 0, 2);

        nouveauResponsableField = new TextField();
        GridPane.setConstraints(nouveauResponsableField, 1, 2);

        Label nouvelleFiliereLabel = new Label("Nouvelle Filière:");
        GridPane.setConstraints(nouvelleFiliereLabel, 0, 3);

        nouvelleFiliereField = new TextField();
        GridPane.setConstraints(nouvelleFiliereField, 1, 3);

        modifierButton = new Button("Modifier");
        GridPane.setConstraints(modifierButton, 1, 4);
        modifierButton.setOnAction(e -> modifierEntites());

        // Ajouter les éléments au GridPane
        grid.getChildren().addAll(idLabel, idField, nouveauNomLabel, nouveauNomField,
                nouveauResponsableLabel, nouveauResponsableField, nouvelleFiliereLabel, nouvelleFiliereField,
                modifierButton);

        Scene scene = new Scene(grid, 350, 200);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void modifierEntites() {
        // Récupérer les valeurs des champs
        int id = Integer.parseInt(idField.getText());
        String nouveauNom = nouveauNomField.getText();
        String nouveauResponsable = nouveauResponsableField.getText();
        String nouvelleFiliere = nouvelleFiliereField.getText();

        // Se connecter à la base de données et effectuer la modification
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion", "root", "")) {
            String sql = "UPDATE departement SET nom = ?, responsable = ?, filiere = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, nouveauNom);
                statement.setString(2, nouveauResponsable);
                statement.setString(3, nouvelleFiliere);
                statement.setInt(4, id);
                int rowsAffected = statement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("departement modifiée avec succès !");
                } else {
                    System.out.println("Aucune departement trouvée avec cet ID.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


