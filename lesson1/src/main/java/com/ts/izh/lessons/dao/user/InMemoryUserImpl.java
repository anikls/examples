package com.ts.izh.lessons.dao.user;

import com.ts.izh.lessons.dao.user.UserDAO;
import com.ts.izh.lessons.exception.UserException;
import com.ts.izh.lessons.domain.User;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Profile("!jdbc")
public class InMemoryUserImpl implements UserDAO {

    private final Map<Integer, User> users = new HashMap<>();

    @Override
    public void create(User user) throws UserException {
        users.put(user.getId(), user);
    }

    @Override
    public void update(User user) throws UserException {
        users.replace(user.getId(), user);
    }

    @Override
    public List<User> getAllUsers() throws UserException {
        return new ArrayList(users.values());
    }
}
