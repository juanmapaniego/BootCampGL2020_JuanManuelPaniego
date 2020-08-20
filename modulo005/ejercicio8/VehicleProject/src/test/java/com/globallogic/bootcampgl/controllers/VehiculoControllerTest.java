package com.globallogic.bootcampgl.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.globallogic.bootcampgl.model.Vehiculo;
import com.globallogic.bootcampgl.services.VehiculoService;


@ExtendWith(MockitoExtension.class)
class VehiculoControllerTest {
	private Vehiculo vehiculo;
	@Mock
	private VehiculoService vehiculoService;
	@InjectMocks
	private VehiculoController vehiculoController;
	
	@BeforeEach
	void setup() {
		vehiculo = Vehiculo.builder()
				.identificacion("AA")
				.codigo(1L)
				.build();
	}
	
	@Test
	@DisplayName("Expect get all data")
	void testGetAll() {
		Mockito.when(vehiculoService.getVehiculos()).thenReturn(new ArrayList<>(), Arrays.asList(vehiculo)); 
		assertNotNull(vehiculoController.getAll());
		List<Vehiculo> test = vehiculoController.getAll().getBody();
		assertFalse(test.isEmpty());
		assertEquals(1L, test.get(0).getCodigo());
	}
	
	@Test
	@DisplayName("Expect one vehicle")
	void testGetOne() {
		Mockito.when(vehiculoService.getVehiculo(Mockito.anyLong())).thenReturn(vehiculo); 
		assertEquals(1L, vehiculoController.getOne(1L).getBody().getCodigo());
	}

	@Test
	@DisplayName("Expect create one vehicle")
	void testCreate() {
		vehiculoController.create(Vehiculo.builder().build());
		Mockito.verify(vehiculoService).createVehiculo(Mockito.any());
	}

	@Test
	@DisplayName("Expect update one vehicle")
	void testUpdate() {
		vehiculoController.update(1L,Vehiculo.builder().build());
		Mockito.verify(vehiculoService).updateVehiculo(Mockito.any());
	}

	@Test
	@DisplayName("Expect remove one vehicle")
	void testRemove() {
		vehiculoController.remove(1L);
		Mockito.verify(vehiculoService).removeVehiculo(Mockito.anyLong());
	}

	@Test
	@DisplayName("Should throw an exception")
	void testException(){
		Mockito.when(vehiculoService.getVehiculo(Mockito.anyLong())).thenThrow(RuntimeException.class);
	
		assertThrows(RuntimeException.class, () -> vehiculoController.getOne(1L));
	}

}
