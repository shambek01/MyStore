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

    public int getVisits() {
        return visits;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }

    public int getSessions() {
        return sessions;
    }

    public void setSessions(int sessions) {
        this.sessions = sessions;
    }

    public String getLast_visit() {
        return last_visit;
    }

    public void setLast_visit(String last_visit) {
        this.last_visit = last_visit;
    }
}
