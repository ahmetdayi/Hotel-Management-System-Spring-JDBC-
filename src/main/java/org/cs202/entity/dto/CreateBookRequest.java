package org.cs202.entity.dto;

public class CreateBookRequest {

    private int userId;

    private int roomId;

    @Override
    public String toString() {
        return "CreateBookRequest{" +
                "userId=" + userId +
                ", roomId=" + roomId +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public CreateBookRequest(int userId, int roomId) {
        this.userId = userId;
        this.roomId = roomId;
    }
}
