package com.chmnu_ki_123.k3;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.JFrame;
import java.awt.*;
import java.util.function.Function;

public class ChartComparison extends JFrame {

    private final double a = 0.1;
    private final double b = 3.0;
    private final double c = -2.25;

    private final JFreeChart chart1;
    private final ChartPanel chartPanel1;
    private final XYSeries xySeries1 = new XYSeries("f1");
    private final XYSeriesCollection xySeriesCollection1 = new XYSeriesCollection(xySeries1);

    public ChartComparison(String title) throws HeadlessException {
        setTitle(title);

        chart1 = ChartFactory.createXYLineChart("y=f(x)", "x", "y", xySeriesCollection1);

        fillSeriesCollection(xySeries1, 3.0, 10.0, 0.1, this::f);

        chartPanel1 = new ChartPanel(chart1);
        chartPanel1.setPreferredSize(new Dimension(600, 400));

        add(chartPanel1);

        pack();
        setVisible(true);
    }

    double f(double x) {
        return (a * Math.cos(b / (x * x - 1))) / (Math.exp(-b * x) + c);
    }

    void fillSeriesCollection(XYSeries series, double a, double b, double h, Function<Double, Double> mapper) {
        for (double x = a; x <= b; x += h) {
            double y = mapper.apply(x);
            series.add(x, y);
        }
    }
}
