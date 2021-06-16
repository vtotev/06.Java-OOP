package Encapsulation.FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().isEmpty() || name.equals(null)) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(String player) {
        if (!players.removeIf(o -> o.getName().equals(player))) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", player, name));
        }
    }

    public int getRating() {
        if (players.isEmpty()) {
            return 0;
        }
        double result = 0.0;
        for (Player pl : players) {
            result += pl.overallSkillLevel();
        }
        return (int) Math.round(result / players.size());
    }
}