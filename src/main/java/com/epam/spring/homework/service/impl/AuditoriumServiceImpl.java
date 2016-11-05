package com.epam.spring.homework.service.impl;

import com.epam.spring.homework.dao.AuditoriumDAO;
import com.epam.spring.homework.dao.impl.maps.AuditoriumDAOMapsImpl;
import com.epam.spring.homework.domain.Auditorium;
import com.epam.spring.homework.service.AuditoriumService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Set;

/**
 * Created by Renat Gubaidullin on 6/12/2016.
 */
public class AuditoriumServiceImpl implements AuditoriumService {
    AuditoriumDAO auditoriumDAO = new AuditoriumDAOMapsImpl();

    public AuditoriumDAO getAuditoriumDAO() {
        return auditoriumDAO;
    }

    public void setAuditoriumDAO(AuditoriumDAO auditoriumDAO) {
        this.auditoriumDAO = auditoriumDAO;
    }

    @Nonnull
    @Override
    public Set<Auditorium> getAll() {
        return (Set<Auditorium>) auditoriumDAO.getAll();
    }

    @Nullable
    @Override
    public Auditorium getByName(@Nonnull String name) {
        Set<Auditorium> result = (Set<Auditorium>) auditoriumDAO.getAll();
        Auditorium auditoriumFound = null;
        for(Auditorium auditorium : result){
            if(auditorium.getName().equals(name)){
                auditoriumFound = auditorium;
                break;
            }
        }
        return auditoriumFound;
    }
}
