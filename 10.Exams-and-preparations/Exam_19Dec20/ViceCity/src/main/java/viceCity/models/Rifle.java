package viceCity.models;

public class Rifle extends BaseGun {
    public Rifle(String name) {
        super(name, 50, 500);
    }

    @Override
    public int fire() {
        int bulletsShot = 5;
        if (super.canFire()) {
            super.setCurrentBullets(super.getCurrentBullets() - bulletsShot);
            return bulletsShot;
        }
        return 0;
    }
}
