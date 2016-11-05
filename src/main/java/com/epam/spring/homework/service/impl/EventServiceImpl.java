package com.epam.spring.homework.service.impl;

import com.epam.spring.homework.dao.EventDAO;
import com.epam.spring.homework.domain.Event;
import com.epam.spring.homework.service.EventService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

/**
 * Created by Renat Gubaidullin on 6/12/2016.
 */
public class EventServiceImpl implements EventService {
    private EventDAO eventDAO;

    @Nullable
    @Override
    public Event getByName(@Nonnull String name) {
        return eventDAO.getByName(name);
    }

    @Nonnull
    @Override
    public Set<Event> getForDateRange(@Nonnull LocalDate from, @Nonnull LocalDate to) {
        return (Set<Event>) eventDAO.getForDateRange(from, to);
    }

    @Nonnull
    @Override
    public Set<Event> getNextEvents(@Nonnull LocalDateTime to) {
        return (Set<Event>) eventDAO.getNextEvents(to);
    }

    @Override
    public void save(@Nonnull Event object) {
        eventDAO.save(object);
    }

    @Override
    public void remove(@Nonnull Event object) {
        eventDAO.remove(object);
    }

    @Override
    public Event getById(@Nonnull Long id) {
        return eventDAO.getById(Math.toIntExact(id));
    }

    @Nonnull
    @Override
    public Collection<Event> getAll() {
        return eventDAO.getAll();
    }

    public EventDAO getEventDAO() {
        return eventDAO;
    }

    public void setEventDAO(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }
}
