package com.epam.spring.homework.dao;

import com.epam.spring.homework.domain.User;

import javax.annotation.Nonnull;
import java.util.Collection;

/**
 * Created by Renat Gubaidullin on 6/10/2016.
 */
public interface UserDAO {
    public void save(User object);
    public void remove(User object);
    public Collection<User> getAll();
    public User getById(int id);
    public User getUserByEmail(String email);
}
