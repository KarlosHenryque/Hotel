package hotel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.execao.DominioExecao;

public class ProgramaHotel {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.println("Numero do quarto:");
			int numero = sc.nextInt();
			System.out.println("Data de Check-in (dd/MM/yyyy)");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("Data de Check-out (dd/MM/yyyy)");
			Date checkOut = sdf.parse(sc.next());
	
	
			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println("Reserva: " +reserva);
			
			System.out.println("\nData de Check-in (dd/MM/yyyy)");
			checkIn = sdf.parse(sc.next());
			System.out.println("Data de Check-out (dd/MM/yyyy)");
			checkOut = sdf.parse(sc.next());
				
			reserva.dataAtualizada(checkIn, checkOut);
				System.out.println("Reserva: "+reserva);
			}
			
			catch(ParseException e){
				System.out.println("Data invalida");
			}
		
			catch(DominioExecao e) {
				System.out.println("Erro na Reserva: "+e.getMessage());
			}
			catch (RuntimeException e){
				System.out.println("Erro inesperado");
			}
		}		
	
}