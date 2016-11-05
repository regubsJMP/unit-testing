package com.epam.spring.homework.service.impl;

import com.epam.spring.homework.dao.AuditoriumDAO;
import com.epam.spring.homework.dao.EventDAO;
import com.epam.spring.homework.dao.TicketDAO;
import com.epam.spring.homework.dao.UserDAO;
import com.epam.spring.homework.discount.DiscountStrategy;
import com.epam.spring.homework.domain.Event;
import com.epam.spring.homework.domain.User;
import com.epam.spring.homework.service.DiscountService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by Renat Gubaidullin on 6/12/2016.
 */
public class DiscountServiceImpl implements DiscountService {
    /*private EventDAO eventDAO;
    private UserDAO userDAO;
    private TicketDAO ticketDAO;
    private AuditoriumDAO auditoriumDAO;*/
    private List<DiscountStrategy> discountStrategies;

    @Override
    public byte getDiscount(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets) {
        byte discount = 0;
        List<Byte> discountsList = new ArrayList<Byte>();
        for(DiscountStrategy discountStrategy: discountStrategies){
            discountsList.add(discountStrategy.getDiscount(user,event,airDateTime,numberOfTickets));
        }
        Collections.sort(discountsList);
        discount = discountsList.get(discountsList.size()-1);
        return discount;
    }

    /*public EventDAO getEventDAO() {
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
    }*/

    public List<DiscountStrategy> getDiscountStrategies() {
        return discountStrategies;
    }

    public void setDiscountStrategies(List<DiscountStrategy> discountStrategies) {
        this.discountStrategies = discountStrategies;
    }
}
