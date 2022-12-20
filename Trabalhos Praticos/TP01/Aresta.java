package TP01;

public class Aresta<Integer> {
    
    private Vertice<Integer> inicio;
    private Vertice<Integer> fim;
    
    public Aresta(Vertice<Integer> inicio, Vertice<Integer> fim){
        
        this.inicio = inicio;
        this.fim = fim;
    }

    public Vertice<Integer> getInicio() {
        return inicio;
    }

    public void setInicio(Vertice<Integer> inicio) {
        this.inicio = inicio;
    }

    public Vertice<Integer> getFim() {
        return fim;
    }

    public void setFim(Vertice<Integer> fim) {
        this.fim = fim;
    }
    
    
}