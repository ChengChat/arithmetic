package test;

import java.util.TreeSet;

public class Dfg {
    public static void main(String[] args) {
        /*int i = 5/2;
        System.out.println(i);*/
        TreeSet<Integer> set = new TreeSet<>();
        set.add(2);
        set.add(3);
        set.add(4);
        set.remove(set.first());
        System.out.println(set.last());
    }
}
