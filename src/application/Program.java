package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Reservation reservation = new Reservation();
        Scanner sc = new Scanner(System.in);
        System.out.print("Room number: ");
        int roomNumber = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-out date (mm/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());
        if(!checkOut.after(checkIn)){
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }else{
            reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
            }
        System.out.print("Check-in date (dd/MM/yyyy): ");
        checkIn = sdf.parse(sc.next());
        System.out.print("Check-out date (mm/MM/yyyy): ");
        checkOut = sdf.parse(sc.next());
        String error = reservation.updateDate(checkIn, checkOut);
        if(error != null){
            System.out.println("Error in reservation: " + error);
        }else{
            System.out.println("Reservation: " + reservation);
        }
        }



}

