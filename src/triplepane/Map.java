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

public class Map extends JPanel {
    public int[][] grid = new int[10][10];
    int BLOCK = 32;
    int iNUM = 10;

    Image[] pix = new Image[iNUM];
    ImageIcon[] iia = new ImageIcon[iNUM];
    BufferedImage bi = new BufferedImage(192,128,BufferedImage.TYPE_INT_RGB) ;
    BufferedImage[] bia = new BufferedImage[24];
    //Timer timer;
    int x = 0;
    int y = 0;
    
    public Map(){
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
        iia[0]=new ImageIcon(this.getClass().getResource("grass.png"));
        iia[1]=new ImageIcon(this.getClass().getResource("dirt.png"));
        iia[2]=new ImageIcon(this.getClass().getResource("flower.png"));
        iia[3]=new ImageIcon(this.getClass().getResource("town.png"));
        iia[4]=new ImageIcon(this.getClass().getResource("grass-dirt-n.png"));
        iia[5]=new ImageIcon(this.getClass().getResource("grass-dirt-e.png"));
        iia[6]=new ImageIcon(this.getClass().getResource("grass-dirt-s.png"));
        iia[7]=new ImageIcon(this.getClass().getResource("grass-dirt-w.png"));
        iia[8]=new ImageIcon(this.getClass().getResource("farm.png"));
        iia[9]=new ImageIcon(this.getClass().getResource("tiles.png"));
        
        //load the big tileset
        Graphics g = bi.createGraphics();
        iia[9].paintIcon(this, g, 0 ,0);
        
        for(int ii=0;ii<4;ii++){
            for(int i = 0; i <6;i++) {
                bia[i] = bi.getSubimage(BLOCK*i, 0, BLOCK, BLOCK);
            }            
        }   //Graphics g = bia[i].createGraphics();
            //iia[9].paintIcon(this, g, 0 ,0);
        
            
        for(int i = 0;i<pix.length;i++) {
            pix[i] = iia[i].getImage();
        }
       
        
    }
    
    public void paint(Graphics g){
    
        super.paint(g);      
        Graphics2D g2d = (Graphics2D) g;
            for(int ii = 0;ii<10;ii++){
                for(int i=0;i<10;i++){
                    x=i*BLOCK;
                    y=ii*BLOCK;
    
                    g2d.drawImage(bia[i], x,y, this);
                    
 /*                   if(grid[ii][i] == 0) g2d.drawImage(bia[0], x, y, this);
                    if(grid[ii][i] == 1) g2d.drawImage(bia[4], x, y, this);
                    if(grid[ii][i] == 2) g2d.drawImage(bia[5], x, y, this);
                    if(grid[ii][i] == 3) g2d.drawImage(bia[11], x, y, this);
                    if(grid[ii][i] == 4) g2d.drawImage(bia[14], x, y, this);
                    if(grid[ii][i] == 5) g2d.drawImage(bia[21], x, y, this);
                    if(grid[ii][i] == 6) g2d.drawImage(bia[20], x, y, this);
                    if(grid[ii][i] == 7) g2d.drawImage(bia[15], x, y, this);
                    if(grid[ii][i] == 8) g2d.drawImage(bia[16], x, y, this);
                    */
                }
            }
        // Paints bi the big tiles map    
        //g2d.drawImage(bi, 0,0, this);
        
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
        
    }
    
    public void setBlock(int x, int y, int s) {
        grid[x][y] = s;
        repaint();
    }
    
    public void getBlock(int x,int y) {
        
    }
    
     public void groomMap(int y, int x, int t){
        //Top Line 
        if(y>0) grid[y-1][x] = 6; 
        // Bottom Line
        if (y<9) grid[y+1][x] = 4;
        // Left Line
        if (x>0) grid[y][x-1] = 5;
         // Right Line
        if (x<9) grid[y][x+1] = 7; 
        
   }
    
    public void loadMap(){
        // Flowers
/*        grid[0][0] = 2;
        grid[0][6] = 2;
        grid[1][4] = 2;
        grid[2][9] = 2;
        grid[3][0] = 2;
        grid[3][5] = 2;
        grid[4][4] = 2;
        grid[4][8] = 2;
        grid[5][1] = 2;
        grid[5][6] = 2;
        grid[5][7] = 2;
        grid[7][0] = 2;
        grid[8][9] = 2;
        grid[9][1] = 2;
        grid[9][2] = 2;
        grid[9][5] = 2;
        // Dirt
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
