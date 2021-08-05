package consts.values;

public enum LinksTitlesValues {
    VALUE00 ("News"),
    VALUE01 ("FAKE Stories"),
    VALUE02 ("Real Stories"),
    VALUE03 ("Materials"),
    VALUE04 ("Hard Skills"),
    VALUE05 ("Soft Skills"),
    VALUE06 ("Events");

    private final String linkTitle;

    LinksTitlesValues(String linkTitle) {
        this.linkTitle = linkTitle;
    }

    public String getLinkTitle() {
        return linkTitle;
    }
}
