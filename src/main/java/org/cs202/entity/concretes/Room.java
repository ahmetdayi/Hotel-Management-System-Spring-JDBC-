package org.cs202.entity.concretes;

public class Room {

    private int id;
    //be uniq
    private String name;

    private RoomType roomType;

    private User createdUser;

    public Room() {
    }

    public Room(String name, RoomType roomType, User createdUser) {

        this.name = name;
        this.roomType = roomType;
        this.createdUser = createdUser;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roomType=" + roomType +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public User getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(User createdUser) {
        this.createdUser = createdUser;
    }
}
