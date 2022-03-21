package com.techelevator.dao;

import com.techelevator.model.FishingLog;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JDBCFishingLogDao implements FishingLogDao {

    private JdbcTemplate jdbcTemplate;

    public JDBCFishingLogDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public FishingLog createFishingLog(FishingLog fishingLog) {
        String sql = "INSERT INTO fishing_log (user_id, log_date, log_location, log_description, images, bait, weahter,fishing_trip) " +
                " VALUES (?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, fishingLog.getUserId(), fishingLog.getLogDate(), fishingLog.getLogLocation(), fishingLog.getLogDescription(),
                fishingLog.getImageURL(), fishingLog.getBait(), fishingLog.getWeather(), fishingLog.getFishingTrip());
        return fishingLog;
    }      // 1F.create a new fishing log

    @Override
    public List<Long> getLogIds(long userId) {
        List<Long> fishLogIds = new ArrayList<>();
        String sql = "SELECT fish_log_id FROM fishing_log WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()){
            fishLogIds.add(results.getLong("fish_log_id"));
        }
        return fishLogIds;
    }      // 2F.this method will bring a list of your fishing log IDs for you to choose from

    @Override
    public FishingLog getFishingLogById(long logId) {
        FishingLog fishingLog = new FishingLog();
        String sql = "SELECT * FROM fishing_log WHERE fish_log_id = ? ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, logId);
        while (results.next()){
            fishingLog = mapResultsToFishingLog(results);
        }
        return fishingLog;
    }   // 3F.this method will bring up your log after you choose log ID to view

    @Override
    public void deleteFishingLog(long logId) {
     String sql =" DELETE FROM fishing_log WHERE fish_log_id = ?";
     jdbcTemplate.update(sql, logId);
    }   //4F. this method will delete a fishing log if you choose to by log ID

    @Override
    public List<FishingLog> getFishingLogsByUser(long userId) {
        List<FishingLog> fishingLogList = new ArrayList<>();
        String sql = "Select * from fishing_log WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId );
        while (results.next()){
            fishingLogList.add(mapResultsToFishingLog(results));
        }
        return fishingLogList;
    }     // 5F.this method lets you view all logs if you want by gathering all by userId



    private FishingLog mapResultsToFishingLog(SqlRowSet results){
        FishingLog fishingLog = new FishingLog();
        fishingLog.setFishLogId(results.getLong("fish_log_id"));
        fishingLog.setUserId(results.getLong("user_id"));
        fishingLog.setLogDate(results.getString("log_date"));
        fishingLog.setLogLocation(results.getString("log_location"));
        fishingLog.setLogDescription(results.getString("log_description"));
        fishingLog.setImageURL(results.getString("images"));
        fishingLog.setBait(results.getString("bait"));
        fishingLog.setWeather(results.getString("weather"));
        fishingLog.setFishingTrip(results.getString("fishing_trip"));
        return fishingLog;
    }     // this is just a helper method  **********
}
