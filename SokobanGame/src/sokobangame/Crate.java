package sokobangame;

/**
 * Author: Lauren Fenwick
 * Date: 02/05/2023
 */
public class Crate extends MapElement {
    public Crate(){
    setSymbol ("C");
    setImgFilename ("/graphics/crate.png");
    setCanBePushed (true);
    setIsDestination (false);
    setObs (true);  
    }
}
