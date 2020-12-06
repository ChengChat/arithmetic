package offer.base.question09;

/**
 * 面试题9：用两个栈实现队列
 * 题目：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail和deleteHead，
 * 分别完成在队列尾部插入结点和在队列头部删除结点的功能。
 */
public class Main {
    public static void main(String[] args) throws Exception {
        QueueWithTwoStacks queue = new QueueWithTwoStacks();
        queue.appendTail('a');
        queue.appendTail('b');
        queue.appendTail('c');
        queue.deleteHead();
        queue.deleteHead();
    }
}
