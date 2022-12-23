package org.cs202.entity.dto;

public class CreateRoomRequest {

    //be uniq
    private String name;

    private String roomType;

    private int createdUserId;

    public CreateRoomRequest(String name, String roomType, int createdUserId) {
        this.name = name;
        this.roomType = roomType;
        this.createdUserId = createdUserId;
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

    public int getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(int createdUserId) {
        this.createdUserId = createdUserId;
    }
}

