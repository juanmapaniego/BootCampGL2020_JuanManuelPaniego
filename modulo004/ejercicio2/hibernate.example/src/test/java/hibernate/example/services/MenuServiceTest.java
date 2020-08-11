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

import hibernate.example.dao.MenuDao;
import hibernate.example.model.Menu;

@ExtendWith(MockitoExtension.class)
class MenuServiceTest {

	@InjectMocks
	MenuService menuService;
	
	@Mock
	MenuDao menuDao;
	
	@Test
	void testCreateMenu() {
		Mockito.when(menuDao.createMenu(Mockito.any(Menu.class))).thenReturn(true,false);
		
		assertTrue(menuService.createMenu(new Menu()));
		assertFalse(menuService.createMenu(new Menu()));
	}

	@Test
	void testGetMenues() {
		Mockito.when(menuDao.getMenues()).thenReturn(new ArrayList<>(),Arrays.asList(new Menu()));
		
		assertEquals(0, menuService.getMenues().size());
		assertEquals(1, menuService.getMenues().size());
	}

	@Test
	void testGetMenu() {
		Mockito.when(menuDao.getMenu(1L)).thenReturn(null,new Menu(1L,"Milanesa","",100.0));
		
		assertNull(menuService.getMenu(1L));
		Menu menuTest = menuService.getMenu(1L);
		assertNotNull(menuTest);
		assertEquals("Milanesa", menuTest.getNombre());
	}

	@Test
	void testUpdateMenu() {
		Mockito.when(menuDao.updateMenu(Mockito.any(Menu.class))).thenReturn(true, false);
		
		assertTrue(menuService.updateMenu(new Menu()));
		assertFalse(menuService.updateMenu(new Menu()));
	}

	@Test
	void testRemoveMenu() {
		Mockito.when(menuDao.updateMenu(Mockito.any(Menu.class))).thenReturn(true, false);
		
		assertTrue(menuService.updateMenu(new Menu()));
		assertFalse(menuService.updateMenu(new Menu()));
	}

}
