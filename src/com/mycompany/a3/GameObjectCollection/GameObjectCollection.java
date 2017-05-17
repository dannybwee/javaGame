package com.mycompany.a3.GameObjectCollection;
import com.codename1.ui.Dialog;
import com.mycompany.a3.GameObjects.Cat;
import com.mycompany.a3.Interfaces.ICollection;
import com.mycompany.a3.Interfaces.IIterator;

import java.util.ArrayList;
import java.util.List;


//Essentially what our game world was before. Moved the entire collection here
public class GameObjectCollection implements ICollection {
    protected List<Object> gameObjects;      
    
    //initializes the Game Object collection.
    public GameObjectCollection(){
        gameObjects = new ArrayList();
   }
    
    //Getter for the sound
    public boolean getSound() {
        return  (Boolean)gameObjects.get(6);
    }
    
    //Setter for the sound
    public void setSound(boolean sound) {
        gameObjects.set(6,(Object) sound);
    }    
    
    //Getter for the points
    public int getPoints() {
        return (Integer) gameObjects.get(1);
    }
    
    
    
    //Setter for the points
    public void setPoints(int points) {
        gameObjects.set(1,(Object) points);
    }
    
    //Getter for the dogs remaining
    public int getDogsCaptured() {
        return (Integer) gameObjects.get(2);
    }
    
    //setter for dogs remaining
    public void setDogsCaptured(int val) {
        gameObjects.set(2,(Object) val);
    }
    
    //getter for cats captured
    public int getCatsCaptured() {
        return (Integer) gameObjects.get(3);
    }
    
    //setter for cats captured
    public void setCatsCaptured(int val) {
        gameObjects.set(3,(Object) val);
    }
    
    //adds objects to the game collection
    public void add(Object item) {
        gameObjects.add(item);
    }
    
    
    //Setter for the clock
    public void setClock(int clock) {
        gameObjects.set(0,(Object) clock);
    }
    
    //amount of time that has passed
    public int TimePass() {
        return (Integer)gameObjects.get(0);
    }
    
    //Getter for dogs remaining
    public int getRemainingDogs(){
        return (Integer)gameObjects.get(4);
    }
    
    //Counter of dogs left in the world
    public void updateRemainingDogs(int val){
        gameObjects.set(4, val);
    }
 

    //Creates a new cat in the world and updates the counter.
    public void addCats(Cat cat) {
        gameObjects.add(cat);
        updateRemainingCats((Integer)gameObjects.get(5)+1);
    }
    
    //Remaining cats in the world
    public int getRemainingCats(){
        return (Integer)gameObjects.get(5);
    }

    //updates the amount of cats left
    public void updateRemainingCats(int val){
        gameObjects.set(5, val);
    }

  
   //The Iterator goes through the collection and see which is avaialble.
   public IIterator getIterator() {
      return new GameObjectIterator();
   }
   
   //get clock information. Almost forgot about it
   public int getClock() {
       return (Integer)gameObjects.get(0);
   }


   //itterator of objects
   private class GameObjectIterator implements IIterator {
       //index itterator is at
	   private int CurrIndex;

       //creates itterator
       public GameObjectIterator(){
           CurrIndex = -1;
       }
       
       //checks the next element on the list
       public boolean hasNext() {
            if (gameObjects.size() <=0)
               return false;
            else return CurrIndex != gameObjects.size()-1;
       }

       
      //returns item on next list 
       public Object getNext() {
           if(hasNext())
                return gameObjects.get(++CurrIndex);
           else
                return -1;
       }

       //sees the object remove, then removes it
       public Object remove() {
           return gameObjects.remove(CurrIndex--);
       }
       
       //information on removal of dog
       //once the final score is 0. shows dialog 
       public Object removalDog(int points) {
    	   setDogsCaptured((Integer)getDogsCaptured()+1);
           setPoints((Integer)getPoints()+points);
           updateRemainingDogs(getRemainingDogs()-1);
           if (getRemainingDogs() == 0)
           {
           		Dialog.show( "Game Over","Final Score: " + getPoints(), null, null);
           }
           return gameObjects.remove(CurrIndex--);
       }
       
       //Update information when removal of cat.
       public Object removalCat() {
           setCatsCaptured((Integer)getCatsCaptured()+1);
           setPoints((Integer)getPoints()-10);
           updateRemainingCats(getRemainingCats()-1);
           return gameObjects.remove(CurrIndex--);
       }

   }

}



