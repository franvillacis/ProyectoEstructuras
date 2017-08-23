/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.Model;


import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import javafx.scene.layout.Priority;

/**
 *
 * @author FranciscoGuillermoVi
 */
public class GrafoNDLAD<E> {
    private List<Vertice> vertices;
    
    public GrafoNDLAD(){
        this.vertices= new LinkedList();
    }
    
    public boolean agregarVertice(E element){
        Vertice<E> v= new Vertice<>(element);
        if(vertices.contains(v)){
            return false;
        }
        else{
  
            return vertices.add(v);
       
        } 
    }
    public boolean agregarArco(E peso,E origen, E destino){
        Vertice<E> vo=getVertice(origen);
        Vertice<E> vd=getVertice(destino);
        if(vo!=null && vd!=null){
           Arco<E> arco= new Arco<>(peso,vo,vd);
           Arco<E> arco2= new Arco<>(peso,vd,vo);
           if(!vo.getArcos().contains(arco)){
               vo.getArcos().add(arco);
               vd.getArcos().add(arco2);
               return true;
           }
        }
        return false;
    }
            
    private Vertice<E> getVertice(E element){
        for(Vertice<E> vertice: vertices){
            if(vertice.equals(element)){
                return vertice;
            }
        }
        return null;
    }

    public LinkedList<E> bfs(E inicio){
        Vertice<E> vertice= getVertice(inicio);
        LinkedList<E> list= new LinkedList<>();
        Queue<Vertice> cola= new LinkedList<>();
        cola.offer(vertice);
        while(!cola.isEmpty()){
            Vertice<E> vertice2= cola.poll();
            for(Arco arco:vertice2.getArcos()){
                if(!arco.getDestino().getEstado()){
                    arco.getDestino().setEstado(true);
                    cola.offer(arco.getDestino());
                }
            }
            vertice2.setEstado(true);
            list.addLast(vertice2.getElement());
        }
        barrerEstados();
        return list;    
    }
    
    public List<E> dfs(E inicio){
        Vertice<E> vertice= getVertice(inicio);
        List<E> list= new LinkedList<>();
        Stack<Vertice> stack= new Stack<>();
        stack.push(vertice);
        while(!stack.isEmpty()){
            Vertice<E> vertice2= stack.pop();
            for(Arco arco:vertice2.getArcos()){
                if(!arco.getDestino().getEstado()){
                    arco.getDestino().setEstado(true);
                    stack.push(arco.getDestino());
                }
            }
            vertice2.setEstado(true);
            list.add(vertice2.getElement());
        }
        barrerEstados();
        return list;    
    }
    private void barrerEstados(){
        for(Vertice vertice:this.vertices){
            vertice.setEstado(false);
        }
    }
    
    public boolean esConexo(){
        List<Vertice> lista= (List<Vertice>) this.bfs((E) vertices.get(0).getElement());
        if(this.vertices.size()==lista.size()){
            return true;
        }
        return false;
    }
    
    private void dijkstra(Vertice<E> inicio){
        for(Vertice vertice:this.vertices){
            vertice.setDistancia(Integer.MAX_VALUE);
            vertice.setPrevious(null);
            vertice.setEstado(false);
        }
        inicio.setDistancia(0);
        PriorityQueue<Vertice<E>> cola= new PriorityQueue<>((Vertice<E> v1, Vertice<E> v2)->v1.getDistancia()-v2.getDistancia());
        cola.offer(inicio);
        while(!cola.isEmpty()){
              Vertice<E> verticeRef= cola.poll();
              
              for(Arco arco:verticeRef.getArcos()){
                  Vertice<E> verticeDestino=arco.getDestino();
                  if((!verticeDestino.getEstado())&&(verticeDestino.getDistancia()>verticeRef.getDistancia()+arco.getNumeroBacon())){
                      
                      verticeDestino.setDistancia(verticeRef.getDistancia()+arco.getNumeroBacon());
                    
                      verticeDestino.setPrevious(verticeRef);
                      cola.offer(verticeDestino);
                  }
              }
              
        }
    }
    
    public LinkedList<E> caminoMasCorto(E element1, E element2){
        LinkedList<E> ListaElementos= new LinkedList<>();
        dijkstra(getVertice(element1));
        Vertice<E>vertice=getVertice(element2);
        while(vertice.getPrevious()!=null){
            ListaElementos.addFirst(vertice.getElement());
            vertice=vertice.getPrevious();
        }
        ListaElementos.addFirst(vertice.getElement());
        return ListaElementos;
    }
    
            
    public int grado(E element){
        Vertice<E> vertice= getVertice(element);
        if(vertice==null){
            return -1;
        }
        int contador=0;
        for(Vertice<E> vert: this.vertices){
            for(Arco arco: vert.getArcos()){
                 if(vertice.equals(arco.getDestino())){
                     contador+=1;
                 }
            }
        }
        return contador;
    }
  
    public boolean esAdyacente(E element1, E element2){
        Vertice<E> vertice1= getVertice(element1);
        Vertice<E> vertice2= getVertice(element2);
        if(!vertices.contains(vertice1)||!vertices.contains(vertice2)){
            return false;
        }
         for(Arco arco: vertice1.getArcos()){
             for(Arco arco2: vertice2.getArcos()){
                 if (arco.getDestino().equals(arco2.getOrigen())||arco.getOrigen().equals(arco2.getDestino())){
                     return true;
                 }
             }
         }
         return false;
    }
    
    public boolean eliminarVertice(E element){
        Vertice<E> vertice= getVertice(element);
        if(!vertices.contains(vertice)||vertice==null){
            return false;
        }
        for(Vertice<E> vert: this.vertices){
                for(int i=0;i<vert.getArcos().size();i++){
                    if(vert.getArcos().get(i).getDestino().equals(vertice)){
                        
                        this.eliminarArco((E) vert.getArcos().get(i).getOrigen(),element);
                    }
                }
        }
        vertices.remove(vertice);
        return true;
    }
    
    public boolean eliminarArco(E element1, E element2){
        Vertice<E> verticeOrigen= getVertice(element1);
        Vertice<E> verticeDestino= getVertice(element2);
        if(verticeOrigen==null||verticeDestino==null){
            return false;
        }
        else{
            int arcosEliminados=0;
            for(Vertice<E> vert: this.vertices){
                for(int i=0;i<vert.getArcos().size();i++){
                    if(((vert.getArcos().get(i).getOrigen().equals(verticeOrigen))&&(vert.getArcos().get(i).getDestino().equals(verticeDestino)))||(((vert.getArcos().get(i).getOrigen().equals(verticeDestino))&&(vert.getArcos().get(i).getDestino().equals(verticeOrigen))))){
                        arcosEliminados+=1;
                        vert.getArcos().remove(i);
                        if(arcosEliminados==2){
                            return true;
                        }
                        
                    }
                }
            }
        }
        return false;
    }
    
    
    @Override
    public String toString() {
        String s="[";
        for(Vertice<E> vertice: this.vertices){
            s+="Vertice ";
            s+=vertice.getElement();
            s+=" Arcos[";
            for(Arco arco: vertice.getArcos()){
                s+="("+arco.getOrigen()+")"+"->"+"("+arco.getDestino()+"),";
            }
            s+="],";
        }
        s+="]";
        return s;
    }

}