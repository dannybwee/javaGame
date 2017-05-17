package com.mycompany.a3.GameObjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Rectangle;

import java.util.Random;
 


//Structure for in game objects.
//allows user to access location, size, color.
//Daniel Bui
//Assignment 1
//This class GameObject. Controls the game world. Including location,
//width of board
//height of board.
//color of object
//size of the game world box
public abstract class GameObject {
    private int  WIDTH; 
    private int  HEIGHT; 
    private int  NEARBY = 50;  
    private double locationX;  
    private double locationY;  
    private int size; 
    private int color;        
    private Rectangle bounds;
    
    //getter for color 
    public int getColor() {
        return color;
    }
    
    //getters for size
    public int getSize() {
        return size;
    }
    
    //getter for width variable
    public int getWIDTH() {
        return WIDTH;
    }
     
    
    //getter for the height variable
    public int getHEIGHT() {
        return HEIGHT;
    }
    
    //getter for locationX
    public double getLocationX() {
        return locationX;
    }
     
    //getter for locationY
    public double getLocationY() {
        return locationY;
    }
   
    //setters for color
    public void setColor(int color) {
        this.color = color;
    }
    
    //setter for height
    public void setHeight(int height) {
        this.HEIGHT = height-(getSize()/2);
    }
    
    //setter for width
    public void setWidth(int width) {
        this.WIDTH = width-(getSize()/2);
    }
    
    //setter for set size
    public void setSize(int size) {
        this.size = size;
    }

    public void setMap(int width, int height){
        this.WIDTH = width;
        this.HEIGHT = height;
    }
    
    //setter for the location x variable
    public void setLocationX(double locationX) {
    	if(locationX>= getWIDTH()-(getSize()/2)){
            this.locationX=WIDTH-(getSize()/2);
        }else if(locationX<(getSize()/2)){
            this.locationX=(getSize()/2);
        }else{
            this.locationX = locationX;
        }
    }
 

    //setter for location y variable
    public void setLocationY(double locationY) {
    	if(locationY >= getHEIGHT()-(getSize()/2)){
            this.locationY=HEIGHT-(getSize()/2);
        }else if(locationY<(getSize()/2)){
            this.locationY=(getSize()/2);
        }else{
            this.locationY = locationY;
        }
    }
    //setters for location y and x variable
    public void setLocation(double locationX,double locationY){
        setLocationX(locationX);
        setLocationY(locationY);
    }
 
    //changes location of objects on screen to a random spot
    //Double from string value
    //
    public void randomLocation(){
        Random r = new Random();
        String location = ""+r.nextInt(WIDTH+1)+"."+r.nextInt(25+10);
        double value = Double.parseDouble(location); 
        setLocationX(value);
        location = ""+r.nextInt(HEIGHT+1)+"."+r.nextInt(25+10);
        value = Double.parseDouble(location); 
        setLocationY(value);
    }
    
    //Moves the object to a nerby location that isn't random. aka cannot jump around map
    public void randomNearbyLocation(double x, double y){
        Random r = new Random();
        //old distance + new distance for both x and y coordinates
        double value = r.nextInt(NEARBY)+x;
        setLocationX(value);
        value = r.nextInt(NEARBY)+y; 
        setLocationY(value);
    }

    

    //Standard rgb color, in the format of color ( 0, 0, 0) 
    public String rgbColor(){
        return "color=[" + ColorUtil.red(color)  + ","
                         + ColorUtil.green(color)+ ","
                         + ColorUtil.blue(color) + "]";
    }

    //bounding box of an object
    public Rectangle getBounds() {
        return bounds;
    }
    
    //setter for bounding box
    public void setBounds(Rectangle rect) {
        this.bounds = rect;
    }  
   
    //GRAPHICS
    public abstract void draw(Graphics g,Point p);

    
    @Override
    public String toString() {
        return "loc=(" + getLocationX() 
        + ", " + getLocationY() 
        + ") " + rgbColor() 
        + " size:" + getSize();
    }
     
}