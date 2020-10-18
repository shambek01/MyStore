package Classes;

public class Stats {
    public int visits;
    public int sessions;

    public Stats(int visits, int sessions, String last_visit) {
        this.visits = visits;
        this.sessions = sessions;
        this.last_visit = last_visit;
    }

    public String last_visit;

}
