package com.epam.spring.homework.discount;

import com.epam.spring.homework.domain.Event;
import com.epam.spring.homework.domain.User;

import java.time.LocalDateTime;

/**
 * Created by Renat Gubaidullin on 6/12/2016.
 */
public interface DiscountStrategy {
    byte getDiscount(User user, Event event, LocalDateTime airDateTime, long numberOfTickets);
}
