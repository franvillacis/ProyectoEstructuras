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
    
    private int peso;
    private Vertice<E> origen;
    private Vertice<E> destino;
    
    public Arco(int peso,Vertice<E> origen, Vertice<E> destino){
        this.peso=peso;
        this.origen=origen;
        this.destino=destino;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
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

    @Override
    public boolean equals(Object obj) {
    Arco<E> arco= (Arco) obj;
    return (this.origen.equals(arco.origen)&&this.destino.equals(arco.destino));
    
    }
    

    @Override
    public String toString() {
        return "Arco{" + "peso=" + peso + ", origen=" + origen + ", destino=" + destino + '}';
    }
    
    
}
