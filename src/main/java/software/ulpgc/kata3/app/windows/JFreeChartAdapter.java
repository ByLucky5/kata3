package software.ulpgc.kata3.app.windows;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import software.ulpgc.kata3.architecture.model.AxisElement;
import software.ulpgc.kata3.architecture.model.Barchart;

public class JFreeChartAdapter {
    public static JFreeChart adapt(Barchart barchart) {
        JFreeChart chart = ChartFactory.createBarChart(barchart.getTitle(), barchart.getxAxis(), barchart.getyAxis(), dataOf(barchart));
        setUpChart(chart);
        return chart;
    }

    private static CategoryDataset dataOf(Barchart barchart) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (AxisElement axisElement : barchart) {
            dataset.addValue(axisElement.getValue(), "", axisElement.getField());
        }
        return dataset;
    }

    private static void setUpChart(JFreeChart chart) {
        chart.getCategoryPlot().getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.UP_90);
    }
}
