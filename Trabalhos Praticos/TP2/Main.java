public class Main {
    

    public static void main(String[] args) {

        
        // int graph[][] = {
        //     {0, 1, 1, 1},
        //     {1, 0, 1, 1},
        //     {1, 1, 0, 1},
        //     {1, 1, 1, 0}                   
        //     };

        int fonte = 0;
        int sumidouro = 999;

        int grafoCompleto[][] = GeraGrafoCompleto(1);
        int grafoRegular[][] = geraGrafoRegular(1);
        int grafoCiclico[][] = geraGrafoCiclico(1000);

        long start = System.nanoTime();

        FindPaths path = new FindPaths(grafoCiclico);
        path.achaCaminhosDisjuntos(fonte, sumidouro);

        long elapsed = System.nanoTime() - start;
        System.out.println("Execution time in milissegundos: " + elapsed/1000000);
    
    }

    //metodo para gerar grafo completo com n de vértices
    public static int[][] GeraGrafoCompleto(int vertices){
        int grafo[][] = new int[vertices][vertices];
        for(int i = 0; i < vertices; i++){
            for(int j = 0; j < vertices; j++){
                if(i == j){
                    grafo[i][j] = 0;
                }else{
                    grafo[i][j] = 1;
                }
            }
        }
        return grafo;
    }

    //método para gerar um grafo regular com n vértices
    public static int[][] geraGrafoRegular(int vertices){

        int grafo[][] = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
          for (int j = 0; j < vertices; j++) {
            if (i == j - 1 || j == i - 1) {
              grafo[i][j] = 1;
            } else if (i == vertices - 1 && j == 0) {
              grafo[i][j] = 1;
            } else if (j == vertices - 1 && i == 0) {
              grafo[i][j] = 1;
            } else {
              grafo[i][j] = 0;
            }
          }
        }
        return grafo;

    }

    //método para gerar grafos cíclicos de n vértices
    public static int[][] geraGrafoCiclico(int vertices){
        int grafo[][] = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
              if (i == j - 1) {
                grafo[i][j] = 1;
              } else if (i == vertices - 1 && j == 0) {
                grafo[i][j] = 1;
              } else {
                grafo[i][j] = 0;
              }
            }
          }
          return grafo;
    }





}

