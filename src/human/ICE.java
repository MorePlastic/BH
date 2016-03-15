package human;

public class ICE extends People {
    private String phoneNumber;
    public ICE(String firstName, String lastName, String id, String phoneNumber) {
        super(firstName, lastName, id, false);
        this.phoneNumber = phoneNumber;
    }
}
