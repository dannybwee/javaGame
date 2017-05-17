package com.mycompany.a3.Game;

//Java Imports
import java.util.Observable;
import java.util.Random;

import com.codename1.ui.Dialog;
import com.mycompany.a3.GameObjectCollection.GameObjectCollection;
import com.mycompany.a3.GameObjects.*;
import com.mycompany.a3.Interfaces.ICollider;
import com.mycompany.a3.Interfaces.IIterator;
import com.mycompany.a3.Sounds.Background;
import com.mycompany.a3.Sounds.Sound;


//initial creation of Game world. 
//making initial dogs, cats, and nets to set to a certain number
//below I have pseudocode / code for asking for initial dogs. But for now, I put the inital number
//of cats and dogs
public class GameWorld extends Observable{
	
	private GameObjectCollection gameObjectCollection;
	private int DOG = 2;
	private int CAT = 2;
	private int width;
    private int height;
    private Sound catCollide;
    private Sound dogCollide;
    private Background loop;
    private Sound scoop;
    
    //This allows the initialization of GameWorld
    protected GameWorld(){
    	 loop = new Background("Dreamland.mp3");
         scoop = new Sound("Scoop.mp3");
         dogCollide = new Sound("Bark.mp3");
         catCollide = new Sound("Meow.mp3");
    	gameObjectCollection = new GameObjectCollection();
        gameObjectCollection.add(0);                    
        for(int i = 1; i < 6; i++){     
            if (i<4){                  
                gameObjectCollection.add(0);           
            }else if (i==4){
                gameObjectCollection.add(DOG);
            }else if (i==5){
                gameObjectCollection.add(CAT);
            }
        }
        gameObjectCollection.add(false);
    }
    
    //initial layout
	public void init() {

		gameObjectCollection.add(new Net(width,height));
        for(int i = 0; i <DOG; i++){
            gameObjectCollection.add(new Dog(width,height));
            
        }
        for(int i = 0; i <CAT; i++){
            gameObjectCollection.add(new Cat(width,height));
        } 

	}

	//allows for updating of Width and Height
	 public void setMap(int width, int height){
	        this.width = width;
	        this.height = height;
	    }
	
	// expand method of nets
		public void expand() {
			getNets().expand();
			setChanged();
	        notifyObservers();
		}

		// contract method of nets
		public void contract() {
			getNets().contract();
			setChanged();
	        notifyObservers();
		}

		// move right method of net
		public void moveRight() {
			getNets().moveRight();
			setChanged();
	        notifyObservers();
		}

		// move left method of net
		public void moveLeft() {
			getNets().moveLeft();
			setChanged();
	        notifyObservers();
		}

		// move up method of net
		public void moveUp() {
			getNets().moveUp();
			setChanged();
	        notifyObservers();
		}

		// move down method of net
		public void moveDown() {
			getNets().moveDown();
			setChanged();
	        notifyObservers();
		}
	
	//getter of cats captured
	 public int getCatsCaptured() {
	        return gameObjectCollection.getCatsCaptured();
	}
	
	 //getter of remaining cats
	public int getRemainingCats() {
	        return gameObjectCollection.getRemainingCats();
	}
	 
	//getter of remaining dogs
	public int getRemainingDogs() {
	        return gameObjectCollection.getRemainingDogs();
	}
	 
	//getter of dogs captured
	public int getDogsCaptured() {
	        return gameObjectCollection.getDogsCaptured();
	}
	
	//gets the points you obtained
	public int getPoints() {
	        return gameObjectCollection.getPoints();
	}
	
	
	//getter for sound
	public boolean getSound() {
        return gameObjectCollection.getSound();
    } 
	
	//setter for sound.
	 public void setSound(boolean sound) {
		 gameObjectCollection.setSound(sound);
	        if(sound){
	            loop.play();
	        }else{
	            loop.pause();
	        }
	        setChanged();
	        notifyObservers();
	    } 
	
	

	// move cat method of cat to move to random cat
	public void moveCat() {
		 Random r = new Random();
	        int temp;
	        if(gameObjectCollection.getRemainingCats()>0){
	            temp = r.nextInt(gameObjectCollection.getRemainingCats());
	            getNets().moveCat(getCats(temp));
	        } else
	            System.out.println("No more Cats");
	        setChanged();
	        notifyObservers();
	}

	// gets cat at the index of the array
		public Cat getCats(int idx) {
			int counter = 0;
	        Object x = null;
	        IIterator iterator = gameObjectCollection.getIterator();
	        while (iterator.hasNext() && counter < gameObjectCollection.getRemainingCats()){
	            x = iterator.getNext();
	            if(x instanceof Cat && counter == idx){
	                return (Cat)x;
	            }else if(x instanceof Cat){
	                counter++;
	            }
	        }
	        return (Cat)x;
	    }
	
	
	// move method for dog to move to random dog
	public void moveDog() {
		 Random r = new Random();
	        int temp;
	        if(gameObjectCollection.getRemainingDogs()>0){
	            temp = r.nextInt(gameObjectCollection.getRemainingDogs());
	            getNets().moveDog(getDogs(temp));
	        } else
	            System.out.println("No more Dogs");
	        setChanged();
	        notifyObservers();
	}


