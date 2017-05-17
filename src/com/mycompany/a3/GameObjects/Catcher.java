package com.mycompany.a3.GameObjects;

import com.mycompany.a3.Interfaces.IGuideable;

public abstract class Catcher extends GameObject implements IGuideable{
    
	//declaration of max size of nets and min size of net
	//in prompt on page 4, it says size is to be 1000 max and 50 min.
	//size incremental values
	//the distance the net can move
	private static final int MAX_NET_SIZE = 1000; 
    private static final int MIN_NET_SIZE = 50;  
    private static final int NET_MOVEMENT = 50; 
    private static final int SIZE = 50;   
         

    //setter for move left
    public void moveLeft() {
        super.setLocationX(super.getLocationX()- NET_MOVEMENT);
    }

    //setter for move right
    public void moveRight() {
        super.setLocationX(super.getLocationX()+ NET_MOVEMENT);
    }

    //setter for move up
    public void moveUp() {
        super.setLocationY(super.getLocationY()- NET_MOVEMENT);
    }

    //setter for move down
    public void moveDown() {
        super.setLocationY(super.getLocationY() + NET_MOVEMENT);
    }
 
    //setter for moving net to random dog
    public void moveDog(Dog dog) {
       double x = dog.getLocationX();
       double y = dog.getLocationY();
       exchange(x,y);
    }

    //setter for moving net to random cat
    public void moveCat(Cat cat) {
       double x = cat.getLocationX();
       double y = cat.getLocationY();
       exchange(x,y);
    }

    //setter for increasing size of net
    public void expand(){
        NetSize(SIZE);
    }
    
    //setter for the decreasing size of net
    public void contract(){
        NetSize((SIZE*-1));
    }

    //method for changing size of net
    //Initializes size and gets current value of size from super.getSize() and passing a value
    //of size. Then compares it to 1000 and 50, making sure they are in bounds.
    private void NetSize(int value) {  
        int size = super.getSize()+value;
        if(size < MIN_NET_SIZE){              
            super.setSize(MIN_NET_SIZE);
        }else if(size > MAX_NET_SIZE){
            super.setSize(MAX_NET_SIZE);
        }else{
            super.setSize(size);
        }
    }

    //sets the location in the parent function
    private void exchange(double x, double y) {
       super.setLocationX(x);
       super.setLocationY(y);
    } 
     
}