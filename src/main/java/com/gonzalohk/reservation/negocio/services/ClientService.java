package com.gonzalohk.reservation.negocio.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gonzalohk.reservation.model.Client;
import com.gonzalohk.reservation.negocio.repository.ClientRepository;

@Service
@Transactional(readOnly = true)
public class ClientService {
	private final ClientRepository clientRepository;

	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	// Insert
	@Transactional
	public Client create(Client client) {
		return this.clientRepository.save(client);
	}

	// Update
	@Transactional
	public Client update(Client client) {
		return this.clientRepository.save(client);
	}

	// Delete
	@Transactional
	public void delete(Client client) {
		this.clientRepository.delete(client);
	}

	// findByPhone
	public Client findByPhone(String phone) {
		return this.clientRepository.findByPhone(phone);
	}

	public List<Client> findAll(){
		return this.clientRepository.findAll();
	}
}
