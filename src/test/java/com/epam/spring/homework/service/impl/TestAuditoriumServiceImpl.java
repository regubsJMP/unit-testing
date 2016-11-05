package com.epam.spring.homework.service.impl;

import com.epam.spring.homework.dao.AuditoriumDAO;
import com.epam.spring.homework.dao.impl.maps.AuditoriumDAOMapsImpl;
import com.epam.spring.homework.domain.Auditorium;
import com.epam.spring.homework.service.AuditoriumService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Renat Gubaidullin on 6/12/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestAuditoriumServiceImpl {
    @Mock
    AuditoriumDAOMapsImpl auditoriumDAO;

    @InjectMocks
    AuditoriumServiceImpl auditoriumService;

    @Test
    public void testAuditoriumService_checkInitialNumberOfAuditoriums(){
        Set<Auditorium> auditoriumSet = new HashSet<Auditorium>(){{
            new Auditorium();
            new Auditorium();
            new Auditorium();
        }};
        when(auditoriumDAO.getAll()).thenReturn(auditoriumSet);

        Set<Auditorium> auditoriumSetDerived = (Set<Auditorium>) auditoriumDAO.getAll();
        when(auditoriumService.getAll()).thenReturn(auditoriumSetDerived);

        assertEquals(auditoriumSet.size(), auditoriumService.getAll().size());
    }
}