	// gets dog at the index of the array
	public Dog getDogs(int dog) {
		int counter = 0;
        Object x = null;
        IIterator iterator = gameObjectCollection.getIterator();
        while (iterator.hasNext() && counter < gameObjectCollection.getRemainingDogs()){
            x = iterator.getNext();
            if(x instanceof Dog && counter == dog){
                return (Dog)x;
            }else if(x instanceof Dog){
                counter++;
            }
        }
        return (Dog)x;
    }

	
	//returns net to list
	private Net getNets() {
        Object x = null;
        IIterator iterator = gameObjectCollection.getIterator();
        while (iterator.hasNext()){
            x = iterator.getNext();
            if(x instanceof Net)
                return (Net) x;
        }
        return (Net) x;
    }
	

	// allows animals to move per tick
	public void tick(int time) {
        gameObjectCollection.setClock(gameObjectCollection.getClock()+1);
        Object x;
        Animal y,q;
        ICollider z;
        IIterator iterator = gameObjectCollection.getIterator();
        while(iterator.hasNext()){
            IIterator it = gameObjectCollection.getIterator();
            x = iterator.getNext();
            if(x instanceof Animal){
                y = (Animal)x;
                q = y;
                y.move(time);
                z = (ICollider) y;
                while(it.hasNext()){
                    x = it.getNext();
                    if(x instanceof Animal && x != z){
                        y = (Animal)x;
                        if(y.getChecked()==false){
                            if(z.collidesWith((ICollider)y)){
                                z.handleCollision((ICollider)y,this);
                            }
                        }
                    }
                }
                y.setChecked(true);
            }   
        setChanged();
        notifyObservers();
        }
        resetChecked();
    }
	
	//moves through animals and see if their value is false 	
	public void resetChecked() {
		   IIterator iterator = gameObjectCollection.getIterator();
	        Object x;
	        while (iterator.hasNext()){
	            x = iterator.getNext();
	            if(x instanceof Animal ){
	                if(x instanceof Cat ){
	                    Cat ani = (Cat)x;
	                    if (ani.getBorn()<15){
	                        ani.setChecked(true);
	                    }else{
	                        ani.setChecked(false);
	                    }
	                }else{
	                    Animal y = (Animal) x;
	                    y.setChecked(false);
	                }
	            }
	        }
    }    
	

	// allows cats to "reproduce" and adds another random cat
	public void KittenCat() {
		Random rand = new Random();
		int cat1 = rand.nextInt(gameObjectCollection.getRemainingCats());
        int cat2 = rand.nextInt(gameObjectCollection.getRemainingCats());
        while (cat2 == cat1){
        	cat2 = rand.nextInt(gameObjectCollection.getRemainingCats());
        }
        Cat one = getCats(cat1);
        Cat two = getCats(cat2);
        if(rand.nextInt(2)==1){
        	gameObjectCollection.addCats(new Cat(two.getLocationX(),two.getLocationY(),width,height));
        }else{
            gameObjectCollection.addCats(new Cat(one.getLocationX(),one.getLocationY(),width,height));
        }
        
		setChanged();
        notifyObservers();
	}
	
	 //checks if the cats collide
	 public void KittenCat(Cat one, Cat two){
	        Random r = new Random();
	        if(r.nextInt(2)==1){
	            gameObjectCollection.addCats(new Cat(two.getLocationX(),two.getLocationY(),width,height));
	        }else{
	            gameObjectCollection.addCats(new Cat(one.getLocationX(),one.getLocationY(),width,height));
	        }
	        if(gameObjectCollection.getSound()){
	            catCollide.play();
	        }
	        setChanged();
	        notifyObservers();
	    }

	
	 //check for dog collision
	 public void fight(Dog one){
	        one.scratched();
	        if(gameObjectCollection.getSound()){
	            dogCollide.play();
	        }
	        setChanged();
	        notifyObservers();
	    }   
	 
	// fight between dog and cat.
	public void fight() {
		Random r = new Random();
		Dog one = getDogs(r.nextInt(gameObjectCollection.getRemainingDogs()));
		if (gameObjectCollection.getRemainingCats() <= 0) {
			System.out.println("Error: No cats");
		} else {
			one.scratched();
		}
		 setChanged();
	     notifyObservers();
	}

	public void heal(Dog dog){
        dog.heal();
        setChanged();
        notifyObservers();
    }
	
	// scoop method. Checks to see if any object is under the net. If it is it
	// then
	// calls
	public void scoop() {
		 IIterator iterator = gameObjectCollection.getIterator();
	        getNets().scoop(iterator);
	        if(gameObjectCollection.getSound()){
	            scoop.play();
	        }
	        setChanged();
	        notifyObservers();

	}


	
	// this method prints statistics left, location of cats/dogs/colors/ect
	public void map(){
		Object x;
	    IIterator iterator = gameObjectCollection.getIterator();
	    System.out.println("MAP______________________________________");
	    while(iterator.hasNext()){
	        x = iterator.getNext();
	         if(x instanceof Net){
	            Net grabber = (Net)x;
	            System.out.println("Net: "+ grabber.toString());
	         }
	         else if(x instanceof Dog){
	            Dog grabber = (Dog)x;
	            System.out.println("Dog: "+ grabber.toString());
	        }
	         else if(x instanceof Cat){
	            Cat grabber = (Cat)x;
	            System.out.println("Cat: "+ grabber.toString());
	        }
	    }
	    System.out.println("_________________________________________");
	    }

	
		public IIterator iterator(){
        IIterator iterator = gameObjectCollection.getIterator();
        return iterator;
    }


}