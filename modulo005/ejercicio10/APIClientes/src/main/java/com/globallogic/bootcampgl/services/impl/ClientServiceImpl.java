package com.globallogic.bootcampgl.services.impl;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.bootcampgl.controller.ClientController;
import com.globallogic.bootcampgl.dto.ClientDTO;
import com.globallogic.bootcampgl.dto.DirectionDTO;
import com.globallogic.bootcampgl.dto.OperationErrorDTO;
import com.globallogic.bootcampgl.dto.OperationReadOneResponseDTO;
import com.globallogic.bootcampgl.dto.OperationReadResponseDTO;
import com.globallogic.bootcampgl.dto.OperationResponseDTO;
import com.globallogic.bootcampgl.entities.Client;
import com.globallogic.bootcampgl.entities.Direction;
import com.globallogic.bootcampgl.repositories.ClientRepository;
import com.globallogic.bootcampgl.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	private static final String OK_CREATE_MESSAGE = "Client succesfully created";
	private static final String NOT_OK_CREATE_MESSAGE = "Can not create client";
	private static final int NOT_OK_CREATE_CODE = 100;

	private static final String OK_UPDATE_MESSAGE = "Client succesfully modified";
	private static final String NOT_OK_UPDATE_MESSAGE = "Can not modify client";
	private static final int NOT_OK_UPDATE_CODE = 200;

	private static final String OK_DELETE_MESSAGE = "Client succesfully deleted";
	private static final String NOT_OK_DELETE_MESSAGE = "Can not delete client";
	private static final int NOT_OK_DELETE_CODE = 300;

	private static final String OK_READ_MESSAGE = "Client succesfully read";
	private static final String NOT_OK_READ_MESSAGE = "Can not access to clients";
	private static final int NOT_OK_READ_CODE = 400;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public OperationResponseDTO getAll(String firstName, String lastName, String mail) {
		Collection<Client> clients;
		try{
			if((Objects.nonNull(firstName))
					||(Objects.nonNull(lastName))
					||(Objects.nonNull(mail))) {
				clients = clientRepository.findByFirstNameOrLastNameOrMail(firstName, lastName, mail);
			}else {
				clients = clientRepository.findAll();
			}
			
		}catch (Exception e) {
			return OperationErrorDTO.operationErrorDTOBuilder().message(NOT_OK_READ_MESSAGE)
					.errorCode(NOT_OK_READ_CODE).build();
		}
		
		return OperationReadResponseDTO.operationReadResponseDTOBuilder().message(OK_READ_MESSAGE)
				.clients(clientCollectionToDto(clients)).build();
	}

	
	@Override
	public OperationResponseDTO getOneById(Long dni) {
		Client client;
		try{
			client = clientRepository.findById(dni).orElseThrow(() -> new RuntimeException("DNI not found"));
		}catch (Exception e) {
			return OperationErrorDTO.operationErrorDTOBuilder().message(NOT_OK_READ_MESSAGE)
					.errorCode(NOT_OK_READ_CODE).build();
		}
		ClientDTO clientDTO = clientToDto(client);
		return OperationReadOneResponseDTO.operationReadOneResponseDTOBuilder().message(OK_READ_MESSAGE)
				.client(clientDTO).build();
	}

	@Override
	public OperationResponseDTO createOneClient(ClientDTO client) {
		try{
			Client saved = clientRepository.save(dtoToClient(client));
		}catch (Exception e) {
			return OperationErrorDTO.operationErrorDTOBuilder().message(NOT_OK_CREATE_MESSAGE)
					.errorCode(NOT_OK_CREATE_CODE).build();
		}
		return OperationResponseDTO.builder().message(OK_CREATE_MESSAGE).build();
	}

	@Override
	public OperationResponseDTO updateClient(Long dni, Client client) {
		Client fromDB = clientRepository.findById(dni).orElseThrow(() -> new RuntimeException("Can not update"));
		
		try {
			fromDB.setFirstName(client.getFirstName());
			fromDB.setLastName(client.getLastName());
			fromDB.setMail(client.getMail());
			fromDB.setPhone(client.getPhone());
			
			clientRepository.save(fromDB);
		}catch (Exception e) {
			return OperationErrorDTO.operationErrorDTOBuilder().message(NOT_OK_UPDATE_MESSAGE)
					.errorCode(NOT_OK_UPDATE_CODE).build();
		}
		return OperationResponseDTO.builder().message(OK_UPDATE_MESSAGE).build();
	}

	@Override
	public OperationResponseDTO removeClient(Long dni) {
		try{
			clientRepository.deleteById(dni);
		}catch (Exception e) {
			return OperationErrorDTO.operationErrorDTOBuilder().message(NOT_OK_DELETE_MESSAGE)
					.errorCode(NOT_OK_DELETE_CODE).build();
		}
		return OperationResponseDTO.builder().message(OK_DELETE_MESSAGE).build();
	}
	
	
	private Collection<ClientDTO> clientCollectionToDto(Collection<Client> clients) {
		return clients.stream().map(
				c -> clientToDto(c)
				).collect(Collectors.toList());		
	}

	private ClientDTO clientToDto(Client c) {
		return ClientDTO.builder()
				.dni(c.getDni())
				.firsrName(c.getFirstName())
				.lastName(c.getLastName())
				.phone(c.getPhone())
				.mail(c.getMail())
				.directions(directionListToDto(c.getDirections()))
				.build();
	}
	
	private List<DirectionDTO> directionListToDto(List<Direction> directions) {
		return directions.stream().map(
				d -> directionToDto(d)
				).collect(Collectors.toList());		
	}
	
	private DirectionDTO directionToDto(Direction d) {
		return DirectionDTO.builder()
				.city(d.getCity())
				.prov(d.getProv())
				.number(d.getNumber())
				.street(d.getStreet())
				.build();
		
	}
	
	private Client dtoToClient(ClientDTO dto) {
		return Client.builder()
					.firstName(dto.getFirsrName())
					.lastName(dto.getLastName())
					.dni(dto.getDni())
					.mail(dto.getMail())
					.phone(dto.getPhone())
					.directions(mapDtoToDirection(dto.getDirections()))
					.build();
	}


	private List<Direction> mapDtoToDirection(List<DirectionDTO> dtos) {
		return dtos.stream().map(d -> dtoToDirection(d)).collect(Collectors.toList());
	}
	
	private Direction dtoToDirection(DirectionDTO dto) {
		return Direction.builder()
				.street(dto.getStreet())
				.number(dto.getNumber())
				.city(dto.getCity())
				.prov(dto.getProv())
				.build();
	}

}
