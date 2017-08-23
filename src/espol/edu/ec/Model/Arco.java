/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.Model;

/**
 *
 * @author FranciscoGuillermoVi
 */
public class Arco <E>{
    
    private E peso;
    private Vertice<E> origen;
    private Vertice<E> destino;
    private int numeroBacon;
    
    public Arco(E peso,Vertice<E> origen, Vertice<E> destino){
        this.peso=peso;
        this.origen=origen;
        this.destino=destino;
        this.numeroBacon=1;
    }

    public E getPeso() {
        return peso;
    }

    public void setPeso(E peso) {
        this.peso = peso;
    }

    public Vertice<E> getOrigen() {
        return origen;
    }

    public void setOrigen(Vertice<E> origen) {
        this.origen = origen;
    }

    public Vertice<E> getDestino() {
        return destino;
    }

    public void setDestino(Vertice<E> destino) {
        this.destino = destino;
    }
     public int getNumeroBacon() {
        return numeroBacon;
    }

    public void setNumeroBacon(int numeroBacon) {
        this.numeroBacon = numeroBacon;
    }

    @Override
    public boolean equals(Object obj) {
    Arco arco= (Arco) obj;
    return (this.origen.equals(arco.origen)&&this.destino.equals(arco.destino));
    
    }
    

    @Override
    public String toString() {
        return "Arco{" + "peso=" + peso + ", origen=" + origen + ", destino=" + destino + '}';
    }
    
    
}
