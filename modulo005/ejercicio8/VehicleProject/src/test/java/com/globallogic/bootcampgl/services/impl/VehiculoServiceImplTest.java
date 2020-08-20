package com.globallogic.bootcampgl.services.impl;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.globallogic.bootcampgl.model.Modelo;
import com.globallogic.bootcampgl.model.Tipo;
import com.globallogic.bootcampgl.model.Vehiculo;
import com.globallogic.bootcampgl.repositories.VehiculoRepository;

@ExtendWith(MockitoExtension.class)
class VehiculoServiceImplTest {

	@InjectMocks
	private VehiculoServiceImpl vehiculoService;
	
	@Mock
	private VehiculoRepository vehiculoRepository;
	
	private Vehiculo vehiculo;
	@BeforeEach
	void setup() {
		vehiculo = Vehiculo.builder()
				.codigo(1L)
				.identificacion("AA")
				.fechaProduccion("30-02-20")
				.modelo(Modelo.builder().build())
				.tipo(Tipo.builder().build())
				.build();
	}
	
	@Test
	void testCreateVehiculo() {
		Mockito.when(vehiculoRepository.save(Mockito.any(Vehiculo.class))).thenReturn(Mockito.any());
		vehiculoService.createVehiculo(Vehiculo.builder().build());
		
		Mockito.verify(vehiculoRepository).save(Vehiculo.builder().build());
	}

	@Test
	void testGetVehiculos() {
		Mockito.when(vehiculoRepository.findAll()).thenReturn(new ArrayList<>(), Arrays.asList(vehiculo));
		assertNotNull(vehiculoService.getVehiculos());
		assertTrue(vehiculoService.getVehiculos().get(0).getCodigo().equals(1L));
		
	}

	@Test
	void testGetVehiculo() {
		Mockito.when(vehiculoRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(vehiculo));
		Vehiculo getted = vehiculoService.getVehiculo(1L);
		assertNotNull(getted);
		assertEquals("AA", getted.getIdentificacion());
	}

	@Test
	void testUpdateVehiculo() {
		Mockito.when(vehiculoRepository.save(Mockito.any(Vehiculo.class))).thenReturn(Mockito.any());
		vehiculoService.createVehiculo(Vehiculo.builder().build());
		
		Mockito.verify(vehiculoRepository).save(Vehiculo.builder().build());
	}

	@Test
	void testRemoveVehiculo() {
		vehiculoService.removeVehiculo(1L);
		
		Mockito.verify(vehiculoRepository).deleteById(Mockito.anyLong());
	}
	
	@ParameterizedTest
	@ValueSource(longs = {1, 2, 3})
	void getCarreraParametrized(long id) {
		vehiculo.setCodigo(id);
		Mockito.when(vehiculoRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(vehiculo));
	
		assertEquals(id, vehiculoService.getVehiculo(id).getCodigo());
	}
	

}
