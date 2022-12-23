package org.cs202.entity.dto;

public class CreateHouseKeepingSchedulesRequest {

    private int roomId;

    private int createdUserId;

    private int houseKeepingId;

    public CreateHouseKeepingSchedulesRequest(int roomId, int createdUserId, int houseKeepingId) {

        this.roomId = roomId;
        this.createdUserId = createdUserId;
        this.houseKeepingId = houseKeepingId;
    }

    @Override
    public String toString() {
        return "CreateHouseKeepingSchedulesRequest{" +
                "roomId=" + roomId +
                ", createdUser=" + createdUserId +
                ", houseKeepingId=" + houseKeepingId +
                '}';
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(int createdUserId) {
        this.createdUserId = createdUserId;
    }

    public int getHouseKeepingId() {
        return houseKeepingId;
    }

    public void setHouseKeepingId(int houseKeepingId) {
        this.houseKeepingId = houseKeepingId;
    }
}
