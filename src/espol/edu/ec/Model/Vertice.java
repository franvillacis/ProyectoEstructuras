/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.Model;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author FranciscoGuillermoVi
 */
public class Vertice <E> {
    E element;
    List<Arco> arcos;
    boolean estado;
    Vertice<E> previous;
    int distancia;
    
    
    public Vertice(E element){
        this.element=element;
        this.arcos=new LinkedList<>();
        this.previous=null;
        distancia=Integer.MAX_VALUE;
        
    }

    public Vertice<E> getPrevious() {
        return previous;
    }

    public void setPrevious(Vertice<E> previous) {
        this.previous = previous;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    
    public E getElement() {
        return element;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public void setElement(E element) {
        this.element = element;
    }

    public List<Arco> getArcos() {
        return arcos;
    }

    public void setArcos(List<Arco> arcos) {
        this.arcos = arcos;
    }

   

    
    
    @Override
    public boolean equals(Object obj) {
        return ((E)obj).equals(this.element);
    }

    @Override
    public String toString() {
        String s="";
        s+=element;
        return s;
    }
    
    
}
