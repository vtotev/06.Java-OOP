package viceCity.core;

import viceCity.core.interfaces.Controller;
import viceCity.models.*;
import viceCity.models.guns.Gun;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.Player;
import viceCity.repositories.GunRepository;

import java.util.*;
import java.util.stream.Collectors;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private MainPlayer mainPlayer;
    private Collection<Player> civilPlayers;
    private GunRepository gunRepository;
    private Neighbourhood neighbourhood;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.civilPlayers = new ArrayList<>();
        this.gunRepository = new GunRepository();
        this.neighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        this.civilPlayers.add(new CivilPlayer(name));
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        BaseGun gun;
        switch (type) {
            case "Pistol":
                gun = new Pistol(name);
                break;
            case "Rifle":
                gun = new Rifle(name);
                break;
            default:
                return GUN_TYPE_INVALID;
        }
        gunRepository.add(gun);
        return String.format(GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        if (gunRepository.getModels().size() == 0) {
            return String.format(GUN_QUEUE_IS_EMPTY);
        }
        List<Gun> collect = new ArrayList<>(gunRepository.getModels());
        Gun gun = collect.get(0);
        if (name.equals("Vercetti")) {
            mainPlayer.getGunRepository().add(gun);
            gunRepository.remove(gun);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), "Tommy Vercetti");
        } else {
            Player civil = civilPlayers.stream().filter(c -> c.getName().equals(name)).findFirst().orElse(null);
            if (civil == null) {
                return String.format(CIVIL_PLAYER_DOES_NOT_EXIST);
            }
            civil.getGunRepository().add(gun);
            gunRepository.remove(gun);
            return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), civil.getName());
        }
    }

    @Override
    public String fight() {
        neighbourhood.action(mainPlayer, civilPlayers);
        boolean fightNotHappened = mainPlayer.getLifePoints() == 100 && (civilPlayers.stream().mapToInt(p -> p.getLifePoints()).average().orElse(0) == 50);
        if (fightNotHappened) {
            return FIGHT_HOT_HAPPENED;
        }
        return getShootoutResults();
    }

    public String getShootoutResults() {
        StringBuilder sb = new StringBuilder(FIGHT_HAPPENED + System.lineSeparator());
        sb.append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints())).append(System.lineSeparator());
        long killed = civilPlayers.stream().filter(p -> !p.isAlive()).count();
        sb.append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, killed)).append(System.lineSeparator());
        long alive = civilPlayers.size() - killed;
        sb.append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE, alive));
        civilPlayers = civilPlayers.stream().filter(p -> p.isAlive()).collect(Collectors.toCollection(ArrayList::new));
        return sb.toString();
    }
}
