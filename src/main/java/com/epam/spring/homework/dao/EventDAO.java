package com.epam.spring.homework.dao;

import com.epam.spring.homework.domain.Event;
import javax.annotation.Nonnull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Renat Gubaidullin on 6/10/2016.
 */
public interface EventDAO {
    public void save(Event object);
    public void remove(Event object);
    public Collection<Event> getAll();
    public Event getById(int id);
    public Event getByName(String name);
    public Collection<Event> getForDateRange(LocalDate fromDate, LocalDate toDate);
    public Collection<Event> getNextEvents(LocalDateTime toDate);
}
