package com.gonzalohk.reservation.view.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gonzalohk.reservation.model.Client;
import com.gonzalohk.reservation.negocio.services.ClientService;
import com.gonzalohk.reservation.view.resource.vo.ClientVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/client")
@Api(tags = "client")
public class ClientResource {
	private final ClientService clientService;

	public ClientResource(ClientService clientService) {
		this.clientService = clientService;
	}

	@PostMapping
	@ApiOperation(value = "Create client", notes = "Service to create new client")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Client created properly"),
			@ApiResponse(code = 400, message = "Invalid request") })
	public ResponseEntity<Client> createClient(@RequestBody ClientVO clientVO) {
		Client client = new Client();
		client.setName(clientVO.getName());
		client.setLastname(clientVO.getLastname());
		client.setAddress(clientVO.getAddress());
		client.setPhone(clientVO.getPhone());
		client.setEmail(clientVO.getEmail());
		return new ResponseEntity<>(this.clientService.create(client), HttpStatus.CREATED);

	}

	@PutMapping("/{phone}")
	@ApiOperation(value = "Update client", notes = "Service to update a client")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Client updated properly"),
			@ApiResponse(code = 400, message = "Invalid request") })	
	public ResponseEntity<Client> updateClient(@PathVariable("phone") String phone, ClientVO clientVO) {
		Client client = this.clientService.findByPhone(phone);
		if (client == null) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		} else {
			client.setName(clientVO.getName());
			client.setLastname(clientVO.getLastname());
			client.setAddress(clientVO.getAddress());
			client.setPhone(clientVO.getPhone());
			client.setEmail(clientVO.getEmail());
		}
		return new ResponseEntity<>(this.clientService.update(client), HttpStatus.OK);
	}

	@DeleteMapping("/{phone}")
	public void removeClient(@PathVariable("phone") String phone) {
		Client client = this.clientService.findByPhone(phone);
		if (client != null) {
			this.clientService.delete(client);
		}
	}

	@GetMapping
	public ResponseEntity<List<Client>> findAll() {
		return ResponseEntity.ok(this.clientService.findAll());
	}
}
