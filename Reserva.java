package hotel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.execao.DominioExecao;

public class Reserva {
	
	private Integer numero; 
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer numero, Date checkIn, Date checkOut) {
		if (!checkOut.after(checkIn)) {
			throw new DominioExecao ("Data de checkOut não pode ser antes da data de entrada!");
		}
		this.numero = numero;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	protected Integer getNumero() {
		return numero;
	}

	protected void setNumero(Integer numero) {
		this.numero = numero;
	}

	protected Date getCheckIn() {
		return checkIn;
	}

	protected Date getCheckOut() {
		return checkOut;
	}
	
	
	public long duracao() {
		long dif = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
	}
	
	public void dataAtualizada(Date checkIn,  Date checkOut){
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			throw new DominioExecao ( "Datas para atualização tem que ser datas futuras.");
		}
		if (!checkOut.after(checkIn)) {
			throw new DominioExecao ("Data de checkOut não pode ser antes da data de entrada!");
		}
	
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Numero "
				+numero
				+", check-in "
				+sdf.format(checkIn)
				+", check-out "
				+sdf.format(checkOut)
				+", "
				+duracao()
				+" noites";
	}
	
}
