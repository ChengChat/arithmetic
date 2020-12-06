package graph.struct;

/**
 * 邻接表中的顶点的邻接结点
 */
public class EdgeNode {
    //邻接点域，存储该邻接点对应的下标
    private int adjvex;
    //用于存储权值，对于非网状图可以不需要
    private int weight;

    public EdgeNode(int adjvex, int weight) {
        this.adjvex = adjvex;
        this.weight = weight;
    }

    public int getAdjvex() {
        return adjvex;
    }

    public void setAdjvex(int adjvex) {
        this.adjvex = adjvex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
