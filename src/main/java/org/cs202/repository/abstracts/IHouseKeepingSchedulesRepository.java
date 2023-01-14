package org.cs202.repository.abstracts;

import org.cs202.entity.concretes.HouseKeepingSchedules;
import org.cs202.repository.concretes.HouseKeepingSchedulesRepository;

import java.util.List;

public interface IHouseKeepingSchedulesRepository {

    List<HouseKeepingSchedules> findAll();
    boolean save(HouseKeepingSchedules schedules);
    HouseKeepingSchedules getById(int id);

    boolean deleteById(int id);




}
