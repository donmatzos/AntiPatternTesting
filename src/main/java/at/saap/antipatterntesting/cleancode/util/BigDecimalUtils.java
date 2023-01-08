package at.saap.antipatterntesting.cleancode.util;

import java.math.BigDecimal;

public final class BigDecimalUtils
{
    private BigDecimalUtils() {}

    public static BigDecimal nullSafeAdd(final BigDecimal sum, final BigDecimal augend)
    {
        final BigDecimal aug = (augend != null ? augend : BigDecimal.ZERO);
        return (sum != null ? sum.add(aug) : aug);
    }
}
