package com.epam.spring.homework.dao;

import javax.annotation.Nonnull;
import java.util.Collection;

/**
 * Created by Renat Gubaidullin on 6/10/2016.
 */
public interface AbstractDAO<T> {
    public void save(T object);
    public void remove(T object);
    public Collection<T> getAll();
}
