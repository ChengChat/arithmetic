package offer.quality.question21;

/**
 * 能被3整除放前，不能放后
 */
public class DivisibleThreeStrategy  implements Strategy {
    @Override
    public boolean putInFront(int num) {
        return num % 3 == 0;
    }

    @Override
    public boolean putBehind(int num) {
        return num % 3 != 0;
    }
}
