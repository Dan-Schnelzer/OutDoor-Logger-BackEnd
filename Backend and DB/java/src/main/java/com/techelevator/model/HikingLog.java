package com.techelevator.model;

public class HikingLog {
    private long hikingLogId;
    private long userId;
    private String logDate;
    private String logLocation;
    private String logDescription;
    private String imageURL;
    private String weather;
    private String logState;


    public long getHikingLogId() {
        return hikingLogId;
    }

    public void setHikingLogId(long hikingLogId) {
        this.hikingLogId = hikingLogId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getLogDate() {
        return logDate;
    }

    public void setLogDate(String logDate) {
        this.logDate = logDate;
    }

    public String getLogLocation() {
        return logLocation;
    }

    public void setLogLocation(String logLocation) {
        this.logLocation = logLocation;
    }

    public String getLogDescription() {
        return logDescription;
    }

    public void setLogDescription(String logDescription) {
        this.logDescription = logDescription;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getLogState() {
        return logState;
    }

    public void setLogState(String logState) {
        this.logState = logState;
    }
}
