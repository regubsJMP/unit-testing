package com.epam.spring.homework.discount.impl;

import com.epam.spring.homework.discount.DiscountStrategy;
import com.epam.spring.homework.domain.Event;
import com.epam.spring.homework.domain.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by Renat Gubaidullin on 6/12/2016.
 */
public class DiscountStrategyBirthdayImpl implements DiscountStrategy {
    @Override
    public byte getDiscount(User user, Event event, LocalDateTime airDateTime, long numberOfTickets) {
        byte discount = 0;
        LocalDate birthday = user.getBirthday();
        LocalDate birthdayCurrentYear = LocalDate.of(LocalDate.now().getYear(),birthday.getMonth(),birthday.getDayOfMonth());
        LocalDate birthdayCurrentYearBefore = birthdayCurrentYear.minusDays(5);
        LocalDate birthdayCurrentYearAfter = birthdayCurrentYear.plusDays(5);
        LocalDate airDate = LocalDate.of(airDateTime.getYear(),airDateTime.getMonth(),airDateTime.getDayOfMonth());
        if(airDate.isAfter(birthdayCurrentYearBefore) && airDate.isBefore(birthdayCurrentYearAfter)){
            discount = 5;
        }
        return discount;
    }
}
