package InterfacesAndAbstraction.MilitaryElite;

import java.util.Collection;

public interface Engineer extends SpecialisedSoldier {
    public void addRepair(Repair repair);
    public Collection<Repair> getRepairs();
}
