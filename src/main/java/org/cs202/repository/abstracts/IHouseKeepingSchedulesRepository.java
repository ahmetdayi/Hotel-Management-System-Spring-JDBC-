package org.cs202.repository.abstracts;

import org.cs202.entity.concretes.HouseKeepingSchedules;

import java.util.List;

public interface IHouseKeepingSchedulesRepository {

    List<HouseKeepingSchedules> findAll();
}
