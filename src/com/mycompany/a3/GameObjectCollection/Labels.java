package com.mycompany.a3.GameObjectCollection;

import com.codename1.ui.Display;
import com.codename1.ui.Label;

public class Labels extends Label{
    public Labels(String s){
        this.setText(s);
        style();
    }
  
    ////labels utilized for keeping track of score
    public void style(){
        int height = Display.getInstance().getDisplayHeight();
        int width = Display.getInstance().getDisplayWidth();
        if (height <= 641 && width <= 960)
            this.getAllStyles().setPadding(1, 0, 2, 2);
        else if (height <= 640 && width <= 1136)
            this.getAllStyles().setPadding(1, 0, 2, 2);
        else if (height <= 1136 && width <= 640)
            this.getAllStyles().setPadding(1, 0, 2, 2);
        else
            this.getAllStyles().setPadding(1, 1, 2, 5);
    }
}