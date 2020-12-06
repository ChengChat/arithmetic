package graph.struct;

/**
 * 图的邻接矩阵存储方式
 */
public class AdjacencyMatrix {
    //顶点数组
    private char[] vertex;
    //边数组
    private int[][] src;
    //顶点数和边数
    private int numVertexes,numEdges;

    public AdjacencyMatrix(char[] vertex, int[][] src,int numEdges) {
        this.vertex = vertex;
        this.src = src;
        this.numEdges = numEdges;
        this.numVertexes = vertex.length;
    }

    public char[] getVertex() {
        return vertex;
    }

    public void setVertex(char[] vertex) {
        this.vertex = vertex;
    }

    public int[][] getSrc() {
        return src;
    }

    public void setSrc(int[][] src) {
        this.src = src;
    }

    public int getNumVertexes() {
        return numVertexes;
    }

    public void setNumVertexes(int numVertexes) {
        this.numVertexes = numVertexes;
    }

    public int getNumEdges() {
        return numEdges;
    }

    public void setNumEdges(int numEdges) {
        this.numEdges = numEdges;
    }
}
