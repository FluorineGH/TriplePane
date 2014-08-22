/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package triplepane;

import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

public class Barb {
    private int bx;
    private int by;
    private int sx;
    private int sy;
    private Image image;
    ImageIcon tempload;
    Settlement SS;
    Random r = new Random();
    int spawndir;
    int spawnloc;
    
    
    public Barb(int x, int y){
        sx = x;
        sy = y;
        
        Random r = new Random();
        spawndir = r.nextInt(4);
        spawnloc = r.nextInt(8);
        
        if(spawndir==0) by = 0;
        if(spawndir==1) bx = 8;
        if(spawndir==2) by = 8;
        if(spawndir==3) bx = 0;
        
        
        tempload = new ImageIcon(this.getClass().getResource("barb.png"));        
        image = tempload.getImage();        
    }
    
    public Image getImage(){
        return image;
   }
    
    public int getX(){
        return bx;
    }
    
    public int getY(){
        return by;
    }
    
    public void move(){   
        System.err.println("sy " + sy);
        System.out.println("by " + by);
        System.err.println("sx " + sx);
        System.out.println("bx " + bx);
        
        if(sy > by){
            by+=1;
        } else if (sy < by){
            by-=1;
        } else if (sx > bx){
            bx+=1;
        } else if (sx < bx){
            bx-=1;
        } else {             
            System.out.println("ATTACK!!");
        }
        
    }
    
// END
}