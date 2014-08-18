/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package triplepane;

import java.util.ArrayList;


public class Settlement {
    int NS;
    int EW;
    
    MainFrame MF;
    String Name = "";
    int Level;
    int Pop;
    int Fort;
    int Farms;
    int Pros;
    int Garr;
    int Food;
    int Gold;
    
    public Settlement (MainFrame m) {
        MF = m;
        
        Name = "temp";
        Level = 1;
        Pop = 10;
        Fort = 0;
        Farms = 0;
        Pros = 1;
        Garr = 0;
        Food = 20;
        Gold = 0;
    }
    
    public Settlement (MainFrame m, String s) {
        MF = m;
        Name = s;
        Level = 1;
        Pop = 10;
        Fort = 0;
        Farms = 0;
        Pros = 1;
        Garr = 0;
        Food = 10;
        Gold = 0;
    }
    
    public void setName(String s) {
        Name = s;
    }
    
    public void setCoords(int y, int x) {
        NS = y;
        EW = x;
    }
    
    public void buyFarm(){
        if(Gold<10) {
            MF.writeNarra("You don't have enough gold!");
            return;
        }
        if(MF.M.grid[NS-1][EW]<2) MF.M.setBlock(NS-1,EW,4);       
        else if(MF.M.grid[NS+1][EW]<2) MF.M.setBlock(NS+1,EW,4);
        else if(MF.M.grid[NS][EW-1]<2) MF.M.setBlock(NS,EW-1,4);
        else if(MF.M.grid[NS][EW+1]<2) MF.M.setBlock(NS,EW+1,4);
        else if(MF.M.grid[NS+1][EW+1]<2) MF.M.setBlock(NS+1,EW+1,4);
        else if(MF.M.grid[NS-1][EW-1]<2) MF.M.setBlock(NS-1,EW-1,4);
        else if(MF.M.grid[NS-1][EW+1]<2) MF.M.setBlock(NS-1,EW+1,4);
        else if(MF.M.grid[NS+1][EW-1]<2) MF.M.setBlock(NS+1,EW-1,4);
        MF.writeNarra("A new farm has been completed! This will provide +1 food/year.");
        Farms+=1;
        Gold-=10;
    }
    
    public void buyGarr() {
        if(Gold<10) {
            MF.writeNarra("You don't have enough gold!");
            return;
        }
        if(Pop<20) {
            MF.writeNarra("You don't have the Population to support an army!");
            return;
        }
        if(Pop<10) {
            MF.writeNarra("You don't have enough Population to recruit soldiers!");
            return;
        }
        MF.writeNarra("A new army has been recruited! They will consume 1 food/year.");
        Garr+=1;
        Gold-=10;
        Pop-=10;
        MF.Armies.add(new Army(NS,EW));
        MF.M.repaint();
    }
    
    public void buyWalls() {
        if(Fort>4) {
            MF.writeNarra("Your walls are already max level!");
            return; 
        }  
        if(Gold<(Fort*100)+100) {
            MF.writeNarra("You don't have enough gold!");
            return; 
        }
        MF.writeNarra("You have built walls to protect your city!");     
        Gold-=(Fort*100)+100;
        Fort+=1;       
        MF.M.setBlock(NS,EW,6);       
        MF.writeNarra("Current Fortification level: " + Fort);
    }
    
    public void sellFood(int i){
        if(Food<i){
            MF.writeNarra("You can't sell more food than you have!");
            return; 
        }  
        Food-=i;
        Gold+=i;
    }
    
    public void turn(){
        Pop+=(Pros/10);
        Food-=(Pop/10);
        Food-=(Garr);
        Food+=Farms;
        Gold+=(Pop/10)*Pros;
        Pop+=(Food/100);
        
        
        if(Food<1) MF.LOST = true;
    }
    
    public void sUpdate() {
       MF.setLevel("Level: " + Integer.toString(Level));
       MF.setPop("Population: " + Integer.toString(Pop));
       MF.setFort("Fortification: " + Integer.toString(Fort));
       MF.setFarms("Farms: " + Integer.toString(Farms));
       MF.setPros("Prosperity: " + Integer.toString(Pros));
       MF.setGarr("Garrison: " + Integer.toString(Garr));
       MF.setFood("Food: " + Integer.toString(Food));
       MF.setGold("Gold: " + Integer.toString(Gold));
    }
    
    
    
 // END   
}
