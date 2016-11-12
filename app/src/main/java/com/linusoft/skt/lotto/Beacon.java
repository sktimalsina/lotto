package com.linusoft.skt.lotto;

/**
 * Created by sunil on 2016-10-01.
 */
public class Beacon {
    private String beaconName;
    private String beaconId;

    public Beacon(String beaconName) {
        this.beaconName = beaconName;
        beaconId = String.valueOf(beaconName.hashCode());
    }

    public void setBeaconName(String beaconName) {
        this.beaconName = beaconName;
    }

    public String getBeaconName() {
        return beaconName;
    }

    public String getBeaconId() {
        return beaconId;
    }
}
