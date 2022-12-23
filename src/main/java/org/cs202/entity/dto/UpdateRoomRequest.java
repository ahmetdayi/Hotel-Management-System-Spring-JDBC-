package org.cs202.entity.dto;

public class UpdateRoomRequest {
    private int id;

    private String name;

    private String roomType;

    private int updatedUser;

    public UpdateRoomRequest(int id, String name, String roomType, int updatedUser) {
        this.id = id;
        this.name = name;
        this.roomType = roomType;
        this.updatedUser = updatedUser;
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

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getUpdatedUser() {
        return updatedUser;
    }

    public void setUpdatedUser(int updatedUser) {
        this.updatedUser = updatedUser;
    }
}
