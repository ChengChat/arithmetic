package test;

import sort.SortUtlis;

import javax.sound.midi.Soundbank;

public class B implements A {
    @Override
    public void aa() {
        System.out.println(bb);
        System.out.println(cc);
    }

    public static void main(String[] args) {
        System.out.println(cc);
        System.out.println(bb);
        int i = 3, b = 5;
        // 加法比位运算的优先级高
        int j = i + (b >> 1);
        System.out.println(j);

        String s2 = "dew.qefdewrfr.fre qg.gtrh.yt.hy";
        String[] words2 = s2.split( "\\.");
        System.out.println(words2[0]);
    }
}
