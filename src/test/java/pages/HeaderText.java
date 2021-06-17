package pages;

public enum HeaderText {
    FIRST_HEADER("The Free Encyclopedia …in over 300 languages"),
    SECOND_HEADER("New ways to explore"),
    THIRD_HEADER("Reading lists with sync"),
    FOURTH_HEADER("Send anonymous data");

    private String headerText;

    HeaderText(String headerText) {
        this.headerText = headerText;
    }

    public final String getHeaderText() {
        return headerText;
    }
}
