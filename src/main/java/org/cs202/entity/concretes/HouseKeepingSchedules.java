package org.cs202.entity.concretes;

public class HouseKeepingSchedules {

    private int id;
    private Room room;

    private User createdUser;

    private User houseKeeping;

    public HouseKeepingSchedules() {
    }

    public HouseKeepingSchedules(Room room, User createdUser, User houseKeeping) {
        this.room = room;
        this.createdUser = createdUser;
        this.houseKeeping = houseKeeping;
    }

    @Override
    public String toString() {
        return "HouseKeepingSchedules{" +
                "id=" + id +
                ", room=" + room +
                ", createdUser=" + createdUser +
                ", houseKeeping=" + houseKeeping +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(User createdUser) {
        this.createdUser = createdUser;
    }

    public User getHouseKeeping() {
        return houseKeeping;
    }

    public void setHouseKeeping(User houseKeeping) {
        this.houseKeeping = houseKeeping;
    }
}
