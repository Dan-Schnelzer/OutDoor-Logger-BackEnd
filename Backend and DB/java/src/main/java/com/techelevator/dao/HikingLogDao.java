package com.techelevator.dao;

import com.techelevator.model.HikingLog;

import java.util.List;

public interface HikingLogDao {

    HikingLog createHikingLog (HikingLog hikingLog);     //1HK

    List<Long> getLogIds(long userId);         //2HK

    HikingLog getHikingLogById(long logId);      //3HK

    void deleteHikingLog(long logId);    //4HK

    List<HikingLog> getHikingLogsByUser(long userId);    //6HK

    HikingLog updateHikingLog(HikingLog hikingLog);     //7HK
}
