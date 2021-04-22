package com.hackerrank.github.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hackerrank.github.exception.BadResourceRequestException;
import com.hackerrank.github.exception.NoSuchResourceFoundException;
import com.hackerrank.github.model.Event;
import com.hackerrank.github.repository.EventRepository;

@Service
@Transactional
public class RepositoryServiceImpl implements RepositoryService {
	
    @Autowired
    private EventRepository eventRepository;
  
    @Override
    @Transactional
    public void deleteAllEvents() {
    	eventRepository.deleteAll();
    }

    @Override
    @Transactional
    public void createNewEvents(Event event) {
    	Optional<Event> existingEvent = this.eventRepository.findById(event.getId());

        if (existingEvent.isPresent()) {
            throw new BadResourceRequestException("Event with same id exists.");
        }
       eventRepository.save(event);
    }

    @Override
    @Transactional
    public List<Event> getAllEvents() {
        return eventRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
    }
    
    
    @Override
    @Transactional
    public List<Event> getEventsByRepoId(Long repoID) {
		  List<Event> events = eventRepository.getEventsRepoById(repoID);
		  
		  if (events == null) { throw new
			  NoSuchResourceFoundException("No Event with given id found."); }
		  return events;
    }
    
    @Override
    @Transactional
    public List<Event> getEventsByActorId(Long actorID) {
    	List<Event> events = eventRepository.getEventsByActorId(actorID);

        if (events == null) {
            throw new NoSuchResourceFoundException("No Actor with given id found.");
        }

        return events;
    }
   
    
    @Override
    @Transactional
    public List<Event> getEventsByActorIdRepoId(Long repoID, Long actorID) {
    	List<Event> events = eventRepository.getEventsByActorIdRepoId(repoID, actorID);

        if (events == null || events.isEmpty() ) {
            throw new NoSuchResourceFoundException("No Event with given id found.");
        }

        return events;
    }

}
