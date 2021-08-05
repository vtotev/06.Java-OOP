package InterfacesAndAbstraction.MilitaryElite;

import java.util.Collection;

public interface Commando extends SpecialisedSoldier {
    String getCodeName();
    STATE getState();
    void addMission(Mission mission);
     Collection<Mission> getMissions();
}
