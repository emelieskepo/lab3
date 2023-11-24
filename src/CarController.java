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
    ArrayList<Vehicle> vehicles = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.vehicles.add(new Volvo240()); //cc.vehicles.add(new Volvo240(0,0));
        cc.vehicles.add(new Saab95()); //cc.vehicles.add(new Saab95(0, 100));
        cc.vehicles.add(new Scania()); //cc.vehicles.add(new Scania(0, 200));

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
            int[] xCoordinates = new int[vehicles.size()];
            int[] yCoordinates = new int[vehicles.size()];

            for (int i = 0; i < vehicles.size(); i++) {
                Vehicle vehicle = vehicles.get(i);
                double initialSpeed = vehicle.getCurrentSpeed();
                if ( hitWall(vehicle)){
                    vehicle.stopEngine();
                    vehicle.turnRight();
                    vehicle.turnRight();
                    vehicle.startEngine();
                    vehicle.setCurrentSpeed(initialSpeed);
                }
                vehicle.move();
                xCoordinates[i] = (int) Math.round(vehicle.getXPos());
                yCoordinates[i] = (int) Math.round(vehicle.getYPos());
                frame.drawPanel.moveit(xCoordinates, yCoordinates);
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
    }

    void turboOn(){
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOn();
            }
        }
    }

    void turboOff(){
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOff();
            }
        }
    }

    void startAllCars(){
        for (Vehicle vehicle : vehicles) {
            vehicle.startEngine();
        }
    }

    void stopAllCars(){
        for (Vehicle vehicle : vehicles) {
            vehicle.stopEngine();
        }
    }

    void liftBed(){
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Truck)
                ((Truck) vehicle).setIsLiftUp(false);
        }
    }

    void lowerBed(){
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Truck)
                ((Truck) vehicle).setIsLiftUp(true);
        }
    }





}
