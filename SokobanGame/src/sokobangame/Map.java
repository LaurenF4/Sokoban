package sokobangame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Author: Lauren Fenwick
 * Date: 02/05/2023
 */

public class Map {
    private MapElement[][] myMap = new MapElement[12][12];
    private int length;
    private int breadth;
    private Coord playerLocation = null;
    private boolean complete= false;
    private int noOfMoves = 0;
    
   public Map(){
        for (int i = 0; i < myMap.length; i++) {
        for (int j = 0; j < myMap[i].length; j++) {
            //Initialise map elements
            myMap[i][j] = new Floor();
            }
        }
    }
   
    public MapElement[][] getMyMap(){
        return myMap;
    }
    
public void movePlayer(int dir) {
    if (playerLocation == null) {
        return; // No player location, cannot move
    }

    int playerRow = playerLocation.getX();
    int playerCol = playerLocation.getY();

    int newPlayerRow = playerRow;
    int newPlayerCol = playerCol;

    if (dir == 1) {
        newPlayerRow--;
    } else if (dir == 2) {
        newPlayerRow++;
    } else if (dir == 3) {
        newPlayerCol--;
    } else if (dir == 4) {
        newPlayerCol++;
    }

    if (!isObstacleAhead(newPlayerRow, newPlayerCol)) {
        // Move the player to the new position
        MapElement newPlayerPosition = myMap[newPlayerRow][newPlayerCol];
        checkForWin();

        if (newPlayerPosition instanceof Crate) {
            // Move the crate if there is no obstacle behind it
            int newCrateRow = newPlayerRow;
            int newCrateCol = newPlayerCol;

            if (!isObstacleAhead(newCrateRow, newCrateCol)) {
                // Get the current position of the diamond
                MapElement currentDiamondPosition = newPlayerPosition.getUnderneath();

                // Update the crate's position
                myMap[newCrateRow][newCrateCol] = new Crate();
                newPlayerPosition.setUnderneath(currentDiamondPosition);

                // Update the player's position
                myMap[playerRow][playerCol] = currentDiamondPosition;
                playerLocation = new Coord(newPlayerRow, newPlayerCol);

                noOfMoves++;
            }
        } else {
            myMap[newPlayerRow][newPlayerCol] = myMap[playerRow][playerCol];
            if (newPlayerPosition instanceof Diamond) {
                myMap[playerRow][playerCol] = new Diamond();
                playerLocation = new Coord(newPlayerRow, newPlayerCol);
                noOfMoves++;
            } else {
                myMap[playerRow][playerCol] = new Floor();
                playerLocation = new Coord(newPlayerRow, newPlayerCol);
                noOfMoves++;
            }
        }
    }
}
    

    private boolean isObstacleAhead(int x, int y) {
      MapElement element = myMap[x][y];
    if (element instanceof Wall) {
        // Wall, cannot move
        return true;
    } else if (element instanceof Crate) {
        // Check if there is another obstacle (wall or crate) behind the crate
        int dx = x - playerLocation.getX();
        int dy = y - playerLocation.getY();
        int crateBehindX = x + dx;
        int crateBehindY = y + dy;

        MapElement elementBehindCrate = myMap[crateBehindX][crateBehindY];
        if (elementBehindCrate instanceof Wall || elementBehindCrate instanceof Crate) {
            // Obstacle behind the crate, cannot move
            return true;
        }
    
        // Move the crate
        myMap[crateBehindX][crateBehindY] = new Crate();
        myMap[x][y] = new Floor();
        return false;
    }
    return false;
}
    
    public boolean checkForWin(){
    // Check if all crates are on diamonds to determine if the game is complete
    for (int row = 0; row < length; row++) {
        for (int col = 0; col < breadth; col++) {
            MapElement element = myMap[row][col];
            if (element instanceof Diamond) {
                if (!(element.getUnderneath() instanceof Crate)) {
                    return false;
                }
            }
        }
    }
    complete = true;
    return true;
}
    public void loadMap(String[] mapNames){
    for (String mapName : mapNames){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(mapName));
            String line;
            int row = 0;
        
            while ((line = reader.readLine()) != null) {
                for (int col = 0; col < line.length(); col++) {
                    char ch = line.charAt(col);
                
                    // Create map elements based on the characters in the file
                    if (ch == 'W') {
                        myMap[row][col] = new Wall();
                    } else if (ch == 'P') {
                        myMap[row][col] = new Player();
                        playerLocation = new Coord(row, col);
                    } else if (ch == 'D') {
                        myMap[row][col] = new Diamond();
                    } else if (ch == 'C') {
                        myMap[row][col] = new Crate();
                    } else {
                        myMap[row][col] = new Floor();
                    }
                }
                row++;
            }
        
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Oops!");
        }  
    }    
}

    
    public Coord findPlayer(){
        return playerLocation;
    }
    
    public int getLength() {
        
        return length;
    }

    public int getBreadth() {
        
        return breadth;
    }

    public MapElement[][] getElement(int x, int y){
    
        return myMap;
    }
    
    public int getNoOfMoves() {
        
        return noOfMoves;
    }   
    
    
}
