package javaConcurrencePractice.ch3;

import javaConcurrencePractice.util.IntUtil;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 使用指向不可变容器对象的volatile类型引用以缓存最新结果
 */
public class VolatileCacheFactorizer {
    private volatile OneValueCache cache = new OneValueCache(null, null);

    public void service(BigInteger i) {
        BigInteger[] factors = cache.getFactors(i);
        if (factors == null) {
            factors = IntUtil.factor(i);
            cache = new OneValueCache(i, factors);
        }
        System.out.println(Arrays.toString(factors));
    }

    public static void main(String[] args) {
        VolatileCacheFactorizer vcf = new VolatileCacheFactorizer();
        vcf.service(BigInteger.valueOf(2131412));
    }

}
