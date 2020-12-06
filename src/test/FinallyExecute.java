package test;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

public class FinallyExecute {
    public static void main(String[] args) {
        int i = finallyExecute();
        System.out.println(i);
    }

    private static int finallyExecute() {
        int i = 0;
        try {
            i++;
            i = i/0;
            return i;
        }catch (Exception e){
            i++;
//            i = i/0;
        }finally{
            i++;
            System.out.println("我一直在执行，只是return之后执行，对结果 i 没影响？？？！！！");
        }
        return i;
    }
}
