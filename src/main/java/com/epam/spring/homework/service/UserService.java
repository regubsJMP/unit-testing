package com.epam.spring.homework.service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.epam.spring.homework.domain.User;

/**
 * Created by Renat Gubaidullin on 6/10/2016.
 */
public interface UserService extends AbstractDomainObjectService<User> {

    /**
     * Finding user by email
     * 
     * @param email
     *            Email of the user
     * @return found user or <code>null</code>
     */
    public @Nullable User getUserByEmail(@Nonnull String email);

}
