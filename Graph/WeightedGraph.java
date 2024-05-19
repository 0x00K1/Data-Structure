public class WeightedGraph {
    public int[][] edge;
    public String[] vertice;
    public int eSize=0;
    public int vSize=0;

    public WeightedGraph(int size) {
        edge = new int[size][size];
        vertice=new String[size];
        eSize=vSize=size;
    }
    
    public int getEdgeSize(){
        return eSize;
    }
    
    public int getVertSize(){
        return vSize;
    } 
    
    public boolean isEdge(int Row, int Col){
        return edge[Row][Col]>0;
    }
    
    public void setVertice(int Row, String str){
        vertice[Row]=str;
    }
    
    public String getVertice(int Row){
        return vertice[Row];
    }
    
    public void setEdge(int Row, int Col, int Weight){
        edge[Row][Col]=Weight;
    }
    
    public int getEdge(int Row, int Col){
        return edge[Row][Col];
    }
    
    public void removeEdge(int Row, int Col){
        edge[Row][Col]=0;
    }
    
    public void countVertice(){
        int count;
        for (int Row=0; Row<vSize; Row++){
            count=0;
            for (int Col=0; Col<vSize; Col++)
                if(isEdge(Row, Col))
                    count++;
        
        System.out.println(vertice[Row]+": "+count);
        
        }
    }
    
    public void printVertice(){
        for (int Row=0; Row<vSize; Row++){
            System.out.println(vertice[Row]+"->");
            for (int Col=0; Col<vSize; Col++){
                if(isEdge(Row, Col))
                    System.out.println(vertice[Col]+": "+edge[Row][Col]+", ");
            }
        System.out.println();
        
        }
    }    
    
}