package hibernate.example.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import hibernate.example.dao.CarreraDao;
import hibernate.example.model.Carrera;

@ExtendWith(MockitoExtension.class)
class CarreraServiceTest {
	@InjectMocks
	CarreraService carreraService;
	
	@Mock
	CarreraDao carreraDao;
	
	@Test
	void testCreateCarrera() {
		Mockito.when(carreraDao.createCarrera(Mockito.any(Carrera.class))).thenReturn(true,false);
		
		assertTrue(carreraService.createCarrera(new Carrera()));
		assertFalse(carreraService.createCarrera(new Carrera()));
	}

	@Test
	void testGetCarreras() {
		Mockito.when(carreraDao.getCarreras()).thenReturn(new ArrayList<>(), Arrays.asList(new Carrera()));
		
		assertEquals(0, carreraService.getCarreras().size());
		assertEquals(1, carreraService.getCarreras().size());
	}

	@Test
	void testGetCarrera() {
		Mockito.when(carreraDao.getCarrera(Mockito.anyLong())).thenReturn(null, new Carrera());
		
		assertThrows(IllegalArgumentException.class,() -> carreraService.getCarrera(1L) ); 
		assertNotNull(carreraService.getCarrera(1L));
	}

	@Test
	void testUpdateCarrera() {
		Mockito.when(carreraDao.updateCarrera(Mockito.any(Carrera.class))).thenReturn(true, false);
		
		assertTrue(carreraService.updateCarrera(new Carrera()));
		assertFalse(carreraService.updateCarrera(new Carrera()));
	}

	@Test
	void testRemoveCarrera() {
		Mockito.when(carreraDao.removeCarrera(Mockito.any(Carrera.class))).thenReturn(true, false);
		
		assertTrue(carreraService.removeCarrera(new Carrera()));
		assertFalse(carreraService.removeCarrera(new Carrera()));
	}

}
