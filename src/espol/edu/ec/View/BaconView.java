/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.View;

import espol.edu.ec.Model.Bacon;
import java.util.LinkedList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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
    private TextField actor;
    private Button buscar;
    private HBox contenedor_search;
    private VBox contenedor_result;
    
    public BaconView() {
    
        Bacon grafo = new Bacon();
        
        this.titulo= new Label("Oracle of Bacon");
        this.titulo.setAlignment(Pos.CENTER);
        
        this.actor = new TextField();
        this.actor.setMaxWidth(200);
        
        this.buscar = new Button();
        this.buscar.setText("Buscar");
        this.buscar.setOnAction(e -> {
            if (!this.actor.getText().isEmpty()) {
                String idActor = grafo.getIdActor(this.actor.getText());
                this.root.getChildren().remove(this.contenedor_result);
                this.contenedor_result = new VBox();
                if (!idActor.equals("")) {
                    LinkedList<String> lista = grafo.baconsNumber(idActor);
                    for (String element : lista) {
                        Label l = new Label(element);
                        this.contenedor_result.getChildren().add(l);
                    }
                    
                } else {
                    Label l = new Label("No hay resultados.");
                    this.contenedor_result.getChildren().add(l);
                }
                this.contenedor_result.setAlignment(Pos.CENTER);
                this.root.getChildren().add(this.contenedor_result);
            }
        });
        
        this.contenedor_search=new HBox();
        this.contenedor_search.getChildren().addAll(this.actor, this.buscar);
        this.contenedor_search.setSpacing(20);
        this.contenedor_search.setAlignment(Pos.CENTER);
        
        this.contenedor_result = new VBox();
        this.contenedor_result.setAlignment(Pos.CENTER);
        
        this.root = new VBox(); 
        this.root.getChildren().addAll(this.titulo,this.contenedor_search, this.contenedor_result);
        this.root.setAlignment(Pos.CENTER);
        this.root.setSpacing(20);
        
    }

    public VBox getRoot() {
        return root;
    }
    
    
    
    
}
