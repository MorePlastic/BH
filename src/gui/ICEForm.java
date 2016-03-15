package gui;

import human.ICE;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ICEForm {

    public static ArrayList<ICE> iceForm() {
        ArrayList<ICE> ices = new ArrayList<>();

        Stage window = new Stage();
        window.setTitle("Add ICE info");

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

            ices.add(new ICE(firstName, lastName, "", phoneNumber));

        });

        GridPane pane = new GridPane();

        pane.addColumn(0, firstNameLabel, lastNameLabel, phoneLabel, IDLabel);
        pane.addColumn(1, firstNameField, lastNameField, phoneField, IDField);


        return ices;
    }
}