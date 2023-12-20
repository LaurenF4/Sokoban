package sokobangame;

/**
 * Author: Lauren Fenwick
 * Date: 02/05/2023
 */
public class Wall extends MapElement {
    public Wall(){
    setSymbol ("W");
    setImgFilename ("/graphics/wall.png");
    setCanBePushed (false);
    setIsDestination (false);
    setObs (true);  
    }
}
