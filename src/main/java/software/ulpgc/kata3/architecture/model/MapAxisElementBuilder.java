package software.ulpgc.kata3.architecture.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapAxisElementBuilder <K> implements AxisElementBuilder {
    private final Map<K, Integer> data;

    public MapAxisElementBuilder(Map<K, Integer> data) {
        this.data = data;
    }

    @Override
    public List<AxisElement> build() {
        List<AxisElement> elements = new ArrayList<>();
        for (K key : data.keySet()) {
            elements.add(new AxisElement(String.valueOf(key), data.get(key)));
        }
        return elements;
    }
}
