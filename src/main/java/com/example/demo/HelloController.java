package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    //VARIABLES PARA EL JUEGO
    private int clicks=0, objective=10, points=0;
    @FXML
    private Label txObjective;
    @FXML
    private Label txClicks;
    @FXML
    private Label txPoint;
    //EL BOTÓN NO NECESITA UN ID, SINO TAN SOLO UN EVENTO (OBSERVA EN SCENE BUILDER)

    @FXML
    protected void onHelloButtonClick()
    {
        //AUMENTO EL NÚMERO TOTAL DE CLICKS Y MUESTRO POR PANTALLA
        clicks++;
        txClicks.setText(String.valueOf(clicks));
        if(objective <= clicks) //CUANDO LOS CLICKS SEAN IGUALES O MAYORES AL OBJETIVO, ESTE SE ACTUALIZARÁ
        {
//EL OBJETIVO ES EL NÚMERO DE CLICKS MAS 10 ELEVADO A LAS UNIDADES DE LOS CLICKS ACTUALES MENOS UNA
// (UNIDADES = 0, DECENAS = 1, CENTENAS=2, ETC...), DE MANERA QUE UNA UNIDAD MIDE 0,
// POR TANTO 10 ELEVADO A 1 ES 10 (10 clicks actuales+10==20)

            objective = (clicks+(int)Math.pow(10,String.valueOf(clicks).length()-1));
            //AUMENTO LOS PUNTOS EN UNO PUESTO QUE SE ALCANZÓ EL OBJETIVO Y MUESTRO EL NUEVO OBJETIVO POR PANTALLA
            points++;
            txObjective.setText(String.valueOf(objective));
        }
        //MUESTRO LOS PUNTOS
        txPoint.setText("Points: "+points);
    }
    /*NOTA IMPORTANTE:
    * SI BIEN SE PUEDE HACER NO MUY DIFÍCILMENTE, COMO NO SE PUEDE OBTENER MÁS DE UN CLICK A LA VEZ
    * EL OBJETIVO NO NECESITA AJUSTAR EL VALOR A LA UNIDAD.
    * ME EXPLICO: EN TIEMPO REAL, EL OBJETIVO AUMENTARÍA DE UNO EN UNO O DE 10 EN 10, ES DECIR, 20, 21, 22, ...
    * DE FORMA QUE AL ALCANZAR EL OBJETIVO, ESTE TOMARÁ EL VALOR EXACTO DE ESA ÚLTIMA ACTUALIZACIÓN (SI SON 20 CLICKS, EL OBJETIVO SERÁ 30)
    * SIN EMBARGO, SI PUDIESES ALCANZAR LA META CON 21 CLICKS, EL OBJETIVO SERÍA DE 31 CLICKS.
    */
}