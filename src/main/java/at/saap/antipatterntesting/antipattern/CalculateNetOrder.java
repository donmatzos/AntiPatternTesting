package at.saap.antipatterntesting.antipattern;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

public class CalculateNetOrder
{
    public static void calculate(SuperOrder order)
    {
        final BigDecimal vatRate = order.items.get(0).vatRate;
        order.vatRate = vatRate;
        order.netAmount = BigDecimal.ZERO;
        order.vatAmount = BigDecimal.ZERO;
        order.grossAmount = BigDecimal.ZERO;
        for (SuperItem item : order.items)
        {
            item.vatAmount = item.netAmount.multiply(vatRate);
            item.grossAmount = item.netAmount.add(item.vatAmount);
            order.netAmount = order.netAmount.add(item.netAmount);
            order.vatAmount = order.vatAmount.add(item.vatAmount);
            order.grossAmount = order.grossAmount.add(item.grossAmount);
            order.currency = item.currency;
        }
        order.calculationDate = Date.from(Instant.now());
    }
}
