package com.epam.spring.homework.dao.impl.maps;

import com.epam.spring.homework.dao.AbstractDAO;
import com.epam.spring.homework.dao.TicketDAO;
import com.epam.spring.homework.domain.Event;
import com.epam.spring.homework.domain.Ticket;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by Renat Gubaidullin on 6/10/2016.
 */
public class TicketDAOMapsImpl implements TicketDAO {
    private Map<Long,Ticket> tickets = new HashMap<Long,Ticket>();

    public Map<Long, Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Map<Long, Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public void save(Ticket object) {
        if(tickets != null && tickets.size()>0){
            Long maxID = Collections.max(tickets.keySet());
            Long newID = maxID + 1;
            object.setId(newID);
            tickets.put(newID, object);
        }else{
            tickets.put(1L,object);
        }
    }

    @Override
    public void save(Set<Ticket> object) {
        for(Ticket ticket : object){
            save(ticket);
        }
    }

    @Override
    public void remove(Ticket object) {
        tickets.remove(object.getId());
    }

    @Override
    public Collection<Ticket> getAll() {
        Set<Ticket> result = new LinkedHashSet<Ticket>();
        for(Ticket ticket: tickets.values()){
            result.add(ticket);
        }
        return result;
    }

    @Override
    public Collection<Ticket> getByEventAndTime(Event event, LocalDateTime localDateTime) {
        Set<Ticket> result = new HashSet<Ticket>();
        for(Ticket ticket : (HashSet<Ticket>) getAll()){
            if(ticket.getEvent().equals(event) && ticket.getDateTime().equals(localDateTime)){
                result.add(ticket);
            }
        }
        return result;
    }
}
