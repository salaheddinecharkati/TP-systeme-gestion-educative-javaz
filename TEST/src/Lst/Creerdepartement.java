package Lst;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Creerdepartement extends Application {

    private ObservableList<String> filieres = FXCollections.observableArrayList(
            "Informatique", "Biologie", "Chimie", "Mathématiques");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Création de Département");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        TextField idField = new TextField();
        idField.setPromptText("ID");

        TextField nomField = new TextField();
        nomField.setPromptText("Nom");

        TextField responsableField = new TextField();
        responsableField.setPromptText("Responsable");

        ComboBox<String> filiereComboBox = new ComboBox<>(filieres);
        filiereComboBox.setPromptText("Choisir une filière");

        Button creerButton = new Button("Créer Département");
        creerButton.setOnAction(e -> {
            // Récupérer les valeurs saisies
            String id = idField.getText();
            String nom = nomField.getText();
            String responsable = responsableField.getText();
            String filiere = filiereComboBox.getValue();

            // Insérer les données dans la base de données
            insertDepartement(id, nom, responsable, filiere);
        });

        grid.add(new Label("ID:"), 0, 0);
        grid.add(idField, 1, 0);
        grid.add(new Label("Nom:"), 0, 1);
        grid.add(nomField, 1, 1);
        grid.add(new Label("Responsable:"), 0, 2);
        grid.add(responsableField, 1, 2);
        grid.add(new Label("Filière:"), 0, 3);
        grid.add(filiereComboBox, 1, 3);
        grid.add(creerButton, 1, 4);

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void insertDepartement(String id, String nom, String responsable, String filiere) {
        String url = "jdbc:mysql://localhost:3306/gestion";
        String utilisateur = "root";
        String motDePasse = "";

        try (Connection connection = DriverManager.getConnection(url,utilisateur,motDePasse)) {
            String query = "INSERT INTO departement (id, nom, responsable, filiere) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, id);
                preparedStatement.setString(2, nom);
                preparedStatement.setString(3, responsable);
                preparedStatement.setString(4, filiere);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Département créé avec succès dans la base de données.");
                } else {
                    System.out.println("Échec de la création du département.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


