package mockito.example;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import mockito.example.model.Vehicle;

@ExtendWith(MockitoExtension.class)
class VehicleCrashTest {

	@Mock 
	Vehicle vehicleMock;
	
	@Test
	void WhenNoCrashNoValueThenOk() {
		VehicleCrash crashTest = new VehicleCrash();
		
		assertEquals(0, crashTest.getTotalEnergy());
		assertEquals(0, crashTest.getTotalVehicles());
		assertEquals("No crashes measured",crashTest.toString());
	}

	@Test
	void WhenCrashAndCorrectValueThenOk() {
		VehicleCrash crashTest = new VehicleCrash();
		
		Mockito.when(vehicleMock.getMass()).thenReturn(10.0);
		Mockito.when(vehicleMock.getMaxSpeed()).thenReturn(5.0);
		
		crashTest.crash(vehicleMock);
	}

}
