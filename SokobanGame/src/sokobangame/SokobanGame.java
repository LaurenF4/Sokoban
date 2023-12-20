package sokobangame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**
 *
 * @author budfe
 */
public class SokobanGame extends javax.swing.JFrame implements KeyListener {
    
    private JLabel[][] myElements;
    private Map tmpMap;
    private boolean complete;
    private int dir;
    private int level;
    private Coord playerLocation;
    private HashMap<String, ImageIcon> imageHashMap;
    private String[] mapNames = {
        "C:\\Users\\budfe\\OneDrive\\Documents\\NetBeansProjects\\SokobanGame\\src\\levels\\map0.map", 
        "C:\\Users\\budfe\\OneDrive\\Documents\\NetBeansProjects\\SokobanGame\\src\\levels\\map1.map", 
        "C:\\Users\\budfe\\OneDrive\\Documents\\NetBeansProjects\\SokobanGame\\src\\levels\\map2.map",
        "C:\\Users\\budfe\\OneDrive\\Documents\\NetBeansProjects\\SokobanGame\\src\\levels\\map3.map",
        "C:\\Users\\budfe\\OneDrive\\Documents\\NetBeansProjects\\SokobanGame\\src\\levels\\map4.map"};
    
    
    /**
     * Creates new form Game
     */
    public SokobanGame() {
        initComponents();
        myElements = new JLabel[12][12];
        imageHashMap = new HashMap<>();
        imageHashMap.put("W", new ImageIcon(getClass().getResource("/graphics/Wall.png")));
        imageHashMap.put("F", new ImageIcon(getClass().getResource("/graphics/Floor.png")));
        imageHashMap.put("P", new ImageIcon(getClass().getResource("/graphics/Player.png")));
        imageHashMap.put("D", new ImageIcon(getClass().getResource("/graphics/Diamond.png")));
        imageHashMap.put("C", new ImageIcon(getClass().getResource("/graphics/Crate.png")));
        for (int i = 0; i < myElements.length; i++){
            for (int j = 0; j < myElements.length; j++) {
                myElements[i][j] = new JLabel();
                centrePanel.add(myElements[i][j]);
                }
        }
        this.addKeyListener(this);
        setFocusable(true);
        tmpMap = new Map();
        tmpMap.loadMap(mapNames);
        drawMap();
    }
    
    
    private void drawMap(){
    MapElement[][] map = tmpMap.getMyMap();

    for (int i = 0; i < myElements.length; i++) {
        for (int j = 0; j < myElements[i].length; j++) {
            if (map[i][j] != null) {
                String symbol = map[i][j].getSymbol();
                ImageIcon icon = getImage(symbol);
                myElements[i][j].setIcon(icon);
                
                // Check if the current element is the player
                if (map[i][j] instanceof Player) {
                    playerLocation = new Coord(i, j);
                }
            } else {
                // Handle the case when Map[i][j] is null
                System.out.println("Uh Oh! There has been an error!");
            }
        }
    }
    
    // Update the number of moves in the lbl_moves label
    lbl_moves.setText("Moves: " + tmpMap.getNoOfMoves());
    
}
    public ImageIcon getImage(String fileName){ 
        ImageIcon icon = imageHashMap.get(fileName);
    if (icon == null) {
        System.out.println("Image not found for symbol: " + fileName);
    }
    return icon;  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        southPanel = new javax.swing.JPanel();
        lbl_moves = new javax.swing.JLabel();
        centrePanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        southPanel.setPreferredSize(new java.awt.Dimension(400, 30));

        lbl_moves.setText("jLabel1");

        javax.swing.GroupLayout southPanelLayout = new javax.swing.GroupLayout(southPanel);
        southPanel.setLayout(southPanelLayout);
        southPanelLayout.setHorizontalGroup(
            southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(southPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_moves, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(325, Short.MAX_VALUE))
        );
        southPanelLayout.setVerticalGroup(
            southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, southPanelLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(lbl_moves)
                .addContainerGap())
        );

        getContentPane().add(southPanel, java.awt.BorderLayout.PAGE_END);

        centrePanel.setPreferredSize(new java.awt.Dimension(400, 400));
        centrePanel.setLayout(new java.awt.GridLayout(12, 12));
        getContentPane().add(centrePanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SokobanGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SokobanGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SokobanGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SokobanGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SokobanGame().setVisible(true);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel centrePanel;
    private javax.swing.JLabel lbl_moves;
    private javax.swing.JPanel southPanel;
    // End of variables declaration//GEN-END:variables

    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'w' || e.getKeyCode() == KeyEvent.VK_UP){
            tmpMap.movePlayer(1);
            System.out.println("up");
        } else if(e.getKeyChar() == 's' || e.getKeyCode() == KeyEvent.VK_DOWN){
            tmpMap.movePlayer(2);
            System.out.println("down");
        }  else if(e.getKeyChar() == 'a' || e.getKeyCode() == KeyEvent.VK_LEFT){
            tmpMap.movePlayer(3);
            System.out.println("left");
        }  else if(e.getKeyChar() == 'd' || e.getKeyCode() == KeyEvent.VK_RIGHT){
            tmpMap.movePlayer(4);
            System.out.println("right");
        }
        drawMap();
        if (complete == true) {
        System.out.println("You win!");
        }
    }
        

    @Override
    public void keyReleased(KeyEvent e) {}

}