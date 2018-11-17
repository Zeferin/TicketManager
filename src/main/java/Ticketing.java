import java.util.List;

public interface Ticketing extends LoginCapable {
    public Ticket create();
    public boolean assignTo(Ticket t, String username);
    public boolean statusUpdate(Ticket t);
    public List<Ticket> getAllAssignedToUsername(String username);
    public List<Ticket> getAllCreatedByUsername(String username);
}
