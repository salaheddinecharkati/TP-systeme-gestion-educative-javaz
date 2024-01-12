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

public class Supprimerdepartement extends Application {

    private TextField idField;
    private Button supprimerButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Supprimer Département");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        // Créer les éléments de l'interface
        Label idLabel = new Label("ID:");
        GridPane.setConstraints(idLabel, 0, 0);

        idField = new TextField();
        GridPane.setConstraints(idField, 1, 0);

        supprimerButton = new Button("Supprimer");
        GridPane.setConstraints(supprimerButton, 1, 1);
        supprimerButton.setOnAction(e -> supprimerDepartement());

        // Ajouter les éléments au GridPane
        grid.getChildren().addAll(idLabel, idField, supprimerButton);

        Scene scene = new Scene(grid, 300, 100);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void supprimerDepartement() {
        // Récupérer la valeur du champ ID
        int id = Integer.parseInt(idField.getText());

        // Se connecter à la base de données et effectuer la suppression
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion", "root", "")) {
            String sql = "DELETE FROM departement WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                int rowsAffected = statement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Département supprimé avec succès !");
                } else {
                    System.out.println("Aucun département trouvé avec cet ID.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


