package com.mycompany.a3.Game;


import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.UITimer;
import com.mycompany.a3.Commands.*;
import com.mycompany.a3.GameObjectCollection.Buttons;
import com.mycompany.a3.View.MapView;
import com.mycompany.a3.View.ScoreView;


public class Game extends Form implements Runnable{
   private GameWorld gw; 
   private MapView map;
   private ScoreView score;
   Container east, west;
   Toolbar header;
   Buttons pause;
   UITimer timer;
   private int time; 
   boolean wasFlipped;
   Buttons heal;
   
   //Initiate game world  as given in the assignment.
   public Game() {
	   gw = new GameWorld();
       map = new MapView(gw);
       score = new ScoreView(gw);
       init(gw,map, score);
       gw.init();
       setKeys();
       timer = new UITimer(this);
       time = 100;
       timer.schedule(time, true, this);
   }
   
   //Layout of the entire GUI.
   private void init(GameWorld gw,MapView map,ScoreView score){
	   toolbar(gw);
       this.setLayout(new BorderLayout());
       Container north = new Container(new FlowLayout(CENTER));
       north.add(score);
       Container south = new Container(new FlowLayout(CENTER));
       south.add(south());
       east = new Container(new FlowLayout(CENTER,CENTER));
       east.getAllStyles().setBorder(Border.createLineBorder(1,0));
       east.add(east());
       west = new Container(new FlowLayout(CENTER,CENTER));
       west.getAllStyles().setBorder(Border.createLineBorder(1,0));
       west.add(west());
       this.add(BorderLayout.NORTH,north);
       this.add(BorderLayout.CENTER,map);
       this.add(BorderLayout.EAST,east);
       this.add(BorderLayout.WEST,west);
       this.add(BorderLayout.SOUTH,south);
       this.show();
       gw.setMap(this.getWidth()-(east.getWidth()*2), map.getHeight());
       
   }
  
  
   
   
   //KEys
   public void setKeys(){
   addKeyListener('a', MoveToCatCommand.moveCat(gw));
   addKeyListener('o', MovetoDogCommand.moveDog(gw));
   addKeyListener('c', ContractCommand.contract(gw));
   addKeyListener('d', DownCommand.down(gw));
   addKeyListener('e', ExpandCommand.expand(gw));
   addKeyListener('f', FightCommand.fight(gw));
   addKeyListener('k', KittenCommand.kitten(gw));
   addKeyListener('l', LeftCommand.left(gw));
   addKeyListener('r', RightCommand.right(gw));
   addKeyListener('s', ScoopCommand.scoop(gw));
   addKeyListener('t', ClockTickCommand.ticked(gw));
   addKeyListener('u', UpCommand.up(gw));
   addKeyListener('x', QuitCommand.quit());
   }
   
   //Remove keys
   public void removeKeys(){
	   addKeyListener('a', MoveToCatCommand.moveCat(gw));
	   addKeyListener('o', MovetoDogCommand.moveDog(gw));
	   addKeyListener('c', ContractCommand.contract(gw));
	   addKeyListener('d', DownCommand.down(gw));
	   addKeyListener('e', ExpandCommand.expand(gw));
	   addKeyListener('f', FightCommand.fight(gw));
	   addKeyListener('k', KittenCommand.kitten(gw));
	   addKeyListener('l', LeftCommand.left(gw));
	   addKeyListener('r', RightCommand.right(gw));
	   addKeyListener('s', ScoopCommand.scoop(gw));
	   addKeyListener('t', ClockTickCommand.ticked(gw));
	   addKeyListener('u', UpCommand.up(gw));
	   addKeyListener('x', QuitCommand.quit());
	   }
   
   
   //Play button
   public void PlayButton(boolean set){
       east.setEnabled(set);
       west.setEnabled(set);
       map.setPaused(!set);
       if(set){
           if(wasFlipped){
               gw.setSound(wasFlipped);
               wasFlipped = false;
           }
           pause.setText("Pause");
           heal.setEnabled(!set);
       }else{
           pause.setText("Play");
           heal.setEnabled(!set);
           if(gw.getSound()){
               gw.setSound(wasFlipped);
               wasFlipped = true;
           }
       }
   } 
   
   
   //timer setting
   public void setTimer(boolean set){
       if(!set){
           timer.cancel();
       }else{
           timer.schedule(time, true, this);
       }
   }

   //Container for the toolbar on the left side.
   //This houses the about and quit options as well as toggle sound on or off.
   private void toolbar(GameWorld gw){
       Toolbar header = new Toolbar();
       setToolbar(header);
       header.setTitle("Dog Catcher Game");
       Command scoop = ScoopCommand.scoop(gw);
       Command soundCheck = SoundCommand.sound(gw); 
       Command about = AboutCommand.aboutCommand();
       Command exit = QuitCommand.quit();
       CheckBox soundCheckBox = new CheckBox("Sound");
       soundCheckBox.setCommand(SoundCommand.sound(gw));
       soundCheckBox.getAllStyles().setBgTransparency(255);
       soundCheckBox.getAllStyles().setBgColor(ColorUtil.LTGRAY);
       soundCheck.putClientProperty("SideComponent", soundCheckBox);
       header.addCommandToSideMenu(soundCheck);
       header.addCommandToSideMenu(scoop);
       header.addCommandToSideMenu(about);
       header.addCommandToSideMenu(exit);
       Command titleBarAreaItem2 =(GiveHelpCommand.help());
       header.addCommandToRightBar(titleBarAreaItem2);
   }
  
   
   
   //Right buttons
   private Container east(){
       Container east = new Container(new BoxLayout(BoxLayout.Y_AXIS));
       Buttons contract = new Buttons(ContractCommand.contract(gw));
       east.add(contract);
       Buttons down = new Buttons(DownCommand.down(gw));
       east.add(down);
       Buttons right = new Buttons(RightCommand.right(gw));
       east.add(right);
       Buttons moveCat = new Buttons(MoveToCatCommand.moveCat(gw));
       east.add(moveCat);
       Buttons scoop = new Buttons(ScoopCommand.scoop(gw));
       east.add(scoop);
       return east;
   }
   
   
   
   //left buttons
   private Container west(){
       Container west = new Container(new BoxLayout(BoxLayout.Y_AXIS));
       Buttons expand = new Buttons(ExpandCommand.expand(gw));
       west.add(expand);
       Buttons up = new Buttons(UpCommand.up(gw));
       west.add(up);
       Buttons left = new Buttons(LeftCommand.left(gw));
       west.add(left);
       Buttons moveDog = new Buttons(MovetoDogCommand.moveDog(gw));
       west.add(moveDog);
       return west;
   }
   
   //bottom buttons
   private Container south(){
       Container south = new Container(new FlowLayout(CENTER));
       heal = new Buttons(HealCommand.heal(gw));
       south.add(heal);
       heal.setEnabled(false);
       pause = new Buttons(PauseCommand.pause(this));
       south.add(pause);
       return south;
   } 
      
    //Button Class
    //This is the only class that utilizes buttons
    
    
   //tick
    public void run() {
        gw.tick(time);
        repaint();
    }
	
}