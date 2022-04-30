package com.techelevator.controller;

import com.techelevator.dao.HikingLogDao;
import com.techelevator.model.HikingLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RequestMapping("/outdoorlogger")
@RestController
@PreAuthorize("isAuthenticated()")
public class HikingController {
    @Autowired
    HikingLogDao hikingLogDao;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/hikinglog/create", method = RequestMethod.POST)
    public HikingLog createNewHikingLog(@RequestBody HikingLog hikingLog){
        return hikingLogDao.createHikingLog(hikingLog);
    }   // 1HK. this method will create a new Hiking Log

//    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping(path = "/hikinglog/findlogs/{id}" , method = RequestMethod.GET)
    public List<Long> hikingLogIds(@PathVariable("id") long userId){
        return hikingLogDao.getLogIds(userId);
    }   //2HK. this method will get you a list of all the hiking log ids from the userId

//    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping(path = "/hikinglog/{id}", method = RequestMethod.GET)
    public HikingLog viewMyHikingLog(@PathVariable("id") long logId){
        return hikingLogDao.getHikingLogById(logId);
    }   //3HK. this method will bring your hiking log info once the log id is selected

//    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping(path = "/hikinglog/{id}" , method = RequestMethod.DELETE)
    public void deleteHikingLog(@PathVariable("id") long logId){
        hikingLogDao.deleteHikingLog(logId);
    }  //4HK. this will delete a hiking log

//    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping(path = "/hikinglog/user/{id}", method = RequestMethod.GET)
    public List<HikingLog> viewMyHikingLogs(@PathVariable("id") long userId){
        return hikingLogDao.getHikingLogsByUser(userId);
    }   //5HK. this method will bring all of your hiking logs by userId

//    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping(path = "/hikinglog/update/{id}", method = RequestMethod.PUT)
    public HikingLog updateHikingLog(@PathVariable long hikingLogId, @RequestBody HikingLog hikingLog){
        return hikingLogDao.updateHikingLog(hikingLog);
    }   //6HK. this method will update and existing hiking log

}
