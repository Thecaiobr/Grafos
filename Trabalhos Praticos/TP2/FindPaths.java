import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class FindPaths{


    static int vertices;
    int graph[][];

    FindPaths(int[][] graph){
        this.graph = graph;
        vertices = graph[0].length;
    }


     public boolean buscaEmLargura(int grafo[][],int fonte, int sumidouro, int parente[]){

        boolean visitado[] = new boolean[vertices];
        Queue<Integer> fila = new LinkedList<>();
        fila.add(fonte);
        visitado[fonte] = true;
        parente[fonte] = -1;

        while(!fila.isEmpty()){
            //encontrando o primeiro elemento da fila
            int atual = fila.peek();
            //removendo o primeiro elemento da fila
            fila.remove();

            for(int v = 0; v < vertices;v++){
                //checando se o vértice v ainda não foi visitado e se há caminho do atual até ele
                if(visitado[v] == false && grafo[atual][v] > 0){
                    fila.add(v);
                    parente[v] = atual;
                    visitado[v] = true;
                }
            }

        }

        //se há caminho da fonte até o sumidouro, retorna verdadeiro
        return(visitado[sumidouro] == true);
        
     }

     public void achaCaminhosDisjuntos(int fonte, int sumidouro){

        //criando grafo residual
        int grafoResidual[][] = new int[vertices][vertices];
        for(int u = 0; u < vertices; u++){
            for(int v = 0; v < vertices; v++){
                grafoResidual[u][v] = graph[u][v];
            }
        }

        //vetor para marcar o parente de cada vértice na busca em largura
        int parente[] = new int[vertices];

        int maximoCaminhos = 0;
        String [] caminhos = new String[10000];

        //se ainda existir caminho entre a fonte e o sumidouro:
        while(buscaEmLargura(grafoResidual,fonte, sumidouro, parente)){

            int fluxoCaminho = 10000000;

            int u;

            //fazendo o caminho reverso
            for(int v = sumidouro; v != fonte; v = parente[v]){
                u = parente[v];
                //checagem se há mesmo um caminho entre a fonte e o sumidouro no grafo residual
                fluxoCaminho = Math.min(fluxoCaminho, grafoResidual[u][v]);
            }

            String e, r;
            for(int v = sumidouro; v != fonte; v = parente[v]){
                u = parente[v];
                //invertendo as arestas já utilizadas no grafo residual
                grafoResidual[u][v] -= fluxoCaminho;
                grafoResidual[v][u] += fluxoCaminho;
                if(fluxoCaminho > 0){   
                    e = "" + v;  
                    r = "" + u;                               
                    caminhos[maximoCaminhos] += " " + new StringBuilder(e).reverse().toString() + "-" + new StringBuilder(r).reverse().toString();
                }

            }

            maximoCaminhos += fluxoCaminho;


        }

        imprimeCaminhos(caminhos,maximoCaminhos);

     }

     public void imprimeCaminhos(String caminhos[], int maximoCaminhos){

        System.out.println("Caminhos: ");
        for(int a = 0; a < caminhos.length; a++){
            if(caminhos[a] != null)
            System.out.println((new StringBuilder(caminhos[a]).reverse().toString().replaceAll("llun", " ")));
        }
        System.out.println("Maximo de Caminhos Disjuntos em Arestas no Grafo: " + maximoCaminhos);

     }


}