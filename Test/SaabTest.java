import org.junit.Test;
import static org.junit.Assert.*;

public class SaabTest {
    public Saab95 saab = new Saab95();

    @Test
    public void setTurboOnSaab(){
        // Testar att sätta turbo-läget på Saab95 och kontrollera att det är på
        saab.setTurboOn();
        assertTrue(saab.isTurboOn());
    }


    @Test
    public void saabEnginePower(){
        assertEquals(125, saab.getEnginePower(), 0.0001);
    }

    @Test
    public void saabSetTurboOff(){
        saab.setTurboOff();
        assertFalse(saab.isTurboOn());
    }
    @Test
    public void saabCheckSpeedFactorWithTurboOff(){
        assertEquals(saab.getEnginePower() * 0.01 * 1, saab.speedFactor(), 0.0001);

    }
    @Test
    public void incrementSpeedForSaabIfTurboOn(){
        saab.setTurboOn();
        saab.incrementSpeed(10);
        assertEquals(saab.getEnginePower() * 0.01 * 1.3 * 10, saab.getCurrentSpeed(), 0.0001);
    }

    @Test
    public void decrementSpeedForSaab(){
        saab.setCurrentSpeed(50);
        double originalSpeed = saab.getCurrentSpeed();
        saab.decrementSpeed(10);
        assertEquals(originalSpeed - saab.speedFactor() * 10, saab.getCurrentSpeed(), 0.0001);

    }
}
