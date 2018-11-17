import java.sql.SQLException;

public class Main {

    public static void main(String args[])
    {
        ConsoleBasedUI obj = null;
        try {
            obj = new ConsoleBasedUI();
            obj.start();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
