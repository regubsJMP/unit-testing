package com.epam.spring.homework.dao.impl.maps;

import com.epam.spring.homework.dao.AbstractDAO;
import com.epam.spring.homework.dao.AuditoriumDAO;
import com.epam.spring.homework.domain.Auditorium;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by Renat Gubaidullin on 6/10/2016.
 */
public class AuditoriumDAOMapsImpl implements AuditoriumDAO {
    private Map<Long,Auditorium> auditoriums = new HashMap<Long,Auditorium>();

    public Map<Long, Auditorium> getAuditoriums() {
        return auditoriums;
    }

    public void setAuditoriums(Map<Long, Auditorium> auditoriums) {
        this.auditoriums = auditoriums;
    }

    @Override
    public void save(Auditorium object) {

    }

    @Override
    public void remove(Auditorium object) {

    }

    @Override
    public Collection<Auditorium> getAll() {
        Set<Auditorium> result = new LinkedHashSet<Auditorium>();
        for(Auditorium auditorium: auditoriums.values()){
            result.add(auditorium);
        }
        return result;
    }
}
