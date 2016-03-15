package gui;

import human.ICE;
import human.Kids;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ICEForm {

    public static ArrayList<ICE> iceFormList() {
        ArrayList<ICE> ices = new ArrayList<>();

        Stage window = new Stage();
        window.setTitle("Add ICE info");
        window.initModality(Modality.APPLICATION_MODAL);


        Label firstNameLabel = new Label("First name:");
        Label lastNameLabel = new Label("Last name:");
        Label phoneLabel = new Label("Phone number:");
        Label IDLabel = new Label("ID:");

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

        return ices;
    }

    public static ICE iceForm() {
        ICE ice = new ICE();

        Stage window = new Stage();
        window.setTitle("Add ICE info");
        window.initModality(Modality.APPLICATION_MODAL);


        Label firstNameLabel = new Label("First name:");
        Label lastNameLabel = new Label("Last name:");
        Label phoneLabel = new Label("Phone number:");
        Label IDLabel = new Label("ID:");

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

            ice.setPhoneNumber(phoneNumber);
            ice.setId(id);
            ice.setFirstName(firstName);
            ice.setLastName(lastName);

        });

        GridPane pane = new GridPane();

        pane.addColumn(0, firstNameLabel, lastNameLabel, phoneLabel, IDLabel);
        pane.addColumn(1, firstNameField, lastNameField, phoneField, IDField);
        pane.add(closeButton, 0, 5);
        pane.add(addICE, 1, 5);

        Scene scene = new Scene(pane);
        window.setScene(scene);
        window.showAndWait();


        return ice;
    }
    public static void displayICEs(Kids kid) {
        Stage window = new Stage();

        TableView<ICE> iceTableView = new TableView<>();
        iceTableView.setEditable(true);
        iceTableView.itemsProperty().setValue(FXCollections.observableArrayList(kid.getContacts()));

        TableColumn<ICE, String> firstName = new TableColumn<>("First name:");
        TableColumn<ICE, String> lastName = new TableColumn<>("Last name");
        TableColumn<ICE, String> phoneNumber = new TableColumn<>("Phone number");
        TableColumn<ICE, String> id = new TableColumn<>("ID");

        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        firstName.setCellFactory(TextFieldTableCell.forTableColumn());
        lastName.setCellFactory(TextFieldTableCell.forTableColumn());
        id.setCellFactory(TextFieldTableCell.forTableColumn());
        phoneNumber.setCellFactory(TextFieldTableCell.forTableColumn());

        iceTableView.getColumns().addAll(firstName, lastName, phoneNumber, id);

        BorderPane pane = new BorderPane();
        pane.setCenter(iceTableView);

        Button addICE = new Button("Add Contact");
        addICE.setOnAction(e -> kid.addContact(ICEForm.iceForm()));
        pane.setBottom(addICE);

        Scene scene = new Scene(pane);

        window.setScene(scene);
        window.show();

    }

}