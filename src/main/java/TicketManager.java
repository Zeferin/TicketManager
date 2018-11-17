import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class TicketManager implements Ticketing {

    private MySqlHandler sqlHandler;

    public TicketManager() throws SQLException {
        sqlHandler = new MySqlHandler();
    }

    public boolean register() {
        String username;
        String password;
        String email;
        Scanner in = new Scanner(System.in);
        System.out.println("Username:");
        username = in.next();
        while (true) {
            System.out.println("Password:");
            password = in.next();
            System.out.println("Re-type password:");
            if (password.equals(in.next())) {
                break;
            } else {
                System.out.println("Passwords did not match!");
            }

        }
        System.out.println("Email address:");
        email = in.next();
        User x = new User(username, password, email);
        return sqlHandler.addUser(x);
    }

    public String login() {
        String username;
        String password;
        Scanner in = new Scanner(System.in);
        System.out.println("Username:");
        username = in.nextLine();
        System.out.println("Password:");
        password = in.nextLine();
        if (sqlHandler.loginUser(username, password)) {
            return username;
        } else {
            return null;
        }
    }

    public boolean logout() {
        System.out.println("You have logged out!");
        return true;
    }

    public void changePassword(String username) {
        String password;
        System.out.print(username + ">" );
        Scanner in = new Scanner(System.in);

        System.out.println("Type new password:");
        System.out.print(username + ">" );
        password = in.next();
        System.out.println("Re-type new password:");
        if (password.equals(in.next())) {
            sqlHandler.updatePassword(username, password);
            System.out.println("Password changed successfully!");
        } else {
            System.out.println("Passwords did not match.");
        }
    }

    public void changeEmail(String x) {

    }

    public Ticket create() {
        return null;
    }

    public boolean assignTo(Ticket t, String username) {
        return false;
    }

    public boolean statusUpdate(Ticket t) {
        return false;
    }

    public List<Ticket> getAllAssignedToUsername(String username) {
        return null;
    }

    public List<Ticket> getAllCreatedByUsername(String username) {
        return null;
    }
}
