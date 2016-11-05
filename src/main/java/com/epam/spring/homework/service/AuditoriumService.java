package com.epam.spring.homework.service;

import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.epam.spring.homework.domain.Auditorium;

/**
 * Created by Renat Gubaidullin on 6/10/2016.
 */
public interface AuditoriumService {

    /**
     * Getting all auditoriums from the system
     * 
     * @return set of all auditoriums
     */
    public @Nonnull Set<Auditorium> getAll();

    /**
     * Finding auditorium by name
     * 
     * @param name
     *            Name of the auditorium
     * @return found auditorium or <code>null</code>
     */
    public @Nullable Auditorium getByName(@Nonnull String name);

}
