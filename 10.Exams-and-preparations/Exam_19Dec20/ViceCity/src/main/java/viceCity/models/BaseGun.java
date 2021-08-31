package viceCity.models;

import viceCity.models.guns.Gun;

import static viceCity.common.ExceptionMessages.*;

public abstract class BaseGun implements Gun {
    private String name;
    private int currentBullets = 0;
    private int bulletsPerBarrel;
    private int totalBullets;
    private boolean canFire;

    protected BaseGun(String name, int bulletsPerBarrel, int totalBullets) {
        setName(name);
        setBulletsPerBarrel(bulletsPerBarrel);
        setCurrentBullets(bulletsPerBarrel);
        setTotalBullets(totalBullets);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(NAME_NULL);
        }
        this.name = name;
    }

    private void setBulletsPerBarrel(int bulletsPerBarrel) {
        if (bulletsPerBarrel < 0) {
            throw new IllegalArgumentException(BULLETS_LESS_THAN_ZERO);
        }
        this.bulletsPerBarrel = bulletsPerBarrel;
    }

    private void setTotalBullets(int totalBullets) {
        if (totalBullets < 0) {
            throw new IllegalArgumentException(TOTAL_BULLETS_LESS_THAN_ZERO);
        }
        this.totalBullets = totalBullets;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBulletsPerBarrel() {
        return this.bulletsPerBarrel;
    }

    @Override
    public boolean canFire() {
        if (getCurrentBullets() <= 0) {
            reload();
        }
        return getTotalBullets() > 0 || getCurrentBullets() > 0;
    }

    @Override
    public int getTotalBullets() {
        return this.totalBullets;
    }

    @Override
    public int fire() {
        return 0;
    }

    public int getCurrentBullets() {
        return currentBullets;
    }

    protected void setCurrentBullets(int currentBullets) {
        this.currentBullets = currentBullets;
    }

    public void reload() {
        if (getTotalBullets() <= 0) {
            return;
        }
        setCurrentBullets(getBulletsPerBarrel());
        totalBullets -= getBulletsPerBarrel();
    }
}
