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
        num = r.nextInt(9);
        num2 = r.nextInt(9);
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
            MF.M.setBlock(num,num2,3);
            MF.M.groomMap(num, num2, 3);
            w("The year is: " + MF.YEAR); 
            SS.sUpdate();    
            
        }
        if(MF.YEAR<1010) w("You might have to skip a few turns to get some gold.");
        if(SS.Farms<1) w("You should probably build some farms, so you don't starve. Farms are 10 gold.");
        if(s.equalsIgnoreCase("farm") || s.equalsIgnoreCase("farms")) SS.buyFarm();
        YEAR++;
        SS.turn();
        SS.sUpdate();
        
        System.out.println("THAT'S ALL FOLKS!");
    }
    
    
   
    
    public void w(String s){
        MF.writeNarra(s);
    }
    
}
