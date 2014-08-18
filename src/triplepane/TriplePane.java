/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package triplepane;

import java.util.Random;
import static triplepane.MainFrame.YEAR;

    
/**
 *
 * @author jcalvert
 */
public class TriplePane {
    MainFrame MF;
    Map M;
    Settlement SS;
    static int num;
    static int num2;
    public boolean play = false;
    //public String s;
    
    public TriplePane(MainFrame MF, Map M, Settlement SS) {
        this.SS = SS;
        this.M = M;
        this.MF = MF;
        Random r = new Random();
        num = r.nextInt(7)+1;
        num2 = r.nextInt(7)+1;
}

    public void intro(){
/*   MF.setFood("bats");
     MF.M.setBlock(1,1,1);
     MF.M.setBlock(5,4,3);    
*/   
        
     MF.writeNarra("Welcome to Jhethria.");
     MF.writeNarra("Enter the name of your settlement.");
     MF.getLine();
     play=true;
    }
    
    public void doStuff(String s){
        if(MF.YEAR == 1000) {
            w("Your settlement will be know as " + s + ".");
            //SS.setName(s);            
            MF.setName(s);
            w("Let's find you a home!");
            w("North - South: " + num);
            w("East - West: " + num2);
            SS.setCoords(num, num2);
            MF.M.setBlock(num,num2,5);
            //MF.M.groomMap(num, num2, 5);
            w("The year is: " + MF.YEAR); 
            SS.sUpdate();                
        }
        
        if(SS.Food<1) {
                w("You have starved to death!");
                MF.LOST = true;
        }
        
        //Narra Notes & hints
        if(MF.YEAR<1003) {
            w("You will generate gold each year, based on your Prosperity.");
            w("You might have to skip a few turns at the start to get some gold.");
        }
        if(SS.Pop> 20 && SS.Garr == 0) {
            w("You might want to hire some soldiers to defend your town.");
            w("Soldiers cost 10 gold and 10 Population to build. Type SOLDIER");
        }
        if(SS.Farms<1) {
            w("You should probably build some farms, so you don't starve.");
            w("Farms are 10 gold and produce 1 food/year. Type FARM.");
        }
        if(MF.YEAR>1100 && SS.Fort<1) {
            w("You should probably build some walls, to keep out the riff raff.");
            w("Walls are 100 gold per level, with 5 levels. Type WALL.");
        }
        if(SS.Food>100 && SS.Gold < 20) w("You can sell food by typing: SELL ##");
        // DEV TOOLS
        if(s.equalsIgnoreCase("$")) SS.Gold+=100;
        if(s.equalsIgnoreCase("%")) SS.Food+=100; 
        if(s.equalsIgnoreCase("#")) SS.Pop+=100;
       
        
        if(s.equalsIgnoreCase("farm") || s.equalsIgnoreCase("farms")) SS.buyFarm();
        if(s.equalsIgnoreCase("soldier") || s.equalsIgnoreCase("soldiers")) SS.buyGarr();
        if(s.equalsIgnoreCase("wall") || s.equalsIgnoreCase("walls")) SS.buyWalls();
        if(s.length()>4 && s.substring(0,4).equalsIgnoreCase("sell")) {
            int i = s.length() - 5;
            String str = s.substring(s.length()-i,s.length());
            int ii = Integer.parseInt(str);
            SS.sellFood(ii);            
        }
        
        YEAR++;
        SS.turn();
        SS.sUpdate();
        
        //System.out.println("THAT'S ALL FOLKS!");
    }
    
    
   
    
    public void w(String s){
        MF.writeNarra(s);
    }
    
}
