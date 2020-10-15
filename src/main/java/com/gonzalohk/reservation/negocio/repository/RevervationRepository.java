package com.gonzalohk.reservation.negocio.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gonzalohk.reservation.model.Reservation;

public interface RevervationRepository extends JpaRepository<Reservation, String>{

	//@Query("Select r from Reserva r where r.client =:client")
	//public List<Reservation> findByCliente(Client cliente);
	
	@Query("SELECT r FROM Reservation r where r.dateReservationIn=:dateIn and r.dateReservationOut = :dateOut")
	public List<Reservation> find(@Param("dateIn") Date dateIn, @Param("dateOut") Date dateOut);
}
