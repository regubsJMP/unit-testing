package com.epam.spring.homework.service.impl;

import com.epam.spring.homework.dao.UserDAO;
import com.epam.spring.homework.domain.User;
import com.epam.spring.homework.service.UserService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Renat Gubaidullin on 6/12/2016.
 */
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    @Nullable
    @Override
    public User getUserByEmail(@Nonnull String email) {
        return userDAO.getUserByEmail(email);
    }

    @Override
    public void save(@Nonnull User object) {
        userDAO.save(object);
    }

    @Override
    public void remove(@Nonnull User object) {
        userDAO.remove(object);
    }

    @Override
    public User getById(@Nonnull Long id) {
        return userDAO.getById(Math.toIntExact(id));
    }

    @Nonnull
    @Override
    public Collection<User> getAll() {
        return userDAO.getAll();
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
