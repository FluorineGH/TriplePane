/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package triplepane;

import java.awt.Image;
import java.awt.image.BufferedImage;
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
    
    
}
