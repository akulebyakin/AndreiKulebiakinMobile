package entities;

public class User {

    public static User DEFAULT_USER = new User("test@test.test",
            "Test",
            "12345678");

    private String email;

    private String username;

    private String password;

    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
