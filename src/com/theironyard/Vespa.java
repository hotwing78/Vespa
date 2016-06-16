package com.theironyard;

/**
 * Created by zach on 6/16/16.
 */
public class Vespa {
    int id;
    int time;
    String description;
    String image;
    double lat;
    double lon;
    boolean hasSidecar;

    public Vespa(int id, int time, String description, String image, double lat, double lon, boolean hasSidecar) {
        this.id = id;
        this.time = time;
        this.description = description;
        this.image = image;
        this.lat = lat;
        this.lon = lon;
        this.hasSidecar = hasSidecar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public boolean isHasSidecar() {
        return hasSidecar;
    }

    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }
}
