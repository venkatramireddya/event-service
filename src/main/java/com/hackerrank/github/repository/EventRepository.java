package com.hackerrank.github.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hackerrank.github.model.Event;

@Repository
public interface EventRepository  extends JpaRepository<Event, Long>{
	
	
	
	@Query("select t from Event t where t.repo.id = ?1  ORDER BY t.id ASC")
	public List<Event> getEventsRepoById(Long repoID);
	
	
	@Query("select t from Event t where t.actor.id = ?1  ORDER BY t.id ASC")
	public List<Event> getEventsByActorId(Long actorID);
	
	
	
	@Query("select t from Event t where t.repo.id = ?1 and t.actor.id = ?2 ")
	public List<Event> getEventsByActorIdRepoId(Long repoID, Long actorID);
}
