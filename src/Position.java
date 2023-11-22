public class Position {
    private String direction;
    private double xPos;
    private double yPos;

    public Position(double xPos, double yPos, String direction){
        this.xPos = xPos;
        this.yPos = yPos;
        this.direction = direction;
    }

    public double getXPos(){
        return this.xPos;
    }

    public double getYPos(){
        return this.yPos;
    }

    public void setXPos(double xPos) {
        this.xPos = xPos;
    }

    public void setYPos(double yPos) {
        this.yPos = yPos;
    }

    public String getDirection() {
        return this.direction;
    }

    public void setDirection(String direction){
        this.direction = direction;
    }

}