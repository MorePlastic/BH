package gui;

import human.ICE;
import human.Kids;
import human.Teacher;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

public class AddTeacher {

    public static void display(ObservableList<Teacher> list) {

        ArrayList<ICE> ices = new ArrayList<>();
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);

        window.setTitle("Add new teacher");

        Label firstNameLabel = new Label("First name: ");
        Label lastNameLabel = new Label("Last name: ");
        Label cprLabel = new Label("CPR: ");

        TextField firstNameField = new TextField();
        TextField lastNameField = new TextField();
        TextField cprField = new TextField();

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window.close());

        Button addTeacher = new Button("Add new teacher");
        addTeacher.setOnAction(e -> {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String cpr = cprField.getText();

            list.add(new Teacher(firstName, lastName, cpr, false));
            window.close();
        });

        GridPane layout = new GridPane();
        layout.addColumn(0, firstNameLabel, lastNameLabel, cprLabel);
        layout.addColumn(1, firstNameField, lastNameField, cprField);

        layout.add(addTeacher, 2, 2);
        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.showAndWait();
    }
}
