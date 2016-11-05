package com.epam.spring.homework.discount.impl;

import com.epam.spring.homework.discount.DiscountStrategy;
import com.epam.spring.homework.domain.Event;
import com.epam.spring.homework.domain.User;

import java.time.LocalDateTime;

/**
 * Created by Renat Gubaidullin on 6/12/2016.
 */
public class DiscountStrategyTenTicketsImpl implements DiscountStrategy {
    final static int DISCOUNT_NUMBER = 10;
    @Override
    public byte getDiscount(User user, Event event, LocalDateTime airDateTime, long numberOfTickets) {
        byte discount = 0;
        int discauntTicketsNumber = (int) numberOfTickets/DISCOUNT_NUMBER;
        if(user != null){
            int ticketsNumber = user.getTickets().size();
            discount = (byte) (50*(discauntTicketsNumber + ticketsNumber % DISCOUNT_NUMBER)/numberOfTickets);
        }else{
            if(numberOfTickets >= DISCOUNT_NUMBER){
                discount = (byte)(50*discauntTicketsNumber/numberOfTickets);
            }
        }
        return discount;
    }
}
