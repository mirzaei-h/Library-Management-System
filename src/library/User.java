package library;

public class User {

    private long idUser;
    private String firstname;
    private String lastname;

    public User(long idUser, String firstname, String lastname) {
        this.idUser = idUser;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public static void adduser() {
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
