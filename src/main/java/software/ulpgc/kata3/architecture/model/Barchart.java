package software.ulpgc.kata3.architecture.model;

import java.util.Iterator;
import java.util.List;

public class Barchart implements Iterable<AxisElement> {
    private final String title;
    private final String xAxis;
    private final String yAxis;
    private final List<AxisElement> elements;

    public Barchart(String title, String xAxis, String yAxis, List<AxisElement> elements) {
        this.title = title;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.elements = elements;
    }

    public Iterator<AxisElement> iterator() {
        return elements.iterator();
    }

    public String getTitle() {
        return title;
    }

    public String getxAxis() {
        return xAxis;
    }

    public String getyAxis() {
        return yAxis;
    }

    public List<AxisElement> getElements() {
        return elements;
    }
}
