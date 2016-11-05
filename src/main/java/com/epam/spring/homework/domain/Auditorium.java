package com.epam.spring.homework.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * Created by Renat Gubaidullin on 6/10/2016.
 */
public class Auditorium{

    private String name;

    private long numberOfSeats;

    private Set<Long> vipSeats = Collections.emptySet();// was  Set<Long> vipSeats = Collections.emptySet()

    public Auditorium() {
    }

    /**
     * Counts how many vip seats are there in supplied <code>seats</code>
     * 
     * @param seats
     *            Seats to process
     * @return number of vip seats in request
     */
    /*public long countVipSeats(Collection<Long> seats) {
        return seats.stream().filter(seat -> vipSeats.contains(seat)).count();
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(long numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
    
    public Set<Long> getAllSeats() {
        return LongStream.range(1, numberOfSeats+1).boxed().collect(Collectors.toSet());
    }

    public Set<Long> getVipSeats() {
        return vipSeats;
    }

    public void setVipSeats(int[] vipSeats) {
        Set<Long> result = new HashSet<Long>();
        for(int value : vipSeats){
            if(!result.contains(Long.valueOf(value))) {
                result.add(Long.valueOf(value));
            }
        }
        this.vipSeats = result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Auditorium other = (Auditorium) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

}
