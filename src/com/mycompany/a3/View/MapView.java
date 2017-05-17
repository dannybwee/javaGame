package com.mycompany.a3.View;

import java.util.Observable;
import java.util.Observer;

import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.plaf.Border;
import com.mycompany.a3.Game.GameWorld;
import com.mycompany.a3.GameObjects.GameObject;
import com.mycompany.a3.Interfaces.IIterator;
import com.mycompany.a3.Interfaces.ISelectable;



//Middle view. This might be for next project.
//
//
//
public class MapView extends Container implements Observer{
    private GameWorld gw;
    private boolean paused;
    
    //pritns map data to the command line
    public MapView(Observable gameWorld){
    	this.gw = (GameWorld) gameWorld;
        gameWorld.addObserver(this);
        this.getAllStyles().setBorder(Border.createLineBorder(1,0));
        paused = false;
         
    }
 

    //prints map when notified
    public void update(Observable o, Object arg) { 
        GameWorld gameObjects = (GameWorld)o;
        gameObjects.map();
        repaint();
    }
     

    //graphic of the object
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Point p = new Point(getX(),getY());
        IIterator it = gw.iterator();
        while(it.hasNext()){
            Object x = it.getNext();
            if(x instanceof GameObject){
                GameObject y= (GameObject) x;
                y.draw(g, p);
            }
        }
    }
    
    //Selector for when the game is paused
    @Override
    public void pointerPressed(int x, int y){
        if(paused){
            x = x - getParent().getAbsoluteX();
            y = y - getParent().getAbsoluteY();
            Point p = new Point(x,y);
            Point P = new Point(getX(),getY());
            IIterator it = gw.iterator();
            while(it.hasNext()){
                Object z = it.getNext();
                if(z instanceof ISelectable){
                    ISelectable ani= (ISelectable) z;
                    if(ani.contains(p, P)){
                        ani.setSelected(true);
                    }else{
                        ani.setSelected(false);
                    }
                }
            }
            repaint();
        }
    }
    
   //allows pause access
    public boolean getPaused() {
        return paused;
    }
    
    
    //state of game
    public void setPaused(boolean paused) {
        this.paused = paused;
        if(!paused){
            IIterator it = gw.iterator();
            while(it.hasNext()){
                Object a = it.getNext();
                if(a instanceof ISelectable){
                    ISelectable animal= (ISelectable) a;
                        animal.setSelected(false);
                }
            }
            repaint();
        }
    }
}
