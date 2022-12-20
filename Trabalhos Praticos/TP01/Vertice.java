package TP01;
import java.util.ArrayList;

public class Vertice<Integer> {
    private Integer dado;
    private ArrayList<Aresta<Integer>> arestasEntrada;
    private ArrayList<Aresta<Integer>> arestasSaida;
    
    public Vertice(Integer valor){
        this.dado = valor;
        this.arestasEntrada = new ArrayList<Aresta<Integer>>();
        this.arestasSaida = new ArrayList<Aresta<Integer>>();
    }

    public Integer getDado() {
        return dado;
    }

    public void setDado(Integer dado) {
        this.dado = dado;
    }
    
    public void adicionarArestaEntrada(Aresta<Integer> aresta){
        this.arestasEntrada.add(aresta);
    }
    
    public void adicionarArestaSaida(Aresta<Integer> aresta){
        this.arestasSaida.add(aresta);
    }

    public ArrayList<Aresta<Integer>> getArestasEntrada() {
        return arestasEntrada;
    }

    public ArrayList<Aresta<Integer>> getArestasSaida() {
        return arestasSaida;
    }
    
    
}