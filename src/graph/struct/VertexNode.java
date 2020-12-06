package graph.struct;

import java.util.LinkedList;

/**
 * 邻接表的顶点，由一个顶点和一个链表构成。链表中存放了所有该顶点的邻接点
 */
public class VertexNode {
    //该顶点的数据
    private char data;
    //该顶点的入度，这个属性只用于求拓扑排序
    private int in;
    //该顶点的所有邻接点
    private LinkedList<EdgeNode> adjvexList = new LinkedList<>();

    public VertexNode(char data) {
        this.data = data;
    }

    public VertexNode(char data, int in) {
        this.data = data;
        this.in = in;
    }

    public VertexNode addAdjvex(int adjvex){
        return addAdjvex(adjvex,1);
    }

    public VertexNode addAdjvex(int adjvex,int weight){
        this.adjvexList.add(new EdgeNode(adjvex,weight));
        return this;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public int getIn() {
        return in;
    }

    public void setIn(int in) {
        this.in = in;
    }

    public LinkedList<EdgeNode> getAdjvexList() {
        return adjvexList;
    }

    public void setAdjvexList(LinkedList<EdgeNode> adjvexList) {
        this.adjvexList = adjvexList;
    }
}
