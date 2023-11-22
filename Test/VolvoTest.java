import org.junit.Test;
import static org.junit.Assert.*;


public class VolvoTest {

    private Volvo240 volvo = new Volvo240();

    @Test
    public void volvoCheckSpeedFactor(){
        assertEquals(volvo.getEnginePower() * 0.01 * 1.2, volvo.speedFactor(), 0.001);
    }

    @Test
    public void incrementSpeedForVolvo(){
        volvo.incrementSpeed(10);
        assertEquals(Math.min(volvo.speedFactor() * 10, volvo.getEnginePower()), volvo.getCurrentSpeed(), 0.0001);
    }

    @Test
    public void decrementSpeedForVolvo(){
        volvo.setCurrentSpeed(30);
        double originalSpeed = volvo.getCurrentSpeed();
        volvo.decrementSpeed(10);
        assertEquals(Math.max(originalSpeed - volvo.speedFactor() * 10,0), volvo.getCurrentSpeed(), 0.001);
    }


}