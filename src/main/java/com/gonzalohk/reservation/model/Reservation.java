package com.gonzalohk.reservation.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "reservation" )
public class Reservation {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator( name = "system-uuid", strategy = "uuid2")
	private String idReservation;
	@Temporal(TemporalType.DATE)
	private Date dateReservationIn;
	@Temporal(TemporalType.DATE)
	private Date dateReservationOut;
	private int quantityPeople;
	private String description;
	@ManyToOne
	@JoinColumn(name = "idClient")
	private Client client;
}
