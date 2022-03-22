package com.techelevator.controller;

import com.techelevator.dao.HuntingLogDao;
import com.techelevator.model.HuntingLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/outdoorlogger")
@RestController
public class HuntLogController {
    @Autowired
    HuntingLogDao huntingLogDao;

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

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping(path = "/huntinglog/update/{id}", method = RequestMethod.PUT)
    public HuntingLog updateHuntingLog(@PathVariable long huntLogId, @RequestBody HuntingLog huntingLog){
        return huntingLogDao.updateHuntingLog(huntingLog);
    }   //6H. this will update an existing hunting Log

}
