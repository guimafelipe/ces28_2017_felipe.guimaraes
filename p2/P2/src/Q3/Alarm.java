package Q3;

public class Alarm{
    private final double LowPressureThreshold = 17;
    private final double HighPressureThreshold = 21;
    
    Alarm(ISensor _sensor){
    	sensor = _sensor;
    }
    
    ISensor sensor;

    boolean alarmOn = false;

    public void check(){
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue){
            alarmOn = true;
        }
    }

    public boolean isAlarmOn(){
        return alarmOn; 
    }
}