package com.techelevator.model;

public class FishingLog {
    private long fishLogId;
    private long userId;
    private String logDate;     // this can change if I want to do localTimeDate stuff, right now ppl can enter months and day ranges and it be fine
    private String logLocation;
    private String logDescription;
    private String imageURL;
    private String bait;
    private String weather;
    private String FishingTrip;

    public long getFishLogId() {
        return fishLogId;
    }

    public void setFishLogId(long fishLogId) {
        this.fishLogId = fishLogId;
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

    public String getBait() {
        return bait;
    }

    public void setBait(String bait) {
        this.bait = bait;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getFishingTrip() {
        return FishingTrip;
    }

    public void setFishingTrip(String fishingTrip) {
        FishingTrip = fishingTrip;
    }

    @Override
    public String toString() {
        return "FishingLog{" +
                "fishLogId=" + fishLogId +
                ", userId=" + userId +
                ", logDate='" + logDate + '\'' +
                ", logLocation='" + logLocation + '\'' +
                ", logDescription='" + logDescription + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", bait='" + bait + '\'' +
                ", weather='" + weather + '\'' +
                ", FishingTrip='" + FishingTrip + '\'' +
                '}';
    }
}
