public class User {
    private String username;
    private String password;
    private String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getInsertStmt()
    {
        return "INSERT INTO user(username, password, email)" +
                "VALUES (\'" + username + "\', \'" + password + "\', \'" + email+ "\')";
    }
}
