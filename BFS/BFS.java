import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BFS
{
    private boolean[] marked;
    private int[] edgeTo;
    public int[] distTo;

    public ArrayList<Integer> path = new ArrayList<Integer>();

    public int count;


    public BFS(Graph g , int home) {
        marked = new boolean[g.V()+1];
        edgeTo = new int[g.V()+1];
        distTo = new int[g.V()+1];
        bfs(g,home);
    }


    public int checkSmallestOld(Graph g, int v, int[][] weightArr) {
        int minWeight = Integer.MAX_VALUE;
        int nextVertex = -1;

        for (int w : g.adj(v)) {
            int weight = weightArr[v][w];
            if (weight < minWeight) {
                minWeight = weight;
                nextVertex = w;
            }
        }

        return nextVertex;
    }

    public int checkSmallest(Graph g, int v, int[][] weightArr, boolean marked[]) {
        int minWeight = Integer.MAX_VALUE;
        int nextVertex = -1;

        for (int w : g.adj(v)) {
            ArrayList arrayList = (ArrayList) g.adj(v);
            if(marked[w]==true&&arrayList.size()>1){
                continue;
            }
            int weight = weightArr[v][w];
            if (weight < minWeight) {
                minWeight = weight;
                nextVertex = w;
            }
        }

        return nextVertex;
    }


    private void bfs(Graph G, int home) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(home);
        marked[home] = true;
        distTo[home] = 0;
        path.add(home);


        while (!q.isEmpty()) {
            boolean control=true;
            for(int i =1;i< marked.length;i++){
                if(marked[i]==false)
                    control=false;
            }
            if(control!=false)
                break;;
            int v = q.poll();
            int nextVertex = checkSmallest(G, v, G.weightArr,marked);

            if (nextVertex != -1) {
                path.add(nextVertex);
                q.offer(nextVertex);
                marked[nextVertex] = true;
                edgeTo[nextVertex] = v;
                distTo[nextVertex] = distTo[v] + G.weightArr[v][nextVertex];
            }
        }
    }



  /*  private void bfs(Graph G,int home) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(home);
        marked[home] = true;
        distTo[home] = 0;
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    q.offer(w);
                    marked[w] = true;
                    int count = G.weightArr[w][v];
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + count;
                }
            }
        }
    }*/
}