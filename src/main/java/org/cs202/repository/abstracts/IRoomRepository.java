package org.cs202.repository.abstracts;

import org.cs202.entity.concretes.Room;
import org.cs202.entity.concretes.User;

import java.util.List;

public interface IRoomRepository {

    Room save(Room room);

    List<Room> findAll();

    

    void deleteById(int id,int callingUserId);

    void update(Room room);

    Room getById(int id);
}
