package sokobangame;

/**
 * Author: Lauren Fenwick
 * Date: 02/05/2023
 */
public class Diamond extends MapElement {
    public Diamond(){
    setSymbol ("D");
    setImgFilename ("/graphics/diamond.png");
    setCanBePushed (false);
    setIsDestination (true);
    setObs (false);  
    }
}
