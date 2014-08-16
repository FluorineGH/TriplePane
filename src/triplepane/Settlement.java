/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package triplepane;

/**
 *
 * @author jcalvert
 */
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
        if(NS>0) MF.M.setBlock(NS-1,EW,8);
        else if(NS<9) MF.M.setBlock(NS+1,EW,8);
        else if(EW>0) MF.M.setBlock(NS,EW-1,8);
        else if(EW<9) MF.M.setBlock(NS,EW+1,8);
        MF.writeNarra("A new farm has been completed! This will provide +1 food/year.");
        Farms+=1;
        Gold-=10;
    }
    
    public void turn(){
        Pop+=(Pros/10);
        Food-=(Pop/10);
        Food+=Farms;
        Gold+=(Pop/10)*Pros;
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
}
