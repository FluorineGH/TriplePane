/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package triplepane;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author jcalvert
 */
public class Army {
    private int x = 0;
    private int y = 0;
    private Image image;
    ImageIcon tempload;    
    
    public Army(int y, int x){
        this.x = x;
        this.y = y;
        
        tempload = new ImageIcon(this.getClass().getResource("army.png"));        
        image = tempload.getImage();
        
    }
    
    public Image getImage(){
        return image;
   }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void move(int m){
        if(m==1 && y>0) y-=1;
        if(m==2 && x<9) x+=1;
        if(m==3 && y<9) y+=1;
        if(m==4 && x>0) x-=1;
    }
   
    
}
