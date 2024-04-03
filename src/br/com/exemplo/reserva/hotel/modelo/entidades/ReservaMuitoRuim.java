package br.com.exemplo.reserva.hotel.modelo.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ReservaMuitoRuim {
	
	
	private Integer numeroQuarto;
	
	private Date checkIn;
	
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public ReservaMuitoRuim(Integer numeroQuarto, Date checkin, Date checkout) {
		this.numeroQuarto = numeroQuarto;
		this.checkOut = checkin;
		this.checkIn = checkout;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckin() {
		return checkOut;
	}


	public Date getCheckout() {
		return checkIn;
	}

	
	public Long duracao() {
		long diff = checkIn.getTime() - checkOut.getTime();
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);		
	}
	
	public void datasAtualizadas(Date checkIn, Date checkOut) {
		
		Date agora = new Date();
		if (checkIn.before(agora) || checkOut.before(agora)) {
			System.out.println("Para atualizar a data da reserva, ela deve ser um data futura"); 
		}
		if(!checkOut.after(checkIn)) {
			System.out.println("A data de check-out, deve ser posterior a data de check-in");
			
		this.checkOut = checkIn;
		this.checkOut = checkOut;
	}
	}
	
	@Override
	public String toString () {
		return "Reserva: Quarto "
				+ numeroQuarto
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut) 
				+ ", "
				+ duracao()
				+" noites";
	
}
}
