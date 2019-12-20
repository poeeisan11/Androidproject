package com.pet.myapp;

public class SerieModel {
    String serieName;
    String serieImagelink;
    String serieVideollink;
    String serieCategory;

    public SerieModel(String serieName, String serieImagelink, String serieVideollink, String serieCategory) {
        this.serieName = serieName;
        this.serieImagelink = serieImagelink;
        this.serieVideollink = serieVideollink;
        this.serieCategory = serieCategory;
    }

    public SerieModel() {
    }

    public String getSerieName() {
        return serieName;
    }

    public String getSerieImagelink() {
        return serieImagelink;
    }

    public String getSerieVideollink() {
        return serieVideollink;
    }

    public String getSerieCategory() {
        return serieCategory;
    }

    public void setSerieName(String serieName) {
        this.serieName = serieName;
    }

    public void setSerieImagelink(String serieImagelink) {
        this.serieImagelink = serieImagelink;
    }

    public void setSerieVideollink(String serieVideollink) {
        this.serieVideollink = serieVideollink;
    }

    public void setSerieCategory(String serieCategory) {
        this.serieCategory = serieCategory;
    }

}
