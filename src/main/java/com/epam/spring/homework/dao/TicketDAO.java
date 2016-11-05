package com.epam.spring.homework.dao;

import com.epam.spring.homework.domain.Event;
import com.epam.spring.homework.domain.Ticket;

import javax.annotation.Nonnull;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

/**
 * Created by Renat Gubaidullin on 6/10/2016.
 */
public interface TicketDAO {
    public void save(Ticket object);
    public void save(Set<Ticket> object);
    public void remove(Ticket object);
    public Collection<Ticket> getAll();
    public Collection<Ticket> getByEventAndTime(Event event, LocalDateTime localDateTime);
}
