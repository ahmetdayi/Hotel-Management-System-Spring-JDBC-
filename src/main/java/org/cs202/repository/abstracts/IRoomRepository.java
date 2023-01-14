package org.cs202.repository.abstracts;

import org.cs202.entity.concretes.Room;
import org.cs202.entity.concretes.User;

import java.util.List;

public interface IRoomRepository {

    boolean save(Room room);

    List<Room> findAll();

    

    boolean deleteById(int id,int callingUserId);

    boolean updateRename(Room room);

    boolean updateChangeType(Room room);


    Room getById(int id);
}
