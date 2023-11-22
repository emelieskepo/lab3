import org.junit.Test;
import static org.junit.Assert.*;

public class TruckTest {

    private Scania scania = new Scania();




    @Test
    public void scaniaIsPlatformUp() {
        scania.setCurrentSpeed(0);
        assertEquals(false, scania.getIsLiftUp());
    }

    @Test
    public void scaniaGasWhenIsPlatformUp(){
        scania.setIsLiftUp(true);
        double initialSpeed = scania.getCurrentSpeed();
        scania.gas(0.1);
        assertEquals(initialSpeed, scania.getCurrentSpeed(), 0.0001);
    }

    @Test
    public void scaniaBrakeWhenIsPlatformUp(){
        scania.setCurrentSpeed(20);
        double initialSpeed = scania.getCurrentSpeed();
        scania.setIsLiftUp(true);
        scania.brake(0.8);
        assertEquals(initialSpeed, scania.getCurrentSpeed(), 0.0001);
    }

    @Test
    public void scaniaIsMoving(){
        scania.setCurrentSpeed(10);
        assertTrue(scania.isMoving());
    }

    @Test
    public void scaniaSpeedFactor(){
        assertEquals(500, scania.getEnginePower(), 0.001);


    }


}
