package com.mycompany.a3.View;

import java.util.Observable;
import java.util.Observer;


import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;
import com.mycompany.a3.Game.GameWorld;
import com.mycompany.a3.GameObjectCollection.Labels;

//This is the score container at the top. It displays little information such as
//Dogs captured and cat's remaining ect.

public class ScoreView extends Container implements Observer {

	//Initializes the score labels
    private Labels totalPoints;
    private Labels catsCaptured;
    private Labels dogsCaptured;
    private Labels catsRemaining;
    private Labels dogsRemaining;
    private Labels sound;

    //scoreview initialization.
    public ScoreView(Observable gameWorld){
        gameWorld.addObserver(this);
        initLayout(gameWorld);
    }
    
    //initial layout for top of the gui
    public void initLayout(Observable o){
    	GameWorld gw = (GameWorld)o;
    	Container frame = new Container(new FlowLayout(CENTER));
    	totalPoints		= new Labels("Total Points: "+gw.getPoints());
    	frame.add(totalPoints);
    	catsCaptured 	= new Labels("Dogs Captured: "+gw.getCatsCaptured());
    	frame.add(catsCaptured);
    	dogsCaptured    = new Labels("Cats Captured: "+gw.getDogsCaptured());
    	frame.add(dogsCaptured);
    	catsRemaining 	= new Labels("Cats Remaining: "+gw.getRemainingCats());
        frame.add(catsRemaining);
    	dogsRemaining 	= new Labels("Dogs Remaining: "+gw.getRemainingDogs());
        frame.add(dogsRemaining);
        if (gw.getSound())
            sound = new Labels("Sound: ON");
        else
            sound = new Labels("Sound: OFF");
        frame.add(sound);
        this.add(frame);  
    }
    
    
    //updates the score
    public void update(Observable o, Object arg) {
        totalPoints.setText("Total Points:"+ ((GameWorld) o).getPoints());
        catsCaptured.setText("Cats Captured:"+((GameWorld) o).getCatsCaptured());
        dogsCaptured.setText ("Dogs Captured:"+((GameWorld) o).getDogsCaptured());
        catsRemaining.setText("Cats Remaining:"+((GameWorld) o).getRemainingCats());
        dogsRemaining.setText("Dogs Remaining:"+((GameWorld) o).getRemainingDogs());
        if(((GameWorld) o).getSound()){
            sound.setText("Sound: ON");
        }else{
            sound.setText("Sound: OFF");
        }
    }
}
    
  


   