package com.epam.spring.homework.main;

import com.epam.spring.homework.dao.AuditoriumDAO;
import com.epam.spring.homework.dao.EventDAO;
import com.epam.spring.homework.dao.UserDAO;
import com.epam.spring.homework.dao.impl.maps.AuditoriumDAOMapsImpl;
import com.epam.spring.homework.dao.impl.maps.EventDAOMapsImpl;
import com.epam.spring.homework.dao.impl.maps.UserDAOMapsImpl;
import com.epam.spring.homework.domain.*;
import com.epam.spring.homework.service.AuditoriumService;
import com.epam.spring.homework.service.EventService;
import com.epam.spring.homework.service.UserService;
import com.epam.spring.homework.service.impl.AuditoriumServiceImpl;
import com.epam.spring.homework.service.impl.EventServiceImpl;
import com.epam.spring.homework.service.impl.UserServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/**
 * Created by Renat Gubaidullin on 6/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");

        /*System.out.println("****** Test UserService *****");
        UserService userService = context.getBean("userService",UserServiceImpl.class);
        System.out.println("** getAll() **");
        userService.getAll().forEach(userIter -> System.out.println(userIter.getFirstName()));
        System.out.println("** getById() **");
        System.out.println(userService.getById(1L).getFirstName());
        System.out.println("** getUserByEmail() **");
        System.out.println(userService.getUserByEmail("tomas.jefferson@gmail.com").getFirstName());
        System.out.println("** Create user Renat Gubaidullin **");
        User user = new User("Renat" ,"Gubaidullin", LocalDate.of(1988,8,12),"kniazigor878@gmail.com", Role.ADMIN);
        userService.save(user);
        userService.getAll().forEach(userIter1 -> System.out.println(userIter1.getFirstName()));
        System.out.println("** Remove user Renat Gubaidullin **");
        userService.remove(user);
        userService.getAll().forEach(userIter1 -> System.out.println(userIter1.getFirstName()));*/

        System.out.println("****** Test UserService *****");
        AuditoriumService auditoriumService = context.getBean("auditoriumService",AuditoriumService.class);
        System.out.println("** getAll() **");
        auditoriumService.getAll().forEach(auditoriumIter -> System.out.println(auditoriumIter.getName()));
        System.out.println("** getByName() **");
        System.out.println(auditoriumService.getByName("Big auditorium").getVipSeats());

        /*System.out.println("****** Test EventService *****");
        EventService eventService = context.getBean("eventService",EventServiceImpl.class);
        System.out.println("** getAll() **");
        eventService.getAll().forEach(eventIter -> System.out.println(eventIter.getName()));
        System.out.println("** getById() **");
        System.out.println(eventService.getById(0L).getName());
        System.out.println("** getByName() **");
        System.out.println(eventService.getByName("Transformers").getAirDates());
        System.out.println("** save() **");
        Event event = new Event("Броненосец Потемкин", null, 30.0, EventRating.HIGH, null);
        eventService.save(event);
        eventService.getAll().forEach(eventIter -> System.out.println(eventIter.getName()));
        System.out.println("** remove() **");
        eventService.remove(event);
        eventService.getAll().forEach(eventIter -> System.out.println(eventIter.getName()));
        System.out.println("** getForDateRange() **");
        LocalDate localDateFrom = LocalDate.of(2016,6,12);
        LocalDate localDateTo = LocalDate.of(2016,6,13);
        eventService.getForDateRange(localDateFrom, localDateTo).forEach(event1 -> System.out.println(event1.getName()));
        System.out.println("** getForDateRange() **");
        LocalDateTime localDateTimeTo = LocalDateTime.of(LocalDate.of(2016,6,13), LocalTime.MIN);
        eventService.getNextEvents(localDateTimeTo).forEach(event1 -> System.out.println(event1.getName()));*/
    }
}
