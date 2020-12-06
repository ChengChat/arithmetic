package offer.quality.question16;

public class Test {
    public static void main(String[] args){
        isEqualOfFloat(10.222222225f, 10.222222229f);
    }

    public static void isEqualOfFloat(float a, float b) {
        System.out.println("-------使用==符号比较是否相等：" + (a == b));
        System.out.println("-------使用Math.abs()方法比较是否相等：" + (Math.abs(a - b) <= 0));
        System.out.println("-------使用Math.abs()方法比较是否相等(比较宽容的限制)：" + (Math.abs(a - b) < 0.00000001));
        System.out.println("-------比较大小<：" + (a < b));
        System.out.println("-------比较大小>：" + (a > b));
    }
}
