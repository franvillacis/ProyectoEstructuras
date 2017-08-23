/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.Model;

import espol.edu.ec.Proyecto.Util;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author FranciscoGuillermoVi
 */
public class Bacon<E> {
    
    private GrafoNDLAD grafo;
    private HashMap<String,String> mapaActores;
    private HashMap<String,String> mapaPeliculas;
    private HashMap<String, LinkedList<String>> mapaPeliculaActores;
    private static final String fileActores="actores-test.txt";
    private static final String filePeliculas="peliculas-test.txt";
    private static final String filePeliculaActores="pelicula-actores-test.txt";
    
    public Bacon(){
        grafo= new GrafoNDLAD();
        mapaActores= Util.getMapa(fileActores);
        mapaPeliculas= Util.getMapa(filePeliculas);
        mapaPeliculaActores=Util.getMapaPeliculaActores(filePeliculaActores);
    }
    
    public void fillGrafo(){
        for (String idActor : mapaActores.keySet()) {
            grafo.agregarVertice(idActor);
        }
        for (String idPelicula : mapaPeliculas.keySet()) {
            LinkedList<String> listaActores=mapaPeliculaActores.get(idPelicula);
            while(listaActores.size()>=2){
                grafo.agregarArco(idPelicula,listaActores.getFirst(),listaActores.get(1));
                listaActores.removeFirst();
            }
        }

    }
    
    public LinkedList<E> baconsNumber(String idActor, String idActor2){

        LinkedList<E> rutaBacon= grafo.caminoMasCorto(idActor,idActor2);
        return rutaBacon;
    }
    public GrafoNDLAD getGrafo() {
        return grafo;
    }

    @Override
    public String toString() {
        return "GrafoBacon{" + "grafo=" + grafo + '}';
    }
    
    
    
}
