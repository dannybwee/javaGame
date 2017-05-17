package com.mycompany.a3.GameObjects;


import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Rectangle;
import com.mycompany.a3.Game.GameWorld;
import com.mycompany.a3.Interfaces.ICollider;
import com.mycompany.a3.Interfaces.ISelectable;

public class Dog extends Animal implements ICollider, ISelectable{
  
	
   private int scratches;
   private int lastScratched;
   private boolean selected;
   
   public Dog (int w, int h){
	   Random r = new Random();
       scratches = 0;
       lastScratched = 16;
       selected = false;
       super.setSize(r.nextInt(30)+20);
       super.setMap(w, h);
       super.setSpd(6);
       super.setDir(r.nextInt(360));
       super.setColor(ColorUtil.rgb(128, 0, 255));
       super.randomLocation();super.setMap(w, h);
       super.setChecked(false);
    }

    //getters for scratches
    public int getScratches() {
        return scratches;
    }

   
    //setter for stratches
    public void scratched(){
        if (scratches < 5 && scratches >= 0 && lastScratched > 10){
            scratches++;
            super.setSpd((super.getSpd())-2);
            super.setColor(colorChange(scratches));
            lastScratched = 0;
        }else
            lastScratched++;
    }

    public void heal() {
        if (scratches <= 5 && scratches > 0){
            scratches--;
            super.setSpd((super.getSpd())+2);
            super.setColor(colorChange(scratches));
            lastScratched = 0;
        }
    }
    
    //Changes color based on the amount of scratches
    //slowly from green default to red.
    //http://www.endprod.com/colors/ Used this color sheet. Didn't know if it was correct.
    private int colorChange(int scratch){
        switch (scratch){
            case 0:
                return ColorUtil.rgb(128, 0, 255);
            case 1:
                return ColorUtil.rgb(255, 102, 102);
            case 2:
                return ColorUtil.rgb(255, 26, 26);
            case 3:
                return ColorUtil.rgb(204, 0, 0);
            case 4:
                return ColorUtil.rgb(153, 0, 0);
            case 5:
                return ColorUtil.rgb(77, 0, 0);
            default:
                return ColorUtil.rgb(0, 0, 0);
        }
    }
      
    //more values return
    @Override
    public String toString() {
        return "loc=("+super.getLocationX()
        + ", "+super.getLocationY()
        + ") "+ super.rgbColor() 
        + " size:" + super.getSize() 
        + " speed:"+ super.getSpd()
        + " dir:"+ super.getAnimalDir() 
        + " scratches="+getScratches();
    }
     
    //Graphic for dog. A circle.
    @Override
    public void draw(Graphics g, Point p) {
        int xLoc = p.getX() + (int)this.getLocationX()-(super.getSize()/2);
        int yLoc = p.getY() + (int)this.getLocationY()-(super.getSize()/2);
        g.setColor(super.getColor());
        if(selected)
            g.drawArc(xLoc, yLoc, super.getSize(), super.getSize(), 0, 360);
        else
            g.fillArc(xLoc, yLoc, super.getSize(), super.getSize(), 0, 360);
        super.setBounds(new Rectangle(xLoc, yLoc, super.getSize(), super.getSize()));
    }
 
    public boolean collidesWith(ICollider other) {
        Animal ani = (Animal)other;
        return super.getBounds().intersects(ani.getBounds());
    }
 
    //gets collision if it's a cat.
    public void handleCollision(ICollider other,GameWorld gw) {
        if(other instanceof Cat){
            gw.fight(this);
        }
    }
 
    //setter for selected
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
 
    //getter for selected
    public boolean isSelected() {
        return selected;
    }
 
    //contains bounds for rectangles
    public boolean contains(Point p, Point X) {
        int xLoc = p.getX();
        int yLoc = p.getY();
        return super.getBounds().intersects(new Rectangle(xLoc, yLoc, 1, 1));
    }


}