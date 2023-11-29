import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CarTransporter extends Truck{

    private List<Car> loadedCars;

    public CarTransporter() {
        super(2, 500, Color.green, 20.0, false);
        this.loadedCars = new ArrayList<>();
    }

    public List<Car> getLoadedCars() {
        return new ArrayList<>(loadedCars);
    }

    public void lowerRamp() { //sänk rampen mot marken så att bil kan köra på
        if (!isMoving()) {
            setIsLiftUp(true);
        } else {
            setIsLiftUp(false); // om vi kör så måste rampen vara uppe
        }
    }

    public boolean isCarTheRightSize(Car car) {
        if (car.getSize() < 5) {
            double carTransportSize = getSize();
            for (Car loadedCar : loadedCars) {
                carTransportSize -= loadedCar.getSize();
            }
            return carTransportSize >= car.getSize();
        }
        return false;
    }

    private boolean isCarClose(Car car) {
        double maxDistance = 3.0;
        double distanceX = getXPos() - car.getXPos();
        double distanceY = getYPos() - car.getYPos();
        double distance = Math.sqrt(Math.pow((distanceX), 2) + Math.pow((distanceY), 2));
        return distance <= maxDistance;
    }

    public void loadCar(Car car) {
        if (!getIsLiftUp() && isCarClose(car) && isCarTheRightSize(car)) {
            loadedCars.add(car);
            car.setPosition(getXPos(), getYPos(),getDirection());
        }
    }

    public void unloadCar() {
        if (!getIsLiftUp() && !loadedCars.isEmpty()) {
            Car lastCar = loadedCars.remove(loadedCars.size() - 1);
            lastCar.setPosition((getXPos() + 1), (getYPos() + 1), getDirection());
        }
    }

}