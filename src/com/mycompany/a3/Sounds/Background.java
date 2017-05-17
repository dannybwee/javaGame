package com.mycompany.a3.Sounds;

import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;
import java.io.InputStream;

//background music
public class Background implements Runnable {
	 private Media m;
	    public Background (String filename){
	        try{
	            InputStream is = Display.getInstance().getResourceAsStream(getClass(),"/"+ filename);
	            m = MediaManager.createMedia(is,"audio/wav",this);
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	    }
	     
	    public void pause(){
	        m.pause();
	    }
	     
	    public void play(){
	        m.play();
	    }
	    public void run(){
	        m.setTime(0);
	        m.play();
	    }
}
