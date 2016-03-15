package gui;

import human.Kids;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddKid {

    public static void display(ObservableList<Kids> list) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);

        window.setTitle("Add new kid");

        Label firstNameLabel = new Label("First name: ");
        Label lastNameLabel = new Label("Last name: ");
        Label cprLabel = new Label("CPR: ");

        TextField firstNameField = new TextField();
        TextField lastNameField = new TextField();
        TextField cprField = new TextField();

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window.close());

        Button addKid = new Button("Add new kid");
        addKid.setOnAction(e -> {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String cpr = cprField.getText();

            list.add(new Kids(firstName, lastName, cpr));

        });

        GridPane layout = new GridPane();
        layout.addColumn(0, firstNameLabel, lastNameLabel, cprLabel);
        layout.addColumn(1, firstNameField, lastNameField, cprField);
        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.showAndWait();
    }
}
