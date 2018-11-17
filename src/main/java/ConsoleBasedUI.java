import java.sql.SQLException;
import java.util.Scanner;

public class ConsoleBasedUI {
    private Ticketing app;
    private String prompt;
    private Scanner in;

    public ConsoleBasedUI() throws SQLException {
        app = new TicketManager();
        in = new Scanner(System.in);
        prompt = ">";
    }

    public void start() {

        boolean quit = false;

        while (!quit) {
            mainMenu();
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Register menu");
                    app.register();
                    break;
                case 2:
                    boolean terminat = false;

                    System.out.println("Login menu");
                    while (true) {
                        prompt = app.login();
                        if (prompt != null) {
                            prompt += ">";
                            break;
                        } else {
                            System.out.println("Re-type your data:");
                        }
                    }
                    while (!terminat) {
                        loggedInMenu();
                        choice = in.nextInt();
                        switch (choice) {
                            case 1:
                                app.changePassword("");
                                break;
                            case 2:
                                app.changeEmail("");
                                break;
                            case 3:
                                terminat = app.logout();
                                prompt = ">";
                                break;
                            default:
                                System.out.println("Option unavailable");
                                break;
                        }
                    }
                    break;
                case 3:
                    quit = true;
                    break;
                default:
                    System.out.println("Option unavailable");
                    mainMenu();
                    break;
            }

        }
    }

    private void mainMenu() {
        System.out.println("1.Register");
        System.out.println("2.Login");
        System.out.println("3.Exit");
        System.out.print(prompt);
    }

    private void loggedInMenu() {
        System.out.println("1.Change password");
        System.out.println("2.Change email");
        System.out.println("3.Logout");
        System.out.print(prompt);
    }
}
