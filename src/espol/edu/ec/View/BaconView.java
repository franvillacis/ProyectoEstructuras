/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.View;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author FranciscoGuillermoVi
 */
public class BaconView {
    
    private VBox root;
    private Label titulo;
    private Label toL;
    private TextField actor;
    private TextField actor2;
    private HBox contenedor;
    
    public BaconView() {
    
        this.titulo= new Label("Oracle of Bacon");
        
        this.actor = new TextField();
        this.actor.setMaxWidth(200);
        
        this.actor2 = new TextField();
        this.actor2.setMaxWidth(200);
    
        this.toL= new Label("To");
        
        this.contenedor=new HBox();
        this.contenedor.getChildren().addAll(this.actor,this.toL,this.actor2);
        this.contenedor.setSpacing(20);
        
        this.root = new VBox();
        
        this.root.getChildren().add(this.titulo);
        this.titulo.setAlignment(Pos.CENTER);
        this.root.getChildren().add(this.contenedor);
        this.root.setSpacing(20);
        
    }

    public VBox getRoot() {
        return root;
    }
    
    
    
    
}
