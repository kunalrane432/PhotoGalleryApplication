package com.humber.photogalleryapplication.response;

public class Photo {
    private String id;
    private String owner;

    private String secret;

    private String server;

    private int farm;

    private String titled;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getFarm() {
        return farm;
    }

    public void setFarm(int farm) {
        this.farm = farm;
    }

    public String getTitled() {
        return titled;
    }

    public void setTitled(String titled) {
        this.titled = titled;
    }
}
