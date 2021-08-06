package consts.values;

public enum LinksTitlesValues {
    VALID (new String[]{
            "News",
            "FAKE Stories",
            "Real Stories",
            "Materials",
            "Hard Skills",
            "Soft Skills",
            "Events"
    });

    private final String[] linksTitles;

    LinksTitlesValues(String[] linksTitles) {
        this.linksTitles = linksTitles;
    }

    public String[] getLinksTitles() {
        return linksTitles;
    }
}
