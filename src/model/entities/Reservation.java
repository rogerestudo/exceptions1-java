package model.entities;

import model.exceptions.DomainException;

import javax.accessibility.AccessibleKeyBinding;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    public Reservation() {
    }

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException{
        if(validacao(checkIn, checkOut)) {
            this.roomNumber = roomNumber;
            this.checkIn = checkIn;
            this.checkOut = checkOut;
        }
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public long duration() {
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDate(Date checkIn, Date checkOut) throws DomainException {
        if(validacao(checkIn,checkOut)) {
            this.checkIn = checkIn;
            this.checkOut = checkOut;
        }
        }
    public boolean validacao(Date checkIn, Date checkOut) throws DomainException{
        Date now = new Date();
        if(checkIn.before(now) || checkOut.before(now)) {
            throw new DomainException("Reservation dates for update must be future date");
        }
        if(!checkOut.after(checkIn)){
            throw new DomainException("Check-out date must be after check-in date");
        }
        return true;
    }

            @Override
            public String toString () {
                return "Room "
                        + roomNumber
                        + ", checkIn: "
                        + sdf.format(checkIn)
                        + ", checkOut: "
                        + sdf.format(checkOut)
                        + ", "
                        + duration()
                        + " nights";
            }

        }

