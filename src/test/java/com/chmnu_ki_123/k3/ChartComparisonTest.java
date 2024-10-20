package com.chmnu_ki_123.k3;

import org.junit.Before;
import org.junit.Test;
import org.jfree.data.xy.XYSeries;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ChartComparisonTest {

    private ChartComparison chartComparison;

    @Before
    public void setUp() {
        chartComparison = new ChartComparison("Test Chart");
    }

    @Test
    public void testFunctionF() {
        double result = chartComparison.f(3.0);
        System.out.println("Result for x=3.0: " + result);
        assertEquals(-0.041358162752886285, result, 0.000001);
    }

    @Test
    public void testFillSeriesCollection() {
        XYSeries series = new XYSeries("test");
        chartComparison.fillSeriesCollection(series, 3.0, 4.0, 0.5, chartComparison::f);
        assertEquals(3, series.getItemCount());
        assertTrue(series.getY(0).doubleValue() < 0);
    }
}
