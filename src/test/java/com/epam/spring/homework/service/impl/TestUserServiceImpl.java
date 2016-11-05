package com.epam.spring.homework.service.impl;

import com.epam.spring.homework.dao.impl.maps.UserDAOMapsImpl;
import com.epam.spring.homework.domain.User;
import com.epam.spring.homework.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.Assert.assertEquals;

/**
 * Created by Renat Gubaidullin on 6/12/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestUserServiceImpl {
    @Mock
    UserDAOMapsImpl userDAO;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    public void testUserService_checkGetUserByEmailReturnsOneUser(){
        String email = "fake@gmail.com";
        User user = mock(User.class);
        when(userDAO.getUserByEmail(email)).thenReturn(user);

        User userDerived = userDAO.getUserByEmail(email);
        when(userService.getUserByEmail(email)).thenReturn(userDerived);

        assertNotNull(userService.getUserByEmail(email));
    }
}
