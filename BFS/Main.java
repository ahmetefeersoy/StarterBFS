import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int museum = sc.nextInt();
        int road = sc.nextInt();
       // int[][] weightArr= new int[museum+1][museum+1];
        Graph GofMuseum = new Graph(museum);
        for(int i = 0;i<road;i++){
            int vertex1= sc.nextInt();
            int vertex2=sc.nextInt();
            int w1v2=sc.nextInt();
            GofMuseum.addEdge(vertex1,vertex2,w1v2);
        }

        int a =0,b=0;
        int totaltime=0;
        int time=Integer.MAX_VALUE;
        int index = 0;
        for(int t =1;t<=museum;t++) {

                BFS bfs1 = new BFS(GofMuseum, t);
            for (int i = 0; i < bfs1.path.size() - 1; i++) {
                a = bfs1.path.get(i);
                b = bfs1.path.get(i + 1);
                totaltime = totaltime + GofMuseum.weightArr[a][b];
            }
                if(totaltime<time)   {
                    index=t;
                }

        }


        int realtime=0;
        BFS bfs2= new BFS(GofMuseum, index);
        for (int i = 0; i < bfs2.path.size() - 1; i++) {
            a = bfs2.path.get(i);
            b = bfs2.path.get(i + 1);
            realtime = realtime + GofMuseum.weightArr[a][b];
        }
        System.out.println(realtime);
        for(int i =0;i<bfs2.path.size();i++){
            System.out.print(bfs2.path.get(i)+" ");
        }




    }
}