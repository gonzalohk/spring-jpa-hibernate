/**
 * 
 */
package com.gonzalohk.reservation.negocio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gonzalohk.reservation.model.Client;

/**
 * Interface
 * @author PC
 *
 */
public interface ClientRepository extends JpaRepository<Client, String>{
	/**
	 * Method to look for client by lastname
	 * @param lastname
	 * @return
	 */
	public List<Client> findByLastname(String lastname);
	
	public Client findByPhone(String phone);
		
	
}
