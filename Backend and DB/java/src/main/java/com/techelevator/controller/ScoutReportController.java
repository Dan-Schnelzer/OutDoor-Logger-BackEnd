package com.techelevator.controller;

import com.techelevator.dao.ScoutingReportDao;
import com.techelevator.model.ScoutingReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/outdoorlogger")
@RestController
public class ScoutReportController {

    @Autowired
    ScoutingReportDao scoutingReportDao;


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

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping(path = "/scoutingreport/update/{id}", method = RequestMethod.PUT)
    public ScoutingReport updateScoutReport(@PathVariable long scoutReportID, @RequestBody ScoutingReport scoutingReport){
        return scoutingReportDao.updateScoutReport(scoutingReport);
    }   //6S. this method will update and existing Scout Report
}
