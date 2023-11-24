import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    //ArrayList<Car> cars = new ArrayList<>();
    //ArrayList<Truck> trucks = new ArrayList<>();
    ArrayList<Vehicle> vehicles = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.vehicles.add(new Volvo240()); //cc.vehicles.add(new Volvo240(0,0));
        cc.vehicles.add(new Saab95()); //cc.vehicles.add(new Saab95(0, 100));
        cc.vehicles.add(new Scania()); //cc.vehicles.add(new Scania(0, 200));

        //Satt in Saab95, Scania och deras respektive bilder med 100 pixlars
        //avstand i Y-led fran varandra (alla avbildas ursprungligen med X=0).
        //Koppla turbo-knapparna till Saaben och flakknapparna till Scania.
        //Koppla "starta och stoppa alla bilar"-knapparna till bagge.
        //Aven dessa bilar ska forhindras att aka utanfor rutan.

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : vehicles) {
                double initialSpeed = vehicle.getCurrentSpeed();
                if ( hitWall(vehicle)){
                    vehicle.stopEngine();
                    vehicle.turnRight();
                    vehicle.turnRight();
                    vehicle.startEngine();
                    vehicle.setCurrentSpeed(initialSpeed);
                }
                vehicle.move();
                int x = (int) Math.round(vehicle.getXPos());
                int y = (int) Math.round(vehicle.getYPos());
                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles
        ) {
            vehicle.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles
        ) {
            vehicle.brake(brake);
        }
    }

    boolean hitWall(Vehicle vehicle){
        int screenWidth = 700;
        int screenHeight = 500; //för gröna boxen
        double vehicleXPos = vehicle.getXPos();
        double vehicleYPos = vehicle.getYPos();
        return (vehicleXPos < 0 || vehicleXPos > screenWidth || vehicleYPos < 0 || vehicleYPos > screenHeight);
       // return (car.getXPos() < 800 && car.getXPos() > 0 ||car.getYPos() <= 800 && car.getYPos() > 0);
    }

    void turboOn(Saab95 saab){
       saab.setTurboOn();
    }

    void turboOff(Saab95 saab){
        saab.setTurboOff();
    }





}
