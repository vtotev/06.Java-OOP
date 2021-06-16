package Encapsulation.FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Team> teams = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] data = input.split(";");
            if (data.length < 2) {
                input = scanner.nextLine();
                continue;
            }
            try {
                Team foundTeam = getTeam(teams, data[1]);
                switch (data[0]) {
                    case "Team":
                        if (foundTeam == null) {
                            teams.add(new Team(data[1]));
                        }
                        break;
                    case "Add":
                        if (foundTeam != null) {
                            foundTeam.addPlayer(new Player(data[2], Integer.parseInt(data[3]),
                                    Integer.parseInt(data[4]),
                                    Integer.parseInt(data[5]),
                                    Integer.parseInt(data[6]),
                                    Integer.parseInt(data[7])));
                        } else {
                            throw new IllegalArgumentException(String.format("Team %s does not exist.", data[1]));
                        }
                        break;
                    case "Remove":
                        if (foundTeam != null) {
                            foundTeam.removePlayer(data[2]);
                        } else {
                            throw new IllegalArgumentException(String.format("Team %s does not exist.", data[1]));
                        }
                        break;
                    case "Rating":
                        if (foundTeam != null) {
                            System.out.printf("%s - %d%n", foundTeam.getName(), foundTeam.getRating());
                        } else {
                            throw new IllegalArgumentException(String.format("Team %s does not exist.", data[1]));
                        }
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                input = scanner.nextLine();
                continue;
            }
            input = scanner.nextLine();
        }
    }

    public static Team getTeam(List<Team> teamList, String teamName) {
        for (int i = 0; i < teamList.size(); i++) {
            if (teamList.get(i).getName().equals(teamName)) {
                return teamList.get(i);
            }
        }
        return null;
    }
}
