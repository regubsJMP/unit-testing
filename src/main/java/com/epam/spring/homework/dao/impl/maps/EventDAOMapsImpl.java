package com.epam.spring.homework.dao.impl.maps;

import com.epam.spring.homework.dao.AbstractDAO;
import com.epam.spring.homework.dao.EventDAO;
import com.epam.spring.homework.domain.Event;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Renat Gubaidullin on 6/10/2016.
 */
@Repository
public class EventDAOMapsImpl implements EventDAO {
    private Map<Long,Event> events = new HashMap<Long,Event>();

    public Map<Long, Event> getEvents() {
        return events;
    }

    public void setEvents(Map<Long, Event> events) {
        this.events = events;
    }

    @Override
    public void save(Event object) {
        if(events != null && events.size()>0){
            Long maxID = Collections.max(events.keySet());
            Long newID = maxID + 1;
            object.setId(newID);
            events.put(newID, object);
        }else{
            events.put(1L,object);
        }
    }

    @Override
    public void remove(Event object) {
        events.remove(object.getId());
    }

    @Override
    public Collection<Event> getAll() {
        Set<Event> result = new LinkedHashSet<Event>();
        for(Event event: events.values()){
            result.add(event);
        }
        return result;
    }

    @Override
    public Event getById(int id) {
        return events.get(Long.valueOf(id));
    }

    @Override
    public Event getByName(String name) {
        return events.entrySet().stream()
                .map(longEventEntry -> longEventEntry.getValue())
                .filter(event -> event.getName().equals(name))
                .findFirst()
                .get();
    }

    @Override
    public Collection<Event> getForDateRange(LocalDate fromDate, LocalDate toDate) {
        Set<Event> result = new LinkedHashSet<Event>();

        for(Map.Entry<Long,Event> eventEntry : events.entrySet()){
            Event event = eventEntry.getValue();
            LocalDateTime lfromDate = LocalDateTime.of(fromDate, LocalTime.MIN);
            LocalDateTime ltoDate = LocalDateTime.of(toDate,LocalTime.MIN);
            NavigableSet<LocalDateTime> airDates = event.getAirDates();
            for(LocalDateTime airDate : airDates){
                if(airDate.isAfter(lfromDate) && airDate.isBefore(ltoDate)){
                    result.add(event);
                }
            }
        }
        return result;
    }

    @Override
    public Collection<Event> getNextEvents(LocalDateTime toDate) {
        Set<Event> result = new LinkedHashSet<Event>();
        LocalDateTime fromDate = LocalDateTime.now();

        for(Map.Entry<Long,Event> eventEntry : events.entrySet()){
            Event event = eventEntry.getValue();
            NavigableSet<LocalDateTime> airDates = event.getAirDates();
            for(LocalDateTime airDate : airDates){
                if(airDate.isAfter(fromDate) && airDate.isBefore(toDate)){
                    result.add(event);
                }
            }
        }
        return result;
    }
}
