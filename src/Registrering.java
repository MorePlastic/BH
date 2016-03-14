import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Registrering extends Application{

    public static void main(String[] args) {
        launch();
    }


    public void start(Stage primaryStage) throws Exception {

        TabPane tabs = new TabPane();

        Tab kidTab = new Tab("Kids");
        Tab teacherTab = new Tab("Teachers");

        kidTab.setClosable(false);
        teacherTab.setClosable(false);


        tabs.getTabs().addAll(kidTab, teacherTab);

        Kids test = new Kids("Emil", "Plepian", "Swag", false, "spasser");

        test.addContact(new ICE("a", "b", "c", false));

        ObservableList<Kids> kidses = FXCollections.observableArrayList
                (new Kids("jonas", "nielsen", "06022005", false, "Ill"),
                new Kids("Nicklas", "Jonasen", "12042004", true, "Muh"),
                new Kids("Emil", "Jensen", "20122003", false, "blop"),
                        test);


        TableView<Kids> kidsTableView = new TableView<>();
        kidsTableView.itemsProperty().setValue(kidses);

        TableColumn<Kids, String> kidsFirstName = new TableColumn<>("First Name: ");
        TableColumn<Kids, String> kidsLastName = new TableColumn<>("Last Name: ");
        TableColumn<Kids, String> kidsCpr = new TableColumn<>("Cpr: ");
        TableColumn<Kids, CheckBox> checkIn = new TableColumn<>("Check Out: ");
        TableColumn<Kids, CheckBox> checkOut = new TableColumn<>("Check In: ");
        TableColumn<Kids, Button> ICEButton = new TableColumn<>("ICE: ");


        kidsFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        kidsLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        kidsCpr.setCellValueFactory(new PropertyValueFactory<>("id"));
        checkOut.setCellValueFactory(new PropertyValueFactory<>("checkOut"));
        checkIn.setCellValueFactory(new PropertyValueFactory<>("checkIn"));
        ICEButton.setCellValueFactory(new PropertyValueFactory<>("button"));


        kidsFirstName.setCellFactory(TextFieldTableCell.forTableColumn());
        kidsLastName.setCellFactory(TextFieldTableCell.forTableColumn());
        kidsCpr.setCellFactory(TextFieldTableCell.forTableColumn());


        kidsTableView.setEditable(true);


        kidsTableView.getColumns().addAll(kidsFirstName, kidsLastName, kidsCpr, checkOut, checkIn, ICEButton);

        kidTab.setContent(kidsTableView);

        ObservableList<Teacher> teachers = FXCollections.observableArrayList(
                new Teacher("Hashtag", "YOLO", "666", false)
        );

        TableView<Teacher> teacherTableView = new TableView<>();
        teacherTableView.itemsProperty().setValue(teachers);

        teacherTab.setContent(teacherTableView);


        StackPane pane = new StackPane();
        pane.getChildren().add(tabs);
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Persons");
        primaryStage.setWidth(650);
        primaryStage.setHeight(400);
        primaryStage.show();
    }

}
