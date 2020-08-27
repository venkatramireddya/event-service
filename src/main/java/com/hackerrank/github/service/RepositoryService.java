package com.hackerrank.github.service;

import java.util.List;

import com.hackerrank.github.model.Event;

public interface RepositoryService {
  
 
    void createNewEvents(Event event);
    void deleteAllEvents();
    List<Event> getAllEvents();
    List<Event> getEventsByRepoId(Long repoID);
    List<Event> getEventsByActorId(Long actorID);
    List<Event> getEventsByActorIdRepoId(Long repoID, Long actorID);
    
}
