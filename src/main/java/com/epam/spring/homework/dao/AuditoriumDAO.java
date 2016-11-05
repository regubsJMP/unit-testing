package com.epam.spring.homework.dao;

import com.epam.spring.homework.domain.Auditorium;

import javax.annotation.Nonnull;
import java.util.Collection;

/**
 * Created by Renat Gubaidullin on 6/10/2016.
 */
public interface AuditoriumDAO {
    public void save(Auditorium object);
    public void remove(Auditorium object);
    public Collection<Auditorium> getAll();
}
