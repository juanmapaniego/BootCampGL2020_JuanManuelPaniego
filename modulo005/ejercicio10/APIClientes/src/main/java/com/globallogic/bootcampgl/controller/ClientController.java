package com.globallogic.bootcampgl.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.bootcampgl.dto.ClientDTO;
import com.globallogic.bootcampgl.dto.OperationErrorDTO;
import com.globallogic.bootcampgl.dto.OperationReadOneResponseDTO;
import com.globallogic.bootcampgl.dto.OperationReadResponseDTO;
import com.globallogic.bootcampgl.dto.OperationResponseDTO;
import com.globallogic.bootcampgl.entities.Client;
import com.globallogic.bootcampgl.services.ClientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/clients")
@Api(tags = { "Client" })
public class ClientController {

	@Autowired
	private ClientService clientService;

	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = OperationReadResponseDTO.class),
			@ApiResponse(code = 404, message = "NOT FOUND", response = OperationErrorDTO.class),
			@ApiResponse(code = 500, message = "INTERNAL SERVER ERROR", response = OperationErrorDTO.class) })
	@GetMapping
	public ResponseEntity<Object> getAll(@RequestParam(name = "firstName", required = false) final String firstName,

			@RequestParam(name = "lastName", required = false) final String lastName,

			@RequestParam(name = "mail", required = false) final String mail) {
		OperationReadResponseDTO op = (OperationReadResponseDTO) clientService.getAll(firstName, lastName, mail);
		op.getClients().forEach(c -> {
			c.add(linkTo(methodOn(ClientController.class).getAll(c.getFirsrName(), c.getLastName(), c.getMail())).withSelfRel());
			c.add(linkTo(methodOn(ClientController.class).getOneById(c.getDni())).withSelfRel());
		});
		return ResponseEntity.ok(op);
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = OperationReadResponseDTO.class),
			@ApiResponse(code = 404, message = "NOT FOUND", response = OperationErrorDTO.class),
			@ApiResponse(code = 500, message = "INTERNAL SERVER ERROR", response = OperationErrorDTO.class) })
	@GetMapping(value = "/{dni}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Object> getOneById(@PathVariable final Long dni) {
		OperationReadOneResponseDTO op = (OperationReadOneResponseDTO) clientService.getOneById(dni);
		ClientDTO clientDTO = op.getClient();
		clientDTO.add(
				linkTo(methodOn(ClientController.class).getAll(clientDTO.getFirsrName(), clientDTO.getLastName(), clientDTO.getMail())).withSelfRel()
				);
		return ResponseEntity.ok(op);
	}

	/*
	 * public ResponseEntity<Object> getOneById(@PathVariable final Long dni){
	 * ClientDTO clientDTO = ClientDTO.builder().dni(dni).build(); clientDTO.add(
	 * linkTo(methodOn(ClientController.class).getAll("juan", "manuel",
	 * "juanma@gmail.com")).withSelfRel() ); return ResponseEntity.ok(clientDTO); }
	 */

	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = OperationResponseDTO.class),
			@ApiResponse(code = 404, message = "Not Found", response = OperationErrorDTO.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = OperationErrorDTO.class) })
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createOneClient(@RequestBody final ClientDTO client) {
		clientService.createOneClient(client);
		return ResponseEntity.created(null).body("Client created");
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = OperationResponseDTO.class),
			@ApiResponse(code = 404, message = "Not Found", response = OperationErrorDTO.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = OperationErrorDTO.class) })
	@PutMapping(value = "/{dni}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateClient(@PathVariable final Long dni, @RequestBody final Client client) {
		clientService.updateClient(dni, client);
		return ResponseEntity.ok("Client updated");
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = OperationResponseDTO.class),
			@ApiResponse(code = 404, message = "Not Found", response = OperationErrorDTO.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = OperationErrorDTO.class) })
	@DeleteMapping(value = "/{dni}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> removeClient(@PathVariable final Long dni) {
		clientService.removeClient(dni);
		return ResponseEntity.ok("Client removed");
	}

}
