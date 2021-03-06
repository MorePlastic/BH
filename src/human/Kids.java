package human;

import gui.ICEForm;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import java.util.ArrayList;

public class Kids extends People {

    private ArrayList<ICE> contacts;
    private String notes;
    private Button button = new Button("ICE");
    private boolean isIll;
    private CheckBox illBox = new CheckBox();


    public Kids(String firstName, String lastName, String id) {
        super(firstName, lastName, id, false);
        this.notes = "";
        this.contacts = new ArrayList<>();
        this.isIll = false;
        this.button.setOnAction(e -> ICEForm.displayICEs(this));
    }

    public Kids(String firstName, String lastName, String id, boolean checkIn) {
        super(firstName, lastName, id, checkIn);
        this.notes = "";
        this.contacts = new ArrayList<>();
        this.isIll = false;
        this.button.setOnAction(e -> ICEForm.displayICEs(this));
    }

    public Kids(String firstName, String lastName, String id, boolean checkIn, String notes) {
        super(firstName, lastName, id, checkIn);
        this.contacts = new ArrayList<>();
        this.notes = notes;
        this.isIll = false;
        this.button.setOnAction(e -> ICEForm.displayICEs(this));
    }

    public Kids(String firstName, String lastName, String id, boolean checkIn, ArrayList<ICE> contacts) {
        super(firstName, lastName, id, checkIn);
        this.contacts = contacts;
        this.notes = "";
        this.isIll = false;
        this.button.setOnAction(e -> ICEForm.displayICEs(this));
    }

    public Kids(String firstName, String lastName, String id, boolean checkIn, ArrayList<ICE> contacts, String notes) {
        super(firstName, lastName, id, checkIn);
        this.contacts = contacts;
        this.notes = notes;
        this.isIll = false;
        this.button.setOnAction(e -> ICEForm.displayICEs(this));
    }

    public void addContacts(ICE... contacts) {
        for (ICE contact : contacts) {
            this.contacts.add(contact);
        }
    }

    public void addContact(ICE contact) {
        this.contacts.add(contact);
    }

    public void addContact(ArrayList<ICE> contacts) {
        this.contacts.addAll(contacts);
    }

    public void removeContact(ICE contact) {
        this.contacts.remove(contact);
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public ArrayList<ICE> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<ICE> contacts) {
        this.contacts = contacts;
    }

    public boolean isIll() {
        return isIll;
    }

    public void setIll(boolean ill) {
        isIll = ill;
    }

    public CheckBox getIllBox() {
        return illBox;
    }

    public void setIllBox(CheckBox illBox) {
        this.illBox = illBox;
    }
}