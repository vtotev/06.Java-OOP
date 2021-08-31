package viceCity.models;

import viceCity.models.guns.Gun;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.Player;

import java.util.Collection;

public class GangNeighbourhood implements Neighbourhood {
    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        for (Gun gun : mainPlayer.getGunRepository().getModels()) {
            for (Player player : civilPlayers) {
                if (!gun.canFire()) {
                    break;
                }
                while (player.isAlive() && gun.canFire()) {
                    player.takeLifePoints(gun.fire());
                }
            }
        }

        for (Player player : civilPlayers) {
            if (!mainPlayer.isAlive()) {
                break;
            }
            if (!player.isAlive()) {
                continue;
            }
            for (Gun gun : player.getGunRepository().getModels()) {
                if (!gun.canFire()) {
                    break;
                }
                while (mainPlayer.isAlive() && gun.canFire()) {
                    mainPlayer.takeLifePoints(gun.fire());
                }
            }
        }
    }
}
