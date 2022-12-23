package org.cs202.repository.abstracts;

import org.cs202.entity.concretes.User;

public interface IUserRepository {

    User save(User user) throws Exception;
    void deleteById(int id);

    void update(User user);

    User getById(int id);



}
