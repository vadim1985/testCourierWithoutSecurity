package entity;

import java.util.Date;

public class OrderNumber {
    private long number;
    private Date date;

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "OrderNumber{" +
                "number=" + number +
                ", date=" + date +
                '}';
    }
}
