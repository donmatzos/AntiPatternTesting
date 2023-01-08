package at.saap.antipatterntesting.cleancode.util;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

@Test
public class BigDecimalUtilsTest
{
    //this -> UNIT
    @Test
    public void testNullSafeAddAllNull()
    {
        final BigDecimal result = BigDecimalUtils.nullSafeAdd(null, null);
        Assert.assertEquals(result.doubleValue(), 0.);
    }

    @Test
    public void testNullSafeAddSumNull()
    {
        final BigDecimal result = BigDecimalUtils.nullSafeAdd(null, BigDecimal.valueOf(1000.));
        Assert.assertEquals(result.doubleValue(), 1000.);
    }

    @Test
    public void testNullSafeAddAugendNull()
    {
        final BigDecimal result = BigDecimalUtils.nullSafeAdd(BigDecimal.valueOf(1000.), null);
        Assert.assertEquals(result.doubleValue(), 1000.);
    }
}
