package com.mycompany.a3.GameObjects;

import java.util.Random;

import com.mycompany.a3.Interfaces.IMovable;

//Assignment 1
//Daniel Bui
//Animals extends GameObjects.
//allows for basic access to animals moves, speed, direction

public abstract class Animal extends GameObject implements IMovable{
 
	
  private final int MaxSpd = 10; 
  private final int MinSpd = 0; 
  private int Spd;                  
  private int Dir;              
  private boolean exist = false;    
  private boolean checked;
  
  //creates the initial setup of an animal
  //boolean for the inital animal creation 
  //location is random
  //color is fixed based on animal 
  //speed is set to 5 and decrements to 0 based on if the animal's health is lower
  //direction is random
  
  //getter for the max speed variable
  public int getMaxSpd() {
      return MaxSpd;
  }
  //getter for the min speed variable
  public int getMinSpd() {
      return MinSpd;
  }
  //getter for the speed variable
  public int getSpd() {
      return Spd;
  }
   
//getter for the steering direction variable
  public int getAnimalDir() {
      return Dir;
  }  
  
  //checks for collision
  public boolean getChecked() {
      return checked;
  }
  
  //setter for collision
  public void setChecked(boolean checked) {
      this.checked = checked;
  }   
  
  //setter for size variable
  @Override
  public void setSize(int size) {
      if (exist == false){
          super.setSize(size);
          exist = true;
      }
  }
  //setter for the speed variable
  //this is needed to make sure the animal has max and min speeds based on health
  public void setSpd(int spd1) {
      if(spd1<MinSpd){
          spd1 = MinSpd;
      }else if (spd1>MaxSpd){
          spd1 = MaxSpd;
      }
      this.Spd = spd1;
  }
   
  
  //setter for direction. In assignment it told us that animals ranged from 0-359 range,
  public void setDir(int Dir) {
      if (Dir > 360){
      	Dir = Dir - 360;
      }else if (Dir < 0){
      	Dir = Dir + 360;
      }
      this.Dir = Dir;
  }
   
  //additional details move()
  //page 6. It told us that we needed to determine the location as follows.
  public void move(int time){
      double x,y;
      double dist = getSpd() * (time/100);
      x = Math.cos(90  - getAnimalDir())*dist;
      y = Math.sin(getAnimalDir())*dist;
      super.setLocation((super.getLocationX()+x),(super.getLocationY()+y));
      if(super.getLocationX() >= getWIDTH()){
          super.setLocationX(getWIDTH()-(super.getSize()/2)+15);
      }else if(super.getLocationX() <= 0){
           super.setLocationX((super.getSize()/2)+15);
      }
      if(super.getLocationY() >= getHEIGHT()){
          super.setLocationX(getHEIGHT()-(super.getSize()/2)-15);
      }else if(super.getLocationY() <= 0){
           super.setLocationY((super.getSize()/2)+15);
      }
      if(super.getLocationX() >= getWIDTH()-(super.getSize()/2) || super.getLocationX() <= (super.getSize()/2) 
              || super.getLocationY() >= getHEIGHT()-(super.getSize()/2) || super.getLocationY() <= (super.getSize()/2)){
          setDir(getAnimalDir()-185);
      }else{
          Random r = new Random();
          int flag = r.nextInt(1);
          int move = r.nextInt(500);
          if(move < 20){
              if(flag == 1){
                  setDir(getAnimalDir()-5);
              }else{
                  setDir(getAnimalDir()+5);
              }
          }
      }
  }
   
  //needs to check if the animal is within the box.
  public boolean caught(double minX, double maxX, double minY, double maxY){
     double animalX = super.getLocationX();
     double animalY = super.getLocationY();
     return (animalX >= minX && animalX <= maxX)&&(animalY >= minY && animalY <= maxY);
  }


  
  //more values return
  public String toString() {
      return "loc=("+super.getLocationX()
      +", "+super.getLocationY()
      +") "+ super.rgbColor()
      +" size:" + super.getSize()
      +" speed:"+ getSpd()
      +" dir:"+ getAnimalDir();
  }
   
}