package com.globallogic.bootcampgl.services.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.globallogic.bootcampgl.model.Carrera;
import com.globallogic.bootcampgl.model.Competidor;
import com.globallogic.bootcampgl.repositories.CarreraRepository;

@ExtendWith(MockitoExtension.class)
class CarreraServiceImplTest {

	private final Long CA_ID = 1L;
	private final String CA_NOMBRE = "TC2000";
	private final String  CA_FECHA = "10-10-10";
	private final Set<Competidor> CA_COMPETIDORES = new HashSet<>();
	private Carrera carrera;
	@InjectMocks
	CarreraServiceImpl carreraService;
	@Mock
	CarreraRepository carreraRepository;

	@BeforeEach
	void setup() {
		carrera = new Carrera(CA_ID, CA_FECHA, CA_NOMBRE, CA_COMPETIDORES);
	}
	@Test
	void testGetCarreras() {
		Mockito.when(carreraRepository.findAll()).thenReturn(new ArrayList<>(), Arrays.asList(carrera));

		assertNotNull(carreraService.getCarreras());
		
		List<Carrera> getted = carreraService.getCarreras();
		assertFalse(getted.isEmpty());
		assertEquals(CA_ID, getted.get(0).getId());
	}

	@Test
	void testGetCarrera() {
		Mockito.when(carreraRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(carrera));
		
		Carrera getted = carreraService.getCarrera(1L);
		assertNotNull(getted);
		assertTrue(getted.getCompetidores().isEmpty());
		assertEquals(CA_NOMBRE, getted.getNombre());
		
		
	}

	@Test
	void testCreateCarrera() {
		carreraService.createCarrera(new Carrera());

		Mockito.verify(carreraRepository).save(Mockito.any(Carrera.class));
	}

	@Test
	void testUpdateCarrera() {
		carreraService.updateCarrera(new Carrera());

		Mockito.verify(carreraRepository).save(Mockito.any(Carrera.class));
	}

	@Test
	void testRemoveCarrera() {
		carreraService.removeCarrera(1L);
		
		Mockito.verify(carreraRepository).deleteById(Mockito.anyLong());
	}
	
	@ParameterizedTest
	@ValueSource(longs = {1, 2, 3})
	void getCarreraParametrized(long id) {
		Mockito.when(carreraRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(carrera));
	
		assertEquals(CA_ID, carreraService.getCarrera(id).getId());
	}

}
