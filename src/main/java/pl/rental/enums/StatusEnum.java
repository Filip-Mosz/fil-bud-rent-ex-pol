package pl.rental.enums;

public enum StatusEnum {
    AVAILABLE("dostępny"),
    UNAVAILABLE("niedostępny"),
    BORROWED("niedostępny");

    private final String displayState;

    StatusEnum(String displayState) {
        this.displayState = displayState;
    }

    public String getDisplayState() {
        return displayState;
    }
}
