/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.Proyecto;

import espol.edu.ec.Model.Bacon;
import espol.edu.ec.View.BaconView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author FranciscoGuillermoVi
 */
public class Main extends Application {
    BaconView bw;
    
    @Override
    public void start(Stage primaryStage) {
        bw=new BaconView();
        Scene scene = new Scene(bw.getRoot(), 500, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bacon grafo= new Bacon();
        grafo.fillGrafo();
        System.out.println("Ruta de bacon sirviendo");
        System.out.println(grafo.baconsNumber("1","3823"));
        launch(args);
    }
    
}
