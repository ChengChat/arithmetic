package graph.struct;

/**
 * 邻接表
 */
public class AdjacencyList {
    //顶点表结点
    private VertexNode[] vertexNodes;
    //顶点数和边数
    private int numVertexes,numEdges;

    public AdjacencyList(VertexNode[] vertexNodes, int numEdges) {
        this.vertexNodes = vertexNodes;
        this.numEdges = numEdges;
        this.numVertexes = vertexNodes.length;
    }

    public VertexNode[] getVertexNodes() {
        return vertexNodes;
    }

    public void setVertexNodes(VertexNode[] vertexNodes) {
        this.vertexNodes = vertexNodes;
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
