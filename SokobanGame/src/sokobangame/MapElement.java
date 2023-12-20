package sokobangame;

/**
 * Author: Lauren Fenwick
 * Date: 02/05/2023
 */
public abstract class MapElement {
    //Instance Variables
    private boolean canBePushed, isDestination, obs;
    private String imgFilename, symbol;
    private int x, y;
    private MapElement underneath;
    
    //Method

    

    //Getters and Setters
        public boolean isCanBePushed() {
        return canBePushed;
    }

    public void setCanBePushed(boolean canBePushed) {
        this.canBePushed = canBePushed;
    }

    public boolean isIsDestination() {
        return isDestination;
    }

    public void setIsDestination(boolean isDestination) {
        this.isDestination = isDestination;
    }

    public boolean isObs() {
        return obs;
    }

    public void setObs(boolean obs) {
        this.obs = obs;
    }

    public String getImgFilename() {
        return imgFilename;
    }

    public void setImgFilename(String imgFilename) {
        this.imgFilename = imgFilename;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public MapElement getUnderneath() {
        return underneath;
    }

    public void setUnderneath(MapElement underneath) {
        this.underneath = underneath;           
    }
}
