package com.mycompany.a3.Interfaces;

import com.mycompany.a3.Game.GameWorld;

public interface ICollider {
	 public boolean collidesWith(ICollider other);
	    public void handleCollision(ICollider other,GameWorld gw);
}
