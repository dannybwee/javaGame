package com.mycompany.a3.GameObjects;


import java.util.Random;


import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Rectangle;
import com.mycompany.a3.Interfaces.IDrawable;
import com.mycompany.a3.Interfaces.IIterator;


public class Net extends Catcher implements IDrawable {

	//constrocutor
    public Net(int w,int h){
    	Random r = new Random();
        super.setSize(100);
        super.randomLocation();
        super.setColor(ColorUtil.rgb(174, 255, 1));
        super.setMap(w, h);
    }

    //This method checks to see if there is anything located at the current location
    //if dog, it increments dog in dogs caught and decrements dog in dogs still on the board.
    public void scoop(IIterator gameObjects){
    	Object x;
        double minX = this.getLocationX() - (this.getSize()*.5);
        double maxX = this.getLocationX() + (this.getSize()*.5);
        double minY = this.getLocationY() - (this.getSize()*.5);
        double maxY = this.getLocationY() + (this.getSize()*.5);
        while(gameObjects.hasNext()){
            x = gameObjects.getNext();
            if(x instanceof Dog){
                Dog grabber = (Dog)x;
                if(grabber.caught(minX, maxX, minY, maxY)){
                    int points = 10-grabber.getScratches();
                    gameObjects.removalDog(points);
                }
            }
            else if(x instanceof Cat){
                Cat grabber = (Cat)x;
                if(grabber.caught(minX, maxX, minY, maxY)){
                    gameObjects.removalCat();
                }
            }
        }
    }
     
   
    //returns color
    @Override
    public void setColor(int color) {
    }
    
    //graphic for net. - Square
    @Override
    public void draw(Graphics g, Point p) {
        int xLoc = p.getX() + (int)this.getLocationX()-(super.getSize()/2);
        int yLoc = p.getY() + (int)this.getLocationY()-(super.getSize()/2);
        g.setColor(super.getColor());
        g.fillRect(xLoc, yLoc, super.getSize(), super.getSize());
        super.setBounds(new Rectangle(xLoc, yLoc, super.getSize(), super.getSize()));
        
    }
    
}