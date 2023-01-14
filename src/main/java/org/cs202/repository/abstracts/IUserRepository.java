package org.cs202.repository.abstracts;

import org.cs202.entity.concretes.User;

public interface IUserRepository {

    boolean save(User user) throws Exception;
    void deleteById(int id);

    boolean updateName(User user);

    User getById(int id);



}
