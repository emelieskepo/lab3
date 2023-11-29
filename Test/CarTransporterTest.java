import org.junit.Test;
import java.awt.*;
import static org.junit.Assert.*;

public class CarTransporterTest {

    private CarTransporter carTransporter = new CarTransporter();
    private Saab95 carToLoad = new Saab95(); //4.8
    private Volvo240 secondCarToLoad = new Volvo240(); //4.9
    private Volvo240 thirdCarToLoad = new Volvo240(); //4.9
    private Volvo240 forthCartoLoad = new Volvo240(); //4.9
    private Volvo240 fifthCarToLoad = new Volvo240(); //4.9

    @Test
    public void testLowerRampWhenNotMoving(){
        carTransporter.lowerRamp();
        assertTrue(carTransporter.getIsLiftUp());
    }

    @Test
    public void lowerRampWhenMoving(){
        carTransporter.setCurrentSpeed(20);
        carTransporter.lowerRamp();
        assertFalse(carTransporter.getIsLiftUp());
    }

    @Test
    public void loadCarOnCarTransporter(){

        carTransporter.lowerRamp();
        assertTrue(carTransporter.getIsLiftUp());
        assertFalse(carTransporter.isMoving());

        carTransporter.loadCar(carToLoad);
        assertFalse(carTransporter.getLoadedCars().contains(carToLoad));

        assertEquals(carTransporter.getXPos(), carToLoad.getXPos(), 0.001);
        assertEquals(carTransporter.getYPos(), carToLoad.getYPos(), 0.001);
        assertEquals(carTransporter.getDirection(), carToLoad.getDirection());
    }

    @Test
    public void loadCarOnFullCarTransporter(){
        carTransporter.lowerRamp();
        carTransporter.loadCar(carToLoad);
        carTransporter.loadCar(secondCarToLoad);
        carTransporter.loadCar(thirdCarToLoad);
        carTransporter.loadCar(forthCartoLoad);
        carTransporter.loadCar(fifthCarToLoad);
        assertTrue(carTransporter.isCarTheRightSize(fifthCarToLoad));
        assertFalse(carTransporter.getLoadedCars().contains(fifthCarToLoad));
    }

    @Test
    public void unloadCarOnCarTransporter(){
        carTransporter.loadCar(carToLoad);
        carTransporter.unloadCar();
        assertTrue(carTransporter.getLoadedCars().isEmpty());
        assertEquals(carTransporter.getXPos()+1, carToLoad.getXPos(), 0.001);
        assertEquals(carTransporter.getYPos()+1, carToLoad.getYPos(), 0.001);
        assertEquals(carTransporter.getDirection(), carToLoad.getDirection());
    }
}