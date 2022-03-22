package com.techelevator.dao;

import com.techelevator.model.HuntingLog;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JDBCHuntingLogDao implements HuntingLogDao{

    private JdbcTemplate jdbcTemplate;

    public JDBCHuntingLogDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public HuntingLog createHuntingLog(HuntingLog huntingLog) {
        String sql = "INSERT INTO hunting_log (user_id, log_date, log_location, log_description, images, weather, hunting_type, hunting_trip) " +
                " VALUES (?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, huntingLog.getUserId(), huntingLog.getLogDate(), huntingLog.getLogLocation(), huntingLog.getLogDescription(),
                huntingLog.getImageURL(), huntingLog.getWeather(), huntingLog.getHuntingType(), huntingLog.getHuntingTrip());
        return huntingLog;
    }    //1H. this method creates a new hunting log

    @Override
    public List<Long> getLogIds(long userId) {
        List<Long> huntlogIds = new ArrayList<>();
        String sql = "SELECT hunt_log_id FROM hunting_log WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()){
            huntlogIds.add(results.getLong("hunt_log_id"));
        }
        return huntlogIds;
    }     //2H. this method will bring a list of your hunting log IDs for you to choose from

    @Override
    public HuntingLog getHuntingLogById(long logId) {
        HuntingLog huntingLog = new HuntingLog();
        String sql = "SELECT * FROM hunting_log WHERE hunt_log_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, logId);
        while (results.next()){
            huntingLog = mapResultsToHutingLog(results);
        }
        return huntingLog;
    }     //3H. this method will bring up your log after you choose ID to view

    @Override
    public void deleteHuntingLog(long logId) {
        String sql = "DELETE FROM hunting_log WHERE hunt_log_id = ?";
        jdbcTemplate.update(sql, logId);
    }      //4H. this method will delete a hunting log if you choose by log ID

    @Override
    public List<HuntingLog> getHuntingLogsByUser(long userId) {
        List<HuntingLog> huntingLogList = new ArrayList<>();
        String sql = "SELECT * FROM hunting_log WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()){
            huntingLogList.add(mapResultsToHutingLog(results));
        }
        return huntingLogList;
    }   //5H. this method lets you view all logs if you want by gathering all by userId

    @Override
    public HuntingLog updateHuntingLog(HuntingLog huntingLog) {
        String sql = " UPDATE hunting_log SET user_id = ?, log_date = ?, log_location = ?, log_description = ?, images = ?, weather = ?, hunting_type = ?, hunting_trip = ?, WHERE hunt_log_id = ? " ;
        jdbcTemplate.update(sql, huntingLog.getUserId(), huntingLog.getLogDate(), huntingLog.getLogLocation(), huntingLog.getLogDescription(),
                huntingLog.getImageURL(), huntingLog.getWeather(), huntingLog.getHuntingType(), huntingLog.getHuntingTrip(), huntingLog.getHuntLogId());
        return huntingLog;
    }   //6H. This lets you update a Hunting Log

    private HuntingLog mapResultsToHutingLog(SqlRowSet results){
        HuntingLog huntingLog = new HuntingLog();
        huntingLog.setHuntLogId(results.getLong("hunt_log_id"));
        huntingLog.setUserId(results.getLong("user_id"));
        huntingLog.setLogDate(results.getString("log_date"));
        huntingLog.setLogLocation(results.getString("log_location"));
        huntingLog.setLogDescription(results.getString("log_description"));
        huntingLog.setImageURL(results.getString("images"));
        huntingLog.setWeather(results.getString("weather"));
        huntingLog.setHuntingType(results.getString("hunting_type"));
        huntingLog.setHuntingTrip(results.getString("hunting_trip"));
        return huntingLog;
    }    // this is just a helper method  **********
}
