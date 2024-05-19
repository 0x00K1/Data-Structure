public class WeightedGraphTest {

    public static void main(String[] args) {
        
        WeightedGraph wg = new WeightedGraph(5);
        int r=0; 
        
        wg.setVertice(r++, "A");
        wg.setVertice(r++, "B");
        wg.setVertice(r++, "C");
        wg.setVertice(r++, "D");
        wg.setVertice(r++, "E");

        wg.setEdge(0, 1, 4);
        wg.setEdge(0, 4, 7);
        wg.setEdge(1, 0, 4);
        wg.setEdge(1, 2, 1);
        wg.setEdge(1, 3, 2);
        wg.setEdge(2, 1, 1);
        wg.setEdge(2, 3, 6);
        wg.setEdge(3, 1, 2);
        wg.setEdge(3, 2, 6);
        wg.setEdge(4, 0, 7);
       
        System.out.println(" -- Print the vertices of the Graph");
        wg.printVertice();
        
        System.out.println("-- Print the number of connected vertices of the Graph");
        wg.countVertice();
    }
}