package com.mycompany.a3.Interfaces;

import com.mycompany.a3.GameObjects.Cat;
import com.mycompany.a3.GameObjects.Dog;

//forces the catcher class to implement these methods. In essence, it's more of the 
//"Controllable" characters
public interface IGuideable {
	public void moveLeft();
	public void moveRight();
	public void moveUp();
	public void moveDown();
	public void moveDog(Dog dog);
	public void moveCat(Cat cat);
}