/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package triplepane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
//import javax.swing.Timer;
import java.util.ArrayList;

public class Map extends JPanel {
    public int[][] grid = new int[10][10];
    int BLOCK = 32;
    int iNUM = 10;
    MainFrame MF;
    
    ImageIcon ii = new ImageIcon();
    
    BufferedImage bi = new BufferedImage(800,32,BufferedImage.TYPE_INT_RGB) ;
    BufferedImage[] bia = new BufferedImage[25];
    //Timer timer;
    int x = 0;
    int y = 0;
    
    public Map(MainFrame MF){
        this.MF = MF;
        this.setSize(320,320);
        setBackground(Color.GREEN);
        setDoubleBuffered(true);
        loadImages();
        loadMap();
        
        //timer = new Timer(25,this);
        //timer.start();
        repaint();
        
    }
    
    private void loadImages() { 
        
        ii = new ImageIcon(this.getClass().getResource("tiles.png"));      
        //load the big tileset
        Graphics g = bi.createGraphics();
        ii.paintIcon(this, g, 0 ,0);
        
        for(int i = 0; i <24;i++) {
                bia[i] = bi.getSubimage(BLOCK*i, 0, BLOCK, BLOCK);
        }
      
        
    }
    
    public void paint(Graphics g){
    
        super.paint(g);      
        Graphics2D g2d = (Graphics2D) g;
            for(int ii = 0;ii<10;ii++){
                for(int i=0;i<10;i++){
                    x=i*BLOCK;
                    y=ii*BLOCK; 
                    g2d.drawImage(bia[grid[ii][i]], x,y, this);
                    //Army a = new Army(0,0);
                    //g2d.drawImage(a.getImage(), a.getX(), a.getY(), this);
                }
                
                ArrayList aa = MF.getArmies();
                if(aa.size()>0) System.err.println(aa);
                if(aa.size()==0) System.err.println("aa list = 0");
                for (int i = 0; i < aa.size(); i++) {
                    Army a = (Army)aa.get(i);
                    g2d.drawImage(a.getImage(), a.getX(), a.getY(), this);
                }
                
            }
       
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
        
    }
    
    public void setBlock(int x, int y, int s) {
        grid[x][y] = s;
        repaint();
    }
    
    public int getBlock(int x,int y) {
        return grid[x][y];
    }
    
     public void groomMap(int y, int x, int t){
        //Top Line 
        grid[y-1][x-1] = 16;
        grid[y-1][x] = 12;
        grid[y-1][x+1] = 17;
        // Bottom Line
        grid[y+1][x-1] = 15;
        grid[y+1][x] = 10;
        grid[y+1][x+1] = 14;
        // Left Line
        grid[y-1][x-1] = 16;
        grid[y][x-1] = 11;
        grid[y+1][x-1] = 15;
         // Right Line
        grid[y-1][x+1] = 17;
        grid[y][x+1] = 13;
        grid[y+1][x+1] = 14;
        
   }
    
    public void loadMap(){
        // Flowers
        grid[0][0] = 1;
        grid[0][6] = 1;
        grid[1][4] = 1;
        grid[2][9] = 1;
        grid[3][0] = 1;
        grid[3][5] = 1;
        grid[4][4] = 1;
        grid[4][8] = 1;
        grid[5][1] = 1;
        grid[5][6] = 1;
        grid[5][7] = 1;
        grid[7][0] = 1;
        grid[8][9] = 1;
        grid[9][1] = 1;
        grid[9][2] = 1;
        grid[9][5] = 1;
 /*       // Dirt
        grid[1][1] = 1;
        grid[1][2] = 1;
        grid[1][3] = 1;
        grid[1][6] = 1;
        grid[1][7] = 1;
        grid[1][8] = 1;
        // Dirt & town 1 2
        grid[2][1] = 1;
        grid[2][2] = 3;
        grid[2][3] = 1;
        grid[2][6] = 1;
        grid[2][7] = 3;
        grid[2][8] = 1;
        // Dirt
        grid[3][1] = 1;
        grid[3][2] = 1;
        grid[3][3] = 1;
        grid[3][6] = 1;
        grid[3][7] = 1;
        grid[3][8] = 1;
        // Dirt
        grid[6][1] = 1;
        grid[6][2] = 1;
        grid[6][3] = 1;
        grid[6][6] = 1;
        grid[6][7] = 1;
        grid[6][8] = 1;
        // Dirt & town 3 4
        grid[7][1] = 1;
        grid[7][2] = 3;
        grid[7][3] = 1;
        grid[7][6] = 1;
        grid[7][7] = 3;
        grid[7][8] = 1;
        // Dirt
        grid[8][1] = 1;
        grid[8][2] = 1;
        grid[8][3] = 1;
        grid[8][6] = 1;
        grid[8][7] = 1;
        grid[8][8] = 1;
        */
    }
// END
}
