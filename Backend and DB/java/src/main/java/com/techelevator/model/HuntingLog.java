package com.techelevator.model;

public class HuntingLog {
    private long huntLogId;
    private long userId;
    private String logDate;      // this can change if I want to do localTimeDate stuff, right now ppl can enter months and day ranges and it be fine
    private String logLocation;
    private String logDescription;
    private String imageURL;
    private String weather;
    private String huntingType;
    private String huntingTrip;

    public long getHuntLogId() {
        return huntLogId;
    }

    public void setHuntLogId(long huntLogId) {
        this.huntLogId = huntLogId;
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

    public String getHuntingType() {
        return huntingType;
    }

    public void setHuntingType(String huntingType) {
        this.huntingType = huntingType;
    }

    public String getHuntingTrip() {
        return huntingTrip;
    }

    public void setHuntingTrip(String huntingTrip) {
        this.huntingTrip = huntingTrip;
    }

    @Override
    public String toString() {
        return "HuntingLog{" +
                "huntLogId=" + huntLogId +
                ", userId=" + userId +
                ", logDate='" + logDate + '\'' +
                ", logLocation='" + logLocation + '\'' +
                ", logDescription='" + logDescription + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", weather='" + weather + '\'' +
                ", huntingType='" + huntingType + '\'' +
                ", huntingTrip='" + huntingTrip + '\'' +
                '}';
    }
}
