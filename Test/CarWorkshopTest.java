import org.junit.Test;
import static org.junit.Assert.*;

public class CarWorkshopTest {

    //private AllCarsWorkshop workshop = new AllCarsWorkshop();
    //private Saab95Workshop saabWorkshop = new Saab95Workshop();
    //private Volvo240Workshop volvoWorkshop= new Volvo240Workshop();

    private CarWorkshop<Volvo240> volvoWorkshop = new CarWorkshop<>(1);
    private CarWorkshop<Saab95> saabWorkshop = new CarWorkshop<>(1);
    private CarWorkshop<Car> workshop = new CarWorkshop<>(2);

    private Volvo240 volvo = new Volvo240();
    private Volvo240 volvo2 = new Volvo240();
    private Saab95 saab = new Saab95();

    @Test
    public void loadVolvo240InVolvo240Workshop(){
        volvoWorkshop.load(volvo);
        assertTrue(volvoWorkshop.getCarsInWorkshop().contains(volvo));
    }

    @Test
    public void loadSaab95InSaab95Workshop() {
        saabWorkshop.load(saab);
        assertTrue(saabWorkshop.getCarsInWorkshop().contains(saab));
    }

    @Test
    public void loadDifferentCarsInAllCarsWorkshop() {
        workshop.load(volvo);
        workshop.load(saab);
        assertTrue(workshop.getCarsInWorkshop().contains(volvo));
        assertTrue(workshop.getCarsInWorkshop().contains(saab));
    }

    @Test
    public void loadTooManyCarsInAllCarsWorkshop(){
        workshop.load(volvo);
        workshop.load(saab);
        workshop.load(volvo2);
        assertFalse(workshop.getCarsInWorkshop().contains(volvo2));
    }

    @Test
    public void unloadVolvo240fromAllCarWorkshop(){
        workshop.load(volvo);
        workshop.load(saab);
        workshop.unload(volvo);
        assertTrue(workshop.getCarsInWorkshop().contains(saab));
        assertFalse(workshop.getCarsInWorkshop().contains(volvo));
    }

}