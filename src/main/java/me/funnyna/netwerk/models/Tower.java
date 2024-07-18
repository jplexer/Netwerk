package me.funnyna.netwerk.models;

import org.bukkit.Location;

public class Tower {
    private Location towerLocation;

    private int carrierId;

    public Tower (Location pTowerLocation, int pCarrierID) {
        towerLocation = pTowerLocation;
        carrierId = pCarrierID;
    }

}
