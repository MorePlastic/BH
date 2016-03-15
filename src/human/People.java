package human;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class People {
    private String firstName, lastName, id;
    private CheckBox checkIn, checkOut;
    private Button kill;

    public People(String firstName, String lastName, String id, boolean checkIn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.checkIn = new CheckBox();
        this.checkIn.setSelected(checkIn);
        this.checkOut = new CheckBox();
        this.checkOut.setSelected(!checkIn);
        this.kill = new Button("Remove");
    }

    protected People() {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CheckBox getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(CheckBox checkIn) {
        this.checkIn = checkIn;
    }

    public CheckBox getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(CheckBox checkOut) {
        this.checkOut = checkOut;
    }

    public Button getKill() {
        return kill;
    }

    public void setKill(Button kill) {
        this.kill = kill;
    }
}
