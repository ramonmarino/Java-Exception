package app;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException { // propaga a exceção
       Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // configurar a exibição

       System.out.print("Qual o número do quarto?:");
       int numeroQuarto = input.nextInt();

        System.out.print("Digite a data de entrada do Check-in (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(input.next()); // entrada de data como texto convertido em data
        System.out.print("Digite a data de saida do Check-out (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(input.next());

        if(!checkOut.after(checkIn)){
            System.out.print("Erro na reserva: O check-out deve ser depois do check-in.");

        }else{
            Reservation reserva = new Reservation(numeroQuarto,checkIn,checkOut);
            System.out.println("Reserva:" + reserva);

            System.out.println();
            System.out.println("Entre com as reservas atualizadas: ");
            System.out.print("Digite a data de entrada do Check-in (dd/MM/yyyy): ");
             checkIn = sdf.parse(input.next()); // entrada de data como texto convertido em data
            System.out.print("Digite a data de saida do Check-out (dd/MM/yyyy): ");
             checkOut = sdf.parse(input.next());

             Date now = new Date();
             if(checkIn.before(now) || checkOut.before(now)){
                 System.out.println("Erro na reserva: As datas na reserva para atualização devem ser datas futuras.");

             }else if(!checkOut.after(checkIn)){
                 System.out.print("Erro na reserva: O check-out deve ser depois do check-in.");

             }else{
             reserva.UpdateDates(checkIn,checkOut);
             System.out.println("Reserva:" + reserva);

             }




        }










       input.close();
    }
}
