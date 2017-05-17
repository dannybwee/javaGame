package com.mycompany.a3.GameObjectCollection;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Display;
import com.codename1.ui.plaf.Border;

public class Buttons extends Button{
        
	public Buttons (Command cmd){
            this.setCommand(cmd);
            style();
        }
        
		//ACTION INSTANCE
        public Buttons (String s){
            this.setText(s);
            style();
        }
        
        //Button styles
        public void style(){
            int height = Display.getInstance().getDisplayHeight();
            int width = Display.getInstance().getDisplayWidth();
            if (height <= 641 && width <= 960)
                this.getAllStyles().setPadding(1, 0, 1, 1);
            else if (height <= 640 && width <= 1136)
                this.getAllStyles().setPadding(1, 0, 0, 0);
            else if (height <= 1136 && width <= 640)
                this.getAllStyles().setPadding(1, 0, 0, 0);
            else
                this.getAllStyles().setPadding(3, 3, 3, 3);
            this.getUnselectedStyle().setBgTransparency(255);
            this.getUnselectedStyle().setBgColor(ColorUtil.GREEN);
            this.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
            this.getAllStyles().setBorder(Border.createLineBorder(1, ColorUtil.BLACK));
        }
    }