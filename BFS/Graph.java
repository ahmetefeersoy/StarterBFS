import java.util.ArrayList;


public class Graph {

    static int count;
    private final int V;
    private ArrayList <Integer>[] adj;
    public int[][] weightArr;
    public Graph(int V)
    {
        weightArr = new int[V+1][V+1];
        this.V = V;
        adj = (ArrayList<Integer>[]) new ArrayList[V+1];
        for (int v = 0; v < V+1; v++)
            adj[v] = new ArrayList<Integer>();

    }
    public void addEdge(int v, int w, int weight)
    {
        int a ,b;
        a=v;
        b=w;
        weightArr[v][w]=weight;
        weightArr[w][v]=weight;
        adj[a].add(b);
        adj[b].add(a);
    }

    public  void selectionSort(ArrayList<Integer> arr, int v) {

        int minValue= weightArr[v][adj[v].get(1)];
        for(int i =2;i<=adj.length;i++){
            int weight=weightArr[v][adj[v].get(i)];
            if(weight<minValue){
                minValue=weight;
                Integer temp;
                temp =adj[v].get(1);
                adj[v].add(1,adj[v].get(i));
                adj[v].add(i,temp);
            }
        }




        int n = arr.size();


    }

    /*public Iterable<Integer> adj(int v)
    {int n =adj[v].size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (weightArr[v][adj[v].get(j)] < weightArr[v][adj[v].get(minIndex)]) {
                    minIndex = j;
                }
            }

            int temp = adj[v].get(minIndex);
            adj[v].set(minIndex, adj[v].get(i));
            adj[v].set(i, temp);
        }

        return adj[v];}*/

    public Iterable<Integer> adj(int v)
    { return adj[v]; }

    public static int degree(Graph G, int v)
    {
        int degree = 0;
        for (int w : G.adj(v))
            degree++;
        return degree;
    }

    public int V(){
        return this.V;
    }
}
