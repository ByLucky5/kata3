package software.ulpgc.kata3.architecture.model;

public class Title {
    private final String title;
    private final int year;
    private final int duration;
    private final TitleType type;

    public Title(String title, int year, int duration, TitleType type) {
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.type = type;
    }

    public TitleType getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Title{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", duration=" + duration +
                '}';
    }
    public enum TitleType {
        VIDEOGAME,
        TVPILOT,
        MOVIE,
        TVSERIES,
        TVMINISERIES,
        SHORT,
        TVSPECIAL,
        TVSHORT,
        VIDEO,
        TVMOVIE,
        TVEPISODE,
    }
}
