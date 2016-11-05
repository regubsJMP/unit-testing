package com.epam.spring.homework.service.impl;

import com.epam.spring.homework.dao.AuditoriumDAO;
import com.epam.spring.homework.dao.EventDAO;
import com.epam.spring.homework.dao.TicketDAO;
import com.epam.spring.homework.dao.UserDAO;
import com.epam.spring.homework.domain.*;
import com.epam.spring.homework.service.BookingService;
import com.epam.spring.homework.service.DiscountService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Renat Gubaidullin on 6/12/2016.
 */
public class BookingServiceImpl implements BookingService {
    private EventDAO eventDAO;
    private UserDAO userDAO;
    private TicketDAO ticketDAO;
    private AuditoriumDAO auditoriumDAO;
    private DiscountService discountService;

    @Override
    public double getTicketsPrice(@Nonnull Event event, @Nonnull LocalDateTime dateTime, @Nullable User user, @Nullable Auditorium auditorium, @Nonnull Set<Long> seats) {
        double ticketsPrice = 0.0;
        double baseprice = event.getBasePrice();
        EventRating eventRating = event.getRating();
        byte discount = discountService.getDiscount(user,event,dateTime,seats.size());

        ticketsPrice = calculatePrice(auditorium, seats, baseprice, eventRating, discount);

        return ticketsPrice;
    }

    private double calculatePrice(@Nullable Auditorium auditorium, @Nonnull Set<Long> seats, double baseprice, EventRating eventRating, byte discount) {
        Double totalPrice = 0.0;
        long numberOfSeats = auditorium.getNumberOfSeats();
        Set<Long> vipSeats = auditorium.getVipSeats();
        for(Long seat: seats){
            if(vipSeats.contains(seat)){
                totalPrice += 2*baseprice;
            }else if(eventRating.equals(EventRating.HIGH)) {
                totalPrice += 1.2*baseprice;
            }else{
                totalPrice += baseprice;
            }
        }
        totalPrice = totalPrice * (1 - (double) discount/100);
        return totalPrice;
    }

    @Override
    public void bookTickets(@Nonnull Set<Ticket> tickets) {
        User user = null;
        NavigableSet<Ticket> navigableSet = new TreeSet<Ticket>();
        for(Ticket ticket: tickets){
            navigableSet.add(ticket);
            user = ticket.getUser();
        }
        if(user != null){
            user.getTickets().addAll(navigableSet);
        }
        ticketDAO.save(tickets);

    }

    @Nonnull
    @Override
    public Set<Ticket> getPurchasedTicketsForEvent(@Nonnull Event event, @Nonnull LocalDateTime dateTime) {
        return (HashSet<Ticket>) ticketDAO.getByEventAndTime(event,dateTime);
    }

    public EventDAO getEventDAO() {
        return eventDAO;
    }

    public void setEventDAO(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public TicketDAO getTicketDAO() {
        return ticketDAO;
    }

    public void setTicketDAO(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }

    public AuditoriumDAO getAuditoriumDAO() {
        return auditoriumDAO;
    }

    public void setAuditoriumDAO(AuditoriumDAO auditoriumDAO) {
        this.auditoriumDAO = auditoriumDAO;
    }

    public DiscountService getDiscountService() {
        return discountService;
    }

    public void setDiscountService(DiscountService discountService) {
        this.discountService = discountService;
    }
}
