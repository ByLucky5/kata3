package software.ulpgc.kata3.app.windows;

import software.ulpgc.kata3.architecture.control.ToggleBarchartCommand;
import software.ulpgc.kata3.architecture.io.FileTitleLoader;
import software.ulpgc.kata3.architecture.io.TitleBarchartLoader;
import software.ulpgc.kata3.architecture.model.MapAxisElementBuilder;
import software.ulpgc.kata3.architecture.model.Title;
import software.ulpgc.kata3.architecture.model.TsvTitleDeserializer;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\lucia\\Downloads\\title.basics.tsv");
        List<Title> titles = new FileTitleLoader(file, new TsvTitleDeserializer()).load();
        Map<Integer, Integer> titlesPerYear = new TreeMap<>();
        Map<Title.TitleType, Integer> titlesTypeCount = new HashMap<>();
        for (Title title : titles) {
            titlesPerYear.put(getTensOf(title.getYear()), titlesPerYear.getOrDefault(getTensOf(title.getYear()), 0) + 1);
            titlesTypeCount.put(title.getType(), titlesTypeCount.getOrDefault(title.getType(), 0) + 1);
        }
        MainFrame mainFrame = new MainFrame();
        TitleBarchartLoader loader = new TitleBarchartLoader(new MapAxisElementBuilder<>(titlesPerYear).build(), new MapAxisElementBuilder<>(titlesTypeCount).build());
        mainFrame.put("toggle", new ToggleBarchartCommand(loader, mainFrame.getDisplay()));
        mainFrame.getDisplay().show(loader.load(0));
        mainFrame.setVisible(true);
    }

    private static int getTensOf(int value) {
        return value / 10 * 10;
    }
}
