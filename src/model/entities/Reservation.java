package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // converter para exibição certa

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
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
        long diff = checkOut.getTime() - checkIn.getTime(); // mili segundos getTime
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // converte segundos em dias

    }

    public String UpdateDates(Date checkIn, Date checkOut) {
        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)) {
            return "As datas na reserva para atualização devem ser datas futuras.";

        }
        if (!checkOut.after(checkIn)) {
            return "Erro na reserva: O check-out deve ser depois do check-in.";

        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        return null;
    }


    @Override // metodo to string!
    public String toString() {
        return " Room "
                + roomNumber
                + ", check-in: "
                + sdf.format(checkIn)
                + ", check-out: "
                + sdf.format(checkOut)
                + ", "
                + duration()
                + "Noites";

    }


}