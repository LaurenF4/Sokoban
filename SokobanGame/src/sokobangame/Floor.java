package sokobangame;

/**
 * Author: Lauren Fenwick
 * Date: 02/05/2023
 */
public class Floor extends MapElement {
    public Floor(){
    setSymbol ("F");
    setImgFilename ("/graphics/floor.png");
    setCanBePushed (false);
    setIsDestination (false);
    setObs (false);
    
    }
}
