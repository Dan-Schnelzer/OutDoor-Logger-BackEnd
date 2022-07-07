package com.techelevator.controller;


import com.techelevator.dao.FishingLogDao;
import com.techelevator.model.FishingLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RequestMapping("/outdoorlogger")
@RestController
@PreAuthorize("isAuthenticated()")     //this need activated once I figure how to get users and passwords working
public class FishLogController {
    @Autowired
    FishingLogDao fishingLogDao;


    //************ THIS IS FISHING LOG METHODS (5)  *************

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/fishinglog/create", method = RequestMethod.POST)
    public FishingLog createNewFishingLog(@RequestBody FishingLog fishingLog){
            return fishingLogDao.createFishingLog(fishingLog);
    }  // 1F.this method will create a new fishing log entry

//    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping(path = "/fishinglog/findlogs/{id}" , method = RequestMethod.GET)
    public List<Long> fishLogIds(@PathVariable("id") long userId){
        return fishingLogDao.getLogIds(userId);
    }    // 2F.this method will get you a list of all of the fishing log IDs that you have

//    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping(path = "/fishinglog/{id}", method = RequestMethod.GET)
    public FishingLog viewMyFishLog(@PathVariable("id") long logId){
        return fishingLogDao.getFishingLogById(logId);
    }    //3F.this method will bring your fishing log info once you pick a fishing log ID

//    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping(path = "/fishinglog/{id}" , method = RequestMethod.DELETE)
    public void deleteFishingLog(@PathVariable("id") long logId){
        fishingLogDao.deleteFishingLog(logId);
    }   //4F. this method will delete a fishing log by ID

//    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping(path = "/fishinglog/user/{id}", method = RequestMethod.GET)
    public List<FishingLog> viewMyFishingLogs(@PathVariable("id") long userId){
        return fishingLogDao.getFishingLogsByUser(userId);
    }   //5F. this method will bring you all of your fishing logs to view by your userID

//    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping(path = "/fishinglog/update/{fishLogId}", method = RequestMethod.PUT)
    public FishingLog updateFishingLog(@PathVariable long fishLogId, @RequestBody FishingLog fishingLog){
        return fishingLogDao.updateFishingLog(fishingLog);
    }   //6F. this will update an existing fishing Log

}
