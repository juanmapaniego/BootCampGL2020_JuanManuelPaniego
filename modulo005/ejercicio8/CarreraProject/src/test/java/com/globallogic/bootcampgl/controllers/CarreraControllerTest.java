package com.globallogic.bootcampgl.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.globallogic.bootcampgl.model.Carrera;
import com.globallogic.bootcampgl.model.Competidor;
import com.globallogic.bootcampgl.services.CarreraService;

@ExtendWith(MockitoExtension.class)
class CarreraControllerTest {

	private final Long CA_ID = 1L;
	private final String CA_NOMBRE = "TC2000";
	private final String  CA_FECHA = "10-10-10";
	private final Set<Competidor> CA_COMPETIDORES = new HashSet<>();
	private Carrera carrera;
	@InjectMocks
	private CarreraController carreraController;
	@Mock
	private CarreraService carreraService;
	
	@BeforeEach
	void setup() {
		carrera = new Carrera(CA_ID, CA_FECHA, CA_NOMBRE, CA_COMPETIDORES);
	}
	
	@Test
	void testGetCarreras() {
		Mockito.when(carreraService.getCarreras()).thenReturn(new ArrayList<>());
		
		ResponseEntity<List<Carrera>> getted = carreraController.getCarreras(); 
		assertNotNull(getted);
		assertTrue(getted.getStatusCode().equals(HttpStatus.OK));
		
	}

	@Test
	void testGetCarrera() {
		Mockito.when(carreraService.getCarrera(Mockito.anyLong())).thenReturn(carrera);
		
		ResponseEntity<Carrera> getted = carreraController.getCarrera(1L);
		assertNotNull(getted);
		assertEquals(CA_ID, getted.getBody().getId());
	}
	
	@Test
	void testGetCarreraReturnNull() {
		Mockito.when(carreraService.getCarrera(Mockito.anyLong())).thenReturn(null);
		
		ResponseEntity<Carrera> getted = carreraController.getCarrera(1L);
		assertNotNull(getted);
		assertNull(getted.getBody());
	}

	@Test
	void testCreateCarrera() {
		ResponseEntity<String> getted = carreraController.createCarrera(new Carrera());
		assertNotNull(getted);
		assertEquals(HttpStatus.CREATED, getted.getStatusCode());
	}

	@Test
	void testUpdateCarrera() {
		assertNotNull(carreraController.updateCarrera(1L, new Carrera()));
	}

	@Test
	void testRemoveCarrera() {
		assertNotNull(carreraController.removeCarrera(1L));
	}

	@Test
	@DisplayName("Should throw an exception")
	void testException(){
		Mockito.when(carreraService.getCarrera(Mockito.anyLong())).thenThrow(RuntimeException.class);
	
		assertThrows(RuntimeException.class, () -> carreraController.getCarrera(1L));
	}
}
