import gui.AddKid;
import gui.AddTeacher;
import human.*;
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
        Tab addKidTab = new Tab("Add new kid");
        Tab addTeacherTab = new Tab("Add new teacher");

        kidTab.setClosable(false);
        teacherTab.setClosable(false);
        addKidTab.setClosable(false);
        addTeacherTab.setClosable(false);



        tabs.getTabs().addAll(kidTab, teacherTab, addKidTab, addTeacherTab);


        Kids test = new Kids("Emil", "Plepian", "Swag", false, "spasser");
        test.addContact(new ICE("a", "b", "hue", "007"));


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
        TableColumn<Kids, CheckBox> ill = new TableColumn<>("Sick?");
        TableColumn<Kids, Button> ICEButton = new TableColumn<>("ICE: ");
        TableColumn<Kids, Button> killKid = new TableColumn<>("Remove Kid: ");


        kidsFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        kidsLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        kidsCpr.setCellValueFactory(new PropertyValueFactory<>("id"));
        checkOut.setCellValueFactory(new PropertyValueFactory<>("checkOut"));
        checkIn.setCellValueFactory(new PropertyValueFactory<>("checkIn"));
        ill.setCellValueFactory(new PropertyValueFactory<>("illBox"));
        ICEButton.setCellValueFactory(new PropertyValueFactory<>("button"));
        killKid.setCellValueFactory(new PropertyValueFactory<>("kill"));

        Button kill = new Button("Remove");
        kill.setOnAction(e-> kidses.remove(1));


        kidsFirstName.setCellFactory(TextFieldTableCell.forTableColumn());
        kidsLastName.setCellFactory(TextFieldTableCell.forTableColumn());
        kidsCpr.setCellFactory(TextFieldTableCell.forTableColumn());


        kidsTableView.setEditable(true);


        kidsTableView.getColumns().addAll(kidsFirstName, kidsLastName, kidsCpr, checkOut, checkIn, ill, ICEButton, killKid);

        kidTab.setContent(kidsTableView);

        ObservableList<Teacher> teachers = FXCollections.observableArrayList(
                new Teacher("Hashtag", "YOLO", "666", false)
        );

        TableView<Teacher> teacherTableView = new TableView<>();
        teacherTableView.itemsProperty().setValue(teachers);

        TableColumn<Teacher, String> teacherFirstName = new TableColumn<>("First Name: ");
        TableColumn<Teacher, String> teacherLastName = new TableColumn<>("Last Name: ");
        TableColumn<Teacher, String> employeeID = new TableColumn<>("Employee ID: ");
        TableColumn<Teacher, CheckBox> teachercheckIn = new TableColumn<>("Check Out: ");
        TableColumn<Teacher, CheckBox> teachercheckOut = new TableColumn<>("Check In: ");
        TableColumn<Teacher, Button> killTeacher = new TableColumn<>("Remove Teacher: ");


        teacherFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        teacherLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        employeeID.setCellValueFactory(new PropertyValueFactory<>("id"));
        teachercheckOut.setCellValueFactory(new PropertyValueFactory<>("checkOut"));
        teachercheckIn.setCellValueFactory(new PropertyValueFactory<>("checkIn"));


        teacherTableView.getColumns().addAll(teacherFirstName, teacherLastName, employeeID, teachercheckIn, teachercheckOut, killTeacher);

        teacherFirstName.setCellFactory(TextFieldTableCell.forTableColumn());
        teacherLastName.setCellFactory(TextFieldTableCell.forTableColumn());
        employeeID.setCellFactory(TextFieldTableCell.forTableColumn());


        teacherTableView.setEditable(true);

        teacherTab.setContent(teacherTableView);


        Button addKidButton = new Button("Add kid");
        addKidButton.setOnAction(e -> AddKid.display(kidses));
        addKidTab.setContent(addKidButton);

        Button addTeacherButton = new Button("Add teacher");
        addTeacherButton.setOnAction(e -> AddTeacher.display(teachers));
        addTeacherTab.setContent(addTeacherButton);


        StackPane pane = new StackPane();
        pane.getChildren().add(tabs);
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Persons");
        primaryStage.setWidth(800);
        primaryStage.setHeight(400);
        primaryStage.show();
    }

}
