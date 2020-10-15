package com.gonzalohk.reservation.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "client" )
@NamedQuery(name = "Client.findByPhone", query = "SELECT c FROM Client c WHERE c.phone= ?1")
public class Client {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator( name = "system-uuid", strategy = "uuid2")
	private String idClient;
	private String name;
	private String lastname;	
	private String address;
	private String phone;
	private String email;
	
	@OneToMany(mappedBy = "client")
	private Set<Reservation> reservations;
	
	public Client() {
		
	}
}
