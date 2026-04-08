import java.util.ArrayList;
import java.util.List;
class Player {

    private int id;
    private String team;
    private String name;

    public Player(int id, String team, String name) {
        this.id = id;
        this.team = team;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getTeam() {
        return team;
    }

    public String getName() {
        return name;
    }

    public void setId(int nId) {
        this.id = nId;
    }

    public void setTeam(String nTeam) {
        this.team = nTeam;
    }

    public void setName(String nName) {
        this.name = nName;
    }

    @Override
    public String toString() {
        return "Player ID: " + getId() + " | Player name: " + getName();
    }

}

class Team {

    private final List<Player> players;
    private final String name;

    public Team(List<Player> players, String name) {
        this.players = new ArrayList<>(players);
        this.name = name;
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(players);
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player_new) {
        players.add(player_new);
    }

    public void removePlayer(Player p) {
        players.remove(p);
    }

    public int teamCount() {
        return players.size();
    }

    @Override
    public String toString() {
        String result = "Team name: " + name + "\n";
        result += "Players:\n";

        for (Player player : players) {
            result += " " + player + "\n";
        }
        return result;
    }

}

class School {

    private final List<Team> teams;
    private final String schoolName;

    public School(List<Team> teams, String schoolName) {
        this.teams = new ArrayList<>(teams);
        this.schoolName = schoolName;
    }

    public List<Team> getTeams() {
        return new ArrayList<>(teams);
    }

    public String getSchoolName() {
        return schoolName;
    }

    public int getTotalPlayersInSchool() {
        int count = 0;
        for (int i = 0; i < teams.size(); i++) {
            count += teams.get(i).teamCount();
        }
        return count;
    }

    @Override
    public String toString() {
        String result = "School name: " + schoolName + "\n";
        result += "Total players in school: " + getTotalPlayersInSchool() + "\n";
        result += "Teams:\n";

        for (Team team : teams) {
            result += team + "\n";
        }
        return result;
    }

}

class Main {

    public static void main (String[] args) {
        // creating the player objects
        Player Harris = new Player(99, "Red", "Harris");
        Player Carol = new Player(7, "Red", "Carol");
        Player Johnny = new Player(3, "Blue", "Johnny");
        Player Sarah = new Player(54, "Blue", "Sarah");

        // creating list's to create Team objects
        List<Player> Red_Players = new ArrayList<>();
        Red_Players.add(Harris);
        Red_Players.add(Carol);

        List<Player> Blue_Players = new ArrayList<>();
        Blue_Players.add(Johnny);
        Blue_Players.add(Sarah);

        // Creating the team objects
        Team Red = new Team(Red_Players, "Red");
        Team Blue = new Team(Blue_Players, "Blue");

        // creating a list to create a school object
        List<Team> teams = new ArrayList<>();
        teams.add(Red);
        teams.add(Blue);

        // creating a school object with respective team lists
        School uofa = new School(teams, "University of Arizona");
        System.out.println("\n"+uofa);

    } // end of main
}
