import java.io.Serializable;
import java.math.BigDecimal;

public class Pi implements Serializable {
    private static final long serialVersionUID = 227L;
    private static final BigDecimal FOUR = BigDecimal.valueOf(4);
    private static final int roundingMode = BigDecimal.ROUND_HALF_EVEN;
    public static void main(String[] args) {
        BigDecimal result = computePi(Integer.parseInt(args[0]));
        System.out.println("result = " + result);
    }

    public static BigDecimal computePi(int digits) {
        int scale = digits + 5;
        BigDecimal arctan1_5 = arctan(5, scale);
        BigDecimal arctan1_239 = arctan(239, scale);
        BigDecimal pi = arctan1_5.multiply(FOUR).subtract(arctan1_239).multiply(FOUR);
        return pi.setScale(digits, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal arctan(int inverseX, int scale) {
        BigDecimal result, number, term;
        BigDecimal invX = BigDecimal.valueOf(inverseX);
        BigDecimal invX2 = BigDecimal.valueOf(inverseX * inverseX);
        number = BigDecimal.ONE.divide(invX, scale, roundingMode);
        result = number;
        int i = 1;
        do {
            number = number.divide(invX, scale, roundingMode);
            int denom = 2 * i + 1;
            term = number.divide(BigDecimal.valueOf(denom), scale, roundingMode);
            if ((i % 2) != 0) {
                result = result.subtract(term);
            } else {
                result = result.add(term);
            }
            i++;
        } while (term.compareTo(BigDecimal.ZERO) != 0);
        return result;
    }
}
