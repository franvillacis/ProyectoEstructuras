/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.Model;

import espol.edu.ec.Model.Vertice;
import espol.edu.ec.Proyecto.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author FranciscoGuillermoVi
 */
public class Bacon<E> {
    
    private GrafoNDLAD grafo;
    private HashMap<String,String> mapaActores;
    private HashMap<String,String> mapaPeliculas;
    private HashMap<String, LinkedList<String>> mapaPeliculaActores;
    private static final String fileActores="actores.txt";
    private static final String filePeliculas="peliculas.txt";
    private static final String filePeliculaActores="pelicula-actores.txt";
    
    public Bacon(){
        grafo= new GrafoNDLAD();
        mapaActores= Util.getMapa(fileActores);
        mapaPeliculas= Util.getMapa(filePeliculas);
        mapaPeliculaActores=Util.getMapaPeliculaActores(filePeliculaActores);
        
        this.fillGrafo();
    }
    
    public void fillGrafo(){
        for (String idActor : mapaActores.keySet()) {
            grafo.agregarVertice(idActor);
        }
        for (String idPelicula : mapaPeliculas.keySet()) {
            if (mapaPeliculaActores.containsKey(idPelicula)) {
                LinkedList<String> listaActores=mapaPeliculaActores.get(idPelicula);
                while(listaActores.size()>=2){
                    grafo.agregarArco(Integer.parseInt(idPelicula),listaActores.getFirst(),listaActores.get(1));
                    listaActores.removeFirst();
                }
            }
            
        }

    }
    
    public LinkedList<String> baconsNumber(String idActor2){
        LinkedList<String> lista= grafo.caminoMasCorto("1",idActor2);
        LinkedList<String> rutaBacon= new LinkedList();
        //El número de Bacon de Lisa Kudrow es 3.
        
        for (int i=0;i<lista.size()-1;i++) {
            String actor2 = mapaActores.get(lista.get(i));
            String actor1 = mapaActores.get(lista.get(i+1));
            String peliculaS = String.valueOf(grafo.getPeso(lista.get(i), lista.get(i+1)));
            String pelicula = mapaPeliculas.get(peliculaS);
            String resultado = actor1 + " aparecio en " + pelicula + " con " + actor2 + ".\n";
            rutaBacon.addFirst(resultado);
        }
        String resultado = "El número de Bacon de " + mapaActores.get(idActor2) + " es " + (lista.size() - 1) + ".\n";
        rutaBacon.addFirst(resultado);
        return rutaBacon;
    }
    
    public String getIdActor(String nombre) {
        String resultado = "";
        if (this.mapaActores.containsValue(nombre)) {
            Iterator it = mapaActores.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if (pair.getValue().equals(nombre)) {
                    return (String)pair.getKey();
                }
            }
        }
        return resultado;
    }
    
    public GrafoNDLAD getGrafo() {
        return grafo;
    }

    @Override
    public String toString() {
        return "GrafoBacon{" + "grafo=" + grafo + '}';
    }
}
