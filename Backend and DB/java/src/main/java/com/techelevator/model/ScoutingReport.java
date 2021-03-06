package com.techelevator.model;

import java.util.Date;

public class ScoutingReport {
    private long scoutReportID;
    private long userID;
    private Date reportDate;       // this can change if I want to do localTimeDate stuff, right now ppl can enter months and day ranges and it be fine
    private String reportLocation;
    private String reportTime;
    private String weather;
    private String scoutDescription;
    private String imageURL;

    public long getScoutReportID() {
        return scoutReportID;
    }

    public void setScoutReportID(long scoutReportID) {
        this.scoutReportID = scoutReportID;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getReportLocation() {
        return reportLocation;
    }

    public void setReportLocation(String reportLocation) {
        this.reportLocation = reportLocation;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getScoutDescription() {
        return scoutDescription;
    }

    public void setScoutDescription(String scoutDescription) {
        this.scoutDescription = scoutDescription;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "ScoutingReport{" +
                "scoutReportID=" + scoutReportID +
                ", userID=" + userID +
                ", reportDate='" + reportDate + '\'' +
                ", reportLocation='" + reportLocation + '\'' +
                ", reportTime='" + reportTime + '\'' +
                ", weather='" + weather + '\'' +
                ", scoutDescription='" + scoutDescription + '\'' +
                '}';
    }
}
