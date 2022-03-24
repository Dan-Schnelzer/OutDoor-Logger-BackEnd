package com.techelevator.dao;

import com.techelevator.model.HikingLog;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JDBCHikingLogDao implements HikingLogDao {

    private JdbcTemplate jdbcTemplate;

    public JDBCHikingLogDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public HikingLog createHikingLog(HikingLog hikingLog) {
        String sql = "INSERT INTO hiking_log (user_id, log_date, log_location, log_description, images, weather, log_state " +
                " VALUES (?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, hikingLog.getUserId(), hikingLog.getLogDate(), hikingLog.getLogLocation(), hikingLog.getLogDescription(),
                hikingLog.getImageURL(), hikingLog.getWeather(), hikingLog.getLogState());
        return hikingLog;
    }   //1HK this will create a new hiking log

    @Override
    public List<Long> getLogIds(long userId) {
        List<Long> hikingIds = new ArrayList<>();
        String sql = " SELECT hiking_log_id FROM hiking_log WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while(results.next()){
            hikingIds.add(results.getLong("hiking_log_id"));
        }
        return hikingIds;
    }   //2HK this method will bring a list of the users Hiking Log Ids

    @Override
    public HikingLog getHikingLogById(long logId) {
        HikingLog hikingLog = new HikingLog();
        String sql = " SELECT * FROM hiking_log WHERE hiking_log_id = ? ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, logId);
        while (results.next()){
            hikingLog = mapResultsToHikingLog(results);
        }
        return hikingLog;
    }   //3HK. this method will bring up your log after choosing an ID

    @Override
    public void deleteHikingLog(long logId) {
        String sql = " DELETE FROM hiking_log WHERE hiking_log_id = ? ";
        jdbcTemplate.update(sql,logId);
    }   //4HK. this method will delete a hiking log

    @Override
    public List<HikingLog> getHikingLogsByUser(long userId) {
        List<HikingLog> hikingList = new ArrayList<>();
        String sql = " SELECT * FROM hiking_log WHERE user_id = ? ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()){
            hikingList.add(mapResultsToHikingLog(results));
        }
        return hikingList;
    }   //5HK. this method lets you view all of the hiking logs that you have

    @Override
    public HikingLog updateHikingLog(HikingLog hikingLog) {
        String sql = " UPDATE hiking_log SET user_id = ?, log_date = ?, log_location = ?, log_description = ?, " +
                " images = ?, weather = ?, log_state = ? WHERE hiking_log_id = ? ";
        jdbcTemplate.update(sql, hikingLog.getUserId(), hikingLog.getLogDate(), hikingLog.getLogLocation(), hikingLog.getLogDescription(),
                hikingLog.getImageURL(), hikingLog.getWeather(), hikingLog.getLogState(), hikingLog.getHikingLogId());
        return hikingLog;
    }   //6HK. This lets you update a Hiking Log

    private HikingLog mapResultsToHikingLog(SqlRowSet results){
        HikingLog hikingLog = new HikingLog();
        hikingLog.setHikingLogId(results.getLong("hiking_log_id"));
        hikingLog.setUserId(results.getLong("user_id"));
        hikingLog.setLogDate(results.getString("log_date"));
        hikingLog.setLogDescription(results.getString("log_description"));
        hikingLog.setImageURL(results.getString("images"));
        hikingLog.setLogLocation(results.getString("log_location"));
        hikingLog.setWeather(results.getString("weather"));
        hikingLog.setLogState(results.getString("log_state"));
        return hikingLog;
    }   // this is just a helper method   ************
}
