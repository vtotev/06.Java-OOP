package Encapsulation.FootballTeamGenerator;

public class Player {
    private String name;
    private Integer endurance;
    private Integer sprint;
    private Integer dribble;
    private Integer passing;
    private Integer shooting;

    public Player(String name, Integer endurance, Integer sprint, Integer dribble, Integer passing, Integer shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.trim().isEmpty() || name.equals(null)) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(Integer endurance) {
        checkData(endurance, "Endurance");
        this.endurance = endurance;
    }

    private void setSprint(Integer sprint) {
        checkData(sprint, "Sprint");
        this.sprint = sprint;
    }

    private void setDribble(Integer dribble) {
        checkData(dribble, "Dribble");
        this.dribble = dribble;
    }

    private void setPassing(Integer passing) {
        checkData(passing, "Passing");
        this.passing = passing;
    }

    private void setShooting(Integer shooting) {
        checkData(shooting, "Shooting");
        this.shooting = shooting;
    }


    private void checkData (Integer number, String valueName) {
        if (number < 0 || number > 100 || number == null) {
            throw new IllegalArgumentException(String.format("%s should be between 0 and 100.", valueName));
        }
    }

    public int overallSkillLevel() {
        return (int) Math.round((endurance + sprint + dribble + passing + shooting) / 5.0);
    }
}
