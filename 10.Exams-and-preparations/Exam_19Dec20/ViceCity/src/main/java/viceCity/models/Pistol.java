package viceCity.models;

public class Pistol extends BaseGun {
    public Pistol(String name) {
        super(name, 10, 100);
    }

    @Override
    public int fire() {
        if (canFire()) {
            super.setCurrentBullets(super.getCurrentBullets() - 1);
            return 1;
        }
        return 0;
    }
}
