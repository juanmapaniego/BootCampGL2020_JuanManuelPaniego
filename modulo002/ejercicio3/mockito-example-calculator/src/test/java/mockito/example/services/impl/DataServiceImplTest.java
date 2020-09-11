package mockito.example.services.impl;
import mockito.example.services.DataService;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DataServiceImplTest {
	@Mock 
	DataService dataService;

	@Test
	void test() {
		DataServiceImpl dataServiceImpl = new DataServiceImpl(Arrays.asList(1,2,3,4,5));
		int [] auxList = new int[] {4,5,6,7};
		Mockito.when(dataService.getListOfNumbers()).thenReturn(auxList);
		
		assertNotEquals(auxList.length, dataServiceImpl.getListOfNumbers().length);
		assertEquals(auxList.length, dataService.getListOfNumbers().length);
		
	}

}
