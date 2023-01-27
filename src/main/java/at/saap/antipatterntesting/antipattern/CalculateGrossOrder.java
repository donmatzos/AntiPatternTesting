package at.saap.antipatterntesting.antipattern;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.Date;

public class CalculateGrossOrder
{
    public static void calculate(SuperOrder order)
    {
        final BigDecimal vatRate = order.items.get(0).vatRate;
        order.vatRate = vatRate;
        final BigDecimal calculationRate = vatRate.add(BigDecimal.ONE);
        order.netAmount = BigDecimal.ZERO;
        order.vatAmount = BigDecimal.ZERO;
        order.grossAmount = BigDecimal.ZERO;
        for (SuperItem item : order.items)
        {
            item.netAmount = item.grossAmount.divide(calculationRate, RoundingMode.HALF_UP);
            item.vatAmount = item.grossAmount.subtract(item.netAmount);
            order.netAmount = order.netAmount.add(item.netAmount);
            order.vatAmount = order.vatAmount.add(item.vatAmount);
            order.currency = item.currency;
        }
        order.calculationDate = Date.from(Instant.now());
    }
}
