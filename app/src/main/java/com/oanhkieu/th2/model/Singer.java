package com.oanhkieu.th2.model;

public class Singer {
    private int singerId;
    private String singerName;
    private int image;
    private  String songInfo;

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getSongInfo() {
        return songInfo;
    }

    public void setSongInfo(String songInfo) {
        this.songInfo = songInfo;
    }

    public Singer() {
    }

    public Singer(String singerName, int image, String songInfo) {
        this.singerName = singerName;
        this.image = image;
        this.songInfo = songInfo;
    }

    public Singer(int singerId, String singerName, int image, String songInfo) {
        this.singerId = singerId;
        this.singerName = singerName;
        this.image = image;
        this.songInfo = songInfo;
    }
}
