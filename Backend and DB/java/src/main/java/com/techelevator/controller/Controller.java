package com.techelevator.controller;


import com.techelevator.dao.FishingLogDao;
import com.techelevator.dao.HuntingLogDao;
import com.techelevator.dao.ScoutingReportDao;
import com.techelevator.model.FishingLog;
import com.techelevator.model.HuntingLog;
import com.techelevator.model.ScoutingReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/outdoorlogger")
@RestController
//@PreAuthorize("isAuthenticated()")     //this need activated once I figure how to get users and passwords working
public class Controller {
    @Autowired
    FishingLogDao fishingLogDao;

    @Autowired
    HuntingLogDao huntingLogDao;

    @Autowired
    ScoutingReportDao scoutingReportDao;

    //************ THIS IS FISHING LOG METHODS (5)  *************

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/fishinglog/create", method = RequestMethod.POST)
    public FishingLog createNewFishingLog(@RequestBody FishingLog fishingLog){
            return fishingLogDao.createFishingLog(fishingLog);
    }  // 1F.this method will create a new fishing log entry

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping(path = "/fishinglog/findlogs/{id}" , method = RequestMethod.GET)
    public List<Long> fishLogIds(@PathVariable("id") long userId){
        return fishingLogDao.getLogIds(userId);
    }    // 2F.this method will get you a list of all of the fishing log IDs that you have

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping(path = "/fishinglog/{id}", method = RequestMethod.GET)
    public FishingLog viewMyFishLog(@PathVariable("id") long logId){
        return fishingLogDao.getFishingLogById(logId);
    }    //3F.this method will bring your fishing log info once you pick a fishing log ID

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping(path = "/fishinglong/{id}" , method = RequestMethod.DELETE)
    public void deleteFishingLog(@PathVariable("id") long logId){
        fishingLogDao.deleteFishingLog(logId);
    }   //4F. this method will delete a fishing log by ID

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping(path = "/fishinglog/user/{id}", method = RequestMethod.GET)
    public List<FishingLog> viewMyFishingLogs(@PathVariable("id") long userId){
        return fishingLogDao.getFishingLogsByUser(userId);
    }   //5F. this method will bring you all of your fishing logs to view by your userID




    //*********** THIS IS HUNTING LOG METHODS (5)   *****************

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/huntinglog/create", method = RequestMethod.POST)
    public HuntingLog createNewHuntingLog(@RequestBody HuntingLog huntingLog){
        return huntingLogDao.createHuntingLog(huntingLog);
    }   //1H. this method will create a new hunting log entry

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping(path = "/huntinglog/findlogs/{id}", method = RequestMethod.GET)
    public List<Long> huntLogIds(@PathVariable("id") long userId){
        return huntingLogDao.getLogIds(userId);
    }   //2H. this method will get you a list of all of the hunting log IDs that you have

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping(path = "/huntinglog/{id}", method = RequestMethod.GET)
    public HuntingLog viewMyHuntLog(@PathVariable("id") long logId){
        return huntingLogDao.getHuntingLogById(logId);
    }   //3H this method will bring your hunting log info once you pick a hunting log ID

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping(path = "/huntinglog/{id}", method = RequestMethod.DELETE)
    public void deleteHuntingLog(@PathVariable("id") long logId){
        huntingLogDao.deleteHuntingLog(logId);
    }   //4H. this method will delete a hunting log by ID

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping(path = "/huntinglog/user/{id}", method = RequestMethod.GET)
    public List<HuntingLog> viewMyHuntingLogs(@PathVariable("id") long userId){
        return huntingLogDao.getHuntingLogsByUser(userId);
    }   //5H. this method will bring you all of your hunting logs to view by your userID





    //************* THIS IS SCOUTING REPORTS METHODS (5) **************

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/scoutingreport/create", method = RequestMethod.POST)
    public ScoutingReport createNewScoutReport(@RequestBody ScoutingReport scoutingReport){
        return scoutingReportDao.createScoutingReport(scoutingReport);
    }   //1S. this method will create a new scout report entry

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping(path = "/scoutingreport/findreports/{id}", method = RequestMethod.GET)
    public List<Long> scoutReportIds(@PathVariable("id") long userId){
        return scoutingReportDao.getScoutReportIds(userId);
    }   //2S. this method will get you a list of all of the scout report IDs that you have

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping(path = "/scoutingreport/{id}", method = RequestMethod.GET)
    public ScoutingReport viewMyScoutReport(@PathVariable("id") long logId){
        return scoutingReportDao.getScoutingReportById(logId);
    }   //3S. this method will bring your scout report info once you pick a report ID

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping(path = "/scoutingreport/{id}", method = RequestMethod.DELETE)
    public void deleteScoutReport(@PathVariable("id") long logId){
        scoutingReportDao.deleteScoutReport(logId);
    }  //4S. this method will delete a scout report by ID

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping(path = "/scoutingreport/user/{id}", method = RequestMethod.GET)
    public List<ScoutingReport> viewMyScoutReports(@PathVariable("id") long userId){
        return scoutingReportDao.getScoutingReportByUser(userId);
    }   //5S. this method will bring you all of your scout reports to view by your userID
}
