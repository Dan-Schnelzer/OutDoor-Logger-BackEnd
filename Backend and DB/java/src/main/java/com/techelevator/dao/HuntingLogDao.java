package com.techelevator.dao;

import com.techelevator.model.HuntingLog;

import java.util.List;

public interface HuntingLogDao {

    HuntingLog createHuntingLog(HuntingLog huntingLog);        //1H

    List<Long> getLogIds(long userId);          //2H

    HuntingLog getHuntingLogById(long logId);            //3H

    void deleteHuntingLog(long logId);             //4H

    List<HuntingLog> getHuntingLogsByUser(long userId);        // 5H
}
