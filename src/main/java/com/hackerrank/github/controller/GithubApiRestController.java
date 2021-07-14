package com.hackerrank.github.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.github.model.Event;
import com.hackerrank.github.service.RepositoryService;

@RestController
public class GithubApiRestController {
		
	@Autowired
    private RepositoryService repositoryService;

    @RequestMapping(value = "/events", method = RequestMethod.POST, consumes = "application/json")
    public void createNewEvents(@RequestBody @Valid Event event) {
    	repositoryService.createNewEvents(event);
    }

    @RequestMapping(value = "/erase", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllEvents() {
    	repositoryService.deleteAllEvents();
    }

  
    @RequestMapping(value = "/events", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Event> getAllEvents() {
        //return repositoryService.getAllEvents();
    }

    @RequestMapping(value = "/events/repos/{repoID}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Event> getEventsByRepoId(@PathVariable Long repoID) {
        return repositoryService.getEventsByRepoId(repoID);
    }
    
    @RequestMapping(value = "/events/actors/{actorID}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Event> getEventsByActorId(@PathVariable Long actorID) {
        return repositoryService.getEventsByActorId(actorID);
    }
    
    @RequestMapping(value = "/events/repos/{repoID}/actors/{actorID}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Event> getEventsByActorIdRepoId(@PathVariable Long repoID, @PathVariable Long actorID) {
        return repositoryService.getEventsByActorIdRepoId(repoID,actorID);
    }
}
