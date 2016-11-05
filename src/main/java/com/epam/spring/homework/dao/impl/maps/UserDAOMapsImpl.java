package com.epam.spring.homework.dao.impl.maps;

import com.epam.spring.homework.dao.AbstractDAO;
import com.epam.spring.homework.dao.UserDAO;
import com.epam.spring.homework.domain.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Renat Gubaidullin on 6/10/2016.
 */
public class UserDAOMapsImpl implements UserDAO{
    private Map<Long,User> users = new HashMap<Long,User>();

    public Map<Long, User> getUsers() {
        return users;
    }

    public void setUsers(Map<Long, User> users) {
        this.users = users;
    }

    @Override
    public void save(User object) {
        if(users != null && users.size()>0){
            Long maxID = Collections.max(users.keySet());
            Long newID = maxID + 1;
            object.setId(newID);
            users.put(newID, object);
        }else{
            users.put(1L,object);
        }
    }

    @Override
    public void remove(User object) {
        users.remove(object.getId());
    }

    @Override
    public Collection<User> getAll() {
        Set<User> result = new LinkedHashSet<User>();
        for(User user: users.values()){
            result.add(user);
        }
        return result;
    }

    @Override
    public User getById(int id) {
        return users.get(Long.valueOf(id));
    }

    @Override
    public User getUserByEmail(String email) {
        return users.entrySet().stream()
                .map(longUserEntry -> longUserEntry.getValue())
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .get();
    }
}
