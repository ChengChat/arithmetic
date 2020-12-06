package offer.quality.question21;

/**
 * 单数放前，复数放后
 */
public class SingularAndPluralStrategy implements Strategy {
    @Override
    public boolean putInFront(int num) {
        return (num & 1) == 1;
    }

    @Override
    public boolean putBehind(int num) {
        return (num & 1) ==0;
    }
}
