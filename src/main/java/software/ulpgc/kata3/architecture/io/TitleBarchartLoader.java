package software.ulpgc.kata3.architecture.io;

import software.ulpgc.kata3.architecture.model.AxisElement;
import software.ulpgc.kata3.architecture.model.Barchart;

import java.util.List;

public class TitleBarchartLoader implements BarchartLoader {
    private final List<AxisElement> titlesPerYear;
    private final List<AxisElement> titlesTypeCount;

    public TitleBarchartLoader(List<AxisElement> titlesPerYear, List<AxisElement> titlesTypeCount) {
        this.titlesPerYear = titlesPerYear;
        this.titlesTypeCount = titlesTypeCount;
    }

    @Override
    public Barchart load(int id) {
        return switch (id) {
            case 0 -> loadBarchart("Titles per year", "Year", "Nº of titles", titlesPerYear);
            case 1 -> loadBarchart("Titles type count", "Title type", "Nº of titles", titlesTypeCount);
            default -> null;
        };
    }

    private Barchart loadBarchart(String titles, String xAxis, String yAxis, List<AxisElement> barchartElements) {
        return new Barchart(titles, xAxis, yAxis, barchartElements);
    }
}
