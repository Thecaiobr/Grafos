package TP01;
import java.util.ArrayList;
import java.util.List;


public class Grafo<Integer> {
    private ArrayList<Vertice<Integer>> vertices;
    private ArrayList<Aresta<Integer>> arestas;
    
    public Grafo(){
        this.vertices = new ArrayList<Vertice<Integer>>();
        this.arestas = new ArrayList<Aresta<Integer>>();
    }
    
    public void adicionarVertice(Integer dado){
        Vertice<Integer> novoVertice = new Vertice<Integer>(dado);
        this.vertices.add(novoVertice);
    }
    
    public void adicionarAresta( Integer dadoInicio, Integer dadoFim){
        Vertice<Integer> inicio = this.getVertice(dadoInicio);
        Vertice<Integer> fim = this.getVertice(dadoFim);
        Aresta<Integer> aresta = new Aresta<Integer>(inicio, fim);
        inicio.adicionarArestaSaida(aresta);
        fim.adicionarArestaEntrada(aresta);
        this.arestas.add(aresta);
    }
    
    public Vertice<Integer> getVertice(Integer dado){
        Vertice<Integer> vertice = null;
        for(int i=0; i < this.vertices.size(); i++){
            if (this.vertices.get(i).getDado().equals(dado)){
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }
    
    
    
}