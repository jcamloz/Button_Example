package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    private int clicks=0;
    private int objective=10;
    private int points=0;
    @FXML
    private Label text2;
    @FXML
    private Label text1;
    @FXML
    private Label text3;

    @FXML
    protected void onHelloButtonClick()
    {
        clicks++;
        text2.setText(String.valueOf(clicks));
        if(objective <= clicks)
        {

            objective = (clicks+(int)Math.pow(10,String.valueOf(clicks).length()-1));
                points++;
        }
        text1.setText(String.valueOf(objective));
        text3.setText("Points: "+points);
    }
}