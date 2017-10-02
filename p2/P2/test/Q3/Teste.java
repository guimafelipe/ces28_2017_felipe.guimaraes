package Q3;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.any;

public class Teste {
	
	Alarm alarm;
	
	@Test
	public void TestIfAlarmDontTurnOnIfOkPressure(){
		ISensor sensordummy = mock(ISensor.class);
		when(sensordummy.popNextPressurePsiValue()).thenReturn(20.0);
		alarm = new Alarm(sensordummy);
		alarm.check();
		assertFalse(alarm.isAlarmOn());
	}
	
	@Test
	public void TestIfAlarmTurnOnIfHighPressure(){
		ISensor sensordummy = mock(ISensor.class);
		when(sensordummy.popNextPressurePsiValue()).thenReturn(22.0);
		alarm = new Alarm(sensordummy);
		alarm.check();
		assertTrue(alarm.isAlarmOn());
	}
	
	@Test
	public void TestIfAlarmTurnOnIfLowPressure(){
		ISensor sensordummy = mock(ISensor.class);
		when(sensordummy.popNextPressurePsiValue()).thenReturn(16.0);
		alarm = new Alarm(sensordummy);
		alarm.check();
		assertTrue(alarm.isAlarmOn());
	}
}
