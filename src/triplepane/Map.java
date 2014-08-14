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
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
//import javax.swing.Timer;

public class Map extends JPanel {
    public int[][] grid = new int[10][10];
    int BLOCK = 32;
    
/*  Image grass;    
    Image flower;
    Image dirt;
    Image town;   
*/
    Image[] pix = new Image[9];
    ImageIcon[] iia = new ImageIcon[9];
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
        
        for(int i = 0;i<9;i++) {
            pix[i] = iia[i].getImage();
        }
        
/*        ImageIcon ii = new ImageIcon(this.getClass().getResource("grass.png"));
        grass = ii.getImage();
        ImageIcon di = new ImageIcon(this.getClass().getResource("dirt.png"));
        dirt = di.getImage();
        ImageIcon fi = new ImageIcon(this.getClass().getResource("flower.png"));
        flower = fi.getImage();
        ImageIcon ti = new ImageIcon(this.getClass().getResource("town.png"));
        town = ti.getImage();
*/       
        
    }
    
    public void paint(Graphics g){
    
        super.paint(g);      
        Graphics2D g2d = (Graphics2D) g;
            for(int ii = 0;ii<10;ii++){
                for(int i=0;i<10;i++){
                    x=i*BLOCK;
                    y=ii*BLOCK;
                    if(grid[ii][i] == 0) g2d.drawImage(pix[0], x, y, this);
                    if(grid[ii][i] == 1) g2d.drawImage(pix[1], x, y, this);
                    if(grid[ii][i] == 2) g2d.drawImage(pix[2], x, y, this);
                    if(grid[ii][i] == 3) g2d.drawImage(pix[3], x, y, this);
                    if(grid[ii][i] == 4) g2d.drawImage(pix[4], x, y, this);
                    if(grid[ii][i] == 5) g2d.drawImage(pix[5], x, y, this);
                    if(grid[ii][i] == 6) g2d.drawImage(pix[6], x, y, this);
                    if(grid[ii][i] == 7) g2d.drawImage(pix[7], x, y, this);
                    if(grid[ii][i] == 8) g2d.drawImage(pix[8], x, y, this);
                }
            }
            
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
        
    }
    
    public void setBlock(int x, int y, int s) {
        grid[x][y] = s;
        repaint();
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
