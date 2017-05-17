package com.mycompany.a3.GameObjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Rectangle;
import com.mycompany.a3.Game.GameWorld;
import com.mycompany.a3.Interfaces.ICollider;
import java.util.Random;

//cat extends animal class
//color is not allowed to change
//constructor that creates a cat of speed 5, and random direction
public class Cat extends Animal implements ICollider{
	private int born;
	private boolean kitten;
	
    public Cat(int w,int h){
        Random r = new Random();
        super.setSpd(8);
        super.setDir(r.nextInt(360));
        super.setSize(r.nextInt(30)+20);
        super.randomLocation();
        super.setColor(ColorUtil.rgb(51, 255, 51));
        super.setMap(w,h);
        super.setChecked(false);
        born = 16;
        this.kitten = false;
    }
 
    //when two cats run into each other, this
    //produces another cat nearby
    //KittenCat
    public Cat(double x, double y, int w, int h){
        Random r = new Random();
        super.setSpd(4);
        super.setDir(r.nextInt(360));
        super.setSize(r.nextInt(30)+20);
        super.setColor(ColorUtil.rgb(51, 255, 51));
        super.randomNearbyLocation(x,y);
        super.setBounds(new Rectangle((int)this.getLocationX()-(super.getSize()/2),  (int)this.getLocationY()-(super.getSize()/2), super.getSize(), super.getSize()));
        super.setMap(w,h);
        super.setChecked(true);
        this.born = 0;
        this.kitten = true;
    }
   
    @Override
    public void setColor(int color) {
    }
    
  
    //collision box.
    public boolean collidesWith(ICollider other) {
    	Animal ani = (Animal)other;
        boolean intersection = super.getBounds().intersects(ani.getBounds());
        return intersection;
    }
    
    public int getBorn() {
        return born;
    }
    
    //Handles collisions of the cat. If it hits another cat, it makes another. If dog,
    //then it causes dog to lose points
    public void handleCollision(ICollider other,GameWorld gw) {
        if(other instanceof Cat){
            Cat ani = (Cat)other;
            if( ani.getBorn()>10 && this.getBorn()>10){
                gw.KittenCat(ani, this);
                this.born =-1;
            }
            born++;
        }else if(other instanceof Dog){
            Dog ani = (Dog)other;
            ani.scratched();
        } 
    }

    
    //Graphic of cat. 
    @Override
    public void draw (Graphics g, Point p) {
    	int xLocation = p.getX() + (int)this.getLocationX();
        int yLocation = p.getY() + (int)this.getLocationY();
        int[] x = {xLocation-(super.getSize()/2),xLocation+(super.getSize()/2),xLocation};
        int[] y = {yLocation-(super.getSize()/2),yLocation-(super.getSize()/2),yLocation+(super.getSize()/2)};
        g.setColor(super.getColor());
        g.fillPolygon(x, y, 3);

        super.setBounds(new Rectangle(p.getX() + (int)this.getLocationX()-(super.getSize()/2),  p.getY() + 
        		(int)this.getLocationY()-(super.getSize()/2), super.getSize(), super.getSize()));
    }
    
}
    
