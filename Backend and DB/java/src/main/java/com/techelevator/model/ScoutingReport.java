package com.techelevator.model;

public class ScoutingReport {
    private long scoutReportID;
    private long userID;
    private String reportDate;       // this can change if I want to do localTimeDate stuff, right now ppl can enter months and day ranges and it be fine
    private String reportLocation;
    private String reportTime;
    private String weather;
    private String scoutDescription;

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

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
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
