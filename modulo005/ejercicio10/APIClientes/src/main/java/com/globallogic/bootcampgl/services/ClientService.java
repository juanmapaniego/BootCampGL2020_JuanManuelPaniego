package com.globallogic.bootcampgl.services;

import com.globallogic.bootcampgl.dto.ClientDTO;
import com.globallogic.bootcampgl.dto.OperationResponseDTO;
import com.globallogic.bootcampgl.entities.Client;

public interface ClientService {
	OperationResponseDTO getAll(String firstName, String lastName, String mail);
	OperationResponseDTO getOneById(Long dni);
	OperationResponseDTO createOneClient(ClientDTO client);
	OperationResponseDTO updateClient(Long dni, Client client);
	OperationResponseDTO removeClient(Long dni);
}
