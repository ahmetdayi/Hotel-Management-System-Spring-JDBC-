package org.cs202.entity.concretes;

import java.util.Date;

public class Book {

    private int id;

    private Date dayStart;

    private int dayEnd;

    private double price;

    private Room room;

    private User user;

    public Book() {
    }

    public Book(Date dayStart, int dayEnd, double price, Room room, User user) {
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.price = price;
        this.room = room;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", dayStart=" + dayStart +
                ", dayEnd=" + dayEnd +
                ", price=" + price +
                ", room=" + room +
                ", user=" + user +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDayStart() {
        return dayStart;
    }

    public void setDayStart(Date dayStart) {
        this.dayStart = dayStart;
    }

    public int getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(int dayEnd) {
        this.dayEnd = dayEnd;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

