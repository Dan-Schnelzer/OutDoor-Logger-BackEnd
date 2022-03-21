package com.techelevator.dao;

import com.techelevator.model.FishingLog;

import java.util.List;

public interface FishingLogDao {

    FishingLog createFishingLog(FishingLog fishingLog);     //1F

    List<Long> getLogIds(long userId);               //2F

    FishingLog getFishingLogById(long logId);               //3F

    void deleteFishingLog(long logId);               //4F

    List<FishingLog> getFishingLogsByUser(long userId);     //5F



}
