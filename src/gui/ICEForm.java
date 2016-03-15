package gui;

import human.ICE;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ICEForm {

    public static ArrayList<ICE> iceForm() {
        ArrayList<ICE> ices = new ArrayList<>();

        Stage window = new Stage();
        window.setTitle("Add ICE info");
        window.initModality(Modality.APPLICATION_MODAL);


        Label firstNameLabel = new Label("First name: ");
        Label lastNameLabel = new Label("Last name: ");
        Label phoneLabel = new Label("Phone number: ");
        Label IDLabel = new Label("ID: ");

        TextField firstNameField = new TextField();
        TextField lastNameField = new TextField();
        TextField phoneField = new TextField();
        TextField IDField = new TextField();

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window.close());

        Button addICE = new Button("Add contact");
        addICE.setOnAction(e -> {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String phoneNumber = phoneField.getText();
            String id = IDField.getText();

            ices.add(new ICE(firstName, lastName, id, phoneNumber));

        });

        GridPane pane = new GridPane();

        pane.addColumn(0, firstNameLabel, lastNameLabel, phoneLabel, IDLabel);
        pane.addColumn(1, firstNameField, lastNameField, phoneField, IDField);
        pane.add(closeButton, 2, 2);

        Scene scene = new Scene(pane);
        window.setScene(scene);
        window.showAndWait();

        System.out.println(ices);

        return ices;
    }
}