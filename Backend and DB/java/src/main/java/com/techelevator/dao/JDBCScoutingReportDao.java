package com.techelevator.dao;

import com.techelevator.model.ScoutingReport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JDBCScoutingReportDao implements ScoutingReportDao{

    private JdbcTemplate jdbcTemplate;

    public JDBCScoutingReportDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public ScoutingReport createScoutingReport(ScoutingReport scoutingReport) {
        String sql = "INSERT INTO scouting_report (user_id, report_date, report_location, report_time, weather, scout_description) " +
                " VALUES (?,?,?,?,?,?)";
        jdbcTemplate.update(sql, scoutingReport.getUserID(), scoutingReport.getReportDate(), scoutingReport.getReportLocation(),
                scoutingReport.getReportTime(), scoutingReport.getWeather(), scoutingReport.getScoutDescription());
        return scoutingReport;
    }   //1S this method creates a new Scout Report

    @Override
    public List<Long> getScoutReportIds(long userId) {
        List<Long> scoutReportIds = new ArrayList<>();
        String sql = "SELECT scout_report_id FROM scouting_report WHERE user_id = ? ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()){
            scoutReportIds.add(results.getLong("scout_report_id"));
        }
        return scoutReportIds;
    }   //2S. this method will bring a list of your scout report IDs for you to choose from

    @Override
    public ScoutingReport getScoutingReportById(long reportId) {
        ScoutingReport scoutingReport = new ScoutingReport();
        String sql = "SELECT * FROM scouting_report WHERE scout_report_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, reportId);
        while (results.next()){
            scoutingReport = mapResultsToScoutReport(results);
        }
        return scoutingReport;
    }   //3S. this method will bring up your report after you choose ID to view

    @Override
    public void deleteScoutReport(long logId) {
        String sql = "DELETE FROM scouting_report WHERE scout_report_id = ?";
        jdbcTemplate.update(sql, logId);
    }   //4S. this method will delete a scout report if you choose by report ID


    @Override
    public List<ScoutingReport> getScoutingReportByUser(long userId) {
        List<ScoutingReport> scoutingReports = new ArrayList<>();
        String sql = "SELECT * FROM scouting_report WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()){
            scoutingReports.add(mapResultsToScoutReport(results));
        }
        return scoutingReports;
    }   //5S. this method lets you view all reports if you want by gathering all by userId

    private ScoutingReport mapResultsToScoutReport(SqlRowSet results){
        ScoutingReport scoutingReport = new ScoutingReport();
        scoutingReport.setScoutReportID(results.getLong("scout_report_id"));
        scoutingReport.setUserID(results.getLong("user_id"));
        scoutingReport.setReportDate(results.getString("report_date"));
        scoutingReport.setReportLocation(results.getString("report_location"));
        scoutingReport.setReportTime(results.getString("report_time"));
        scoutingReport.setWeather(results.getString("weather"));
        scoutingReport.setScoutDescription(results.getString("scout_description"));
        return scoutingReport;
    }     // this is just a helper method  **********
}
