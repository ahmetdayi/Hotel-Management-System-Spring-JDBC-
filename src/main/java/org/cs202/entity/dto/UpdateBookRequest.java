package org.cs202.entity.dto;

import java.util.Date;

public class UpdateBookRequest {

    private int id;

    private Date dayStart;

    private int dayEnd;

    private double price;

    public UpdateBookRequest(int id, Date dayStart, int dayEnd, double price) {
        this.id = id;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.price = price;
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

    @Override
    public String toString() {
        return "UpdateBookRequest{" +
                "id=" + id +
                ", dayStart=" + dayStart +
                ", dayEnd=" + dayEnd +
                ", price=" + price +
                '}';
    }
}
