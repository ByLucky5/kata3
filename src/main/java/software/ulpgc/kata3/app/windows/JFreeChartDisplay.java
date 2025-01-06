package software.ulpgc.kata3.app.windows;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import software.ulpgc.kata3.architecture.model.Barchart;
import software.ulpgc.kata3.architecture.view.BarchartDisplay;

import javax.swing.*;
import java.awt.*;

public class JFreeChartDisplay extends JPanel implements BarchartDisplay {
    public JFreeChartDisplay() {
        setLayout(new BorderLayout());
    }

    @Override
    public void show(Barchart barchart) {
        removeAll();
        this.add(new ChartPanel(adapt(barchart)));
        revalidate();
    }

    private JFreeChart adapt(Barchart barchart) {
        return JFreeChartAdapter.adapt(barchart);
    }
}
