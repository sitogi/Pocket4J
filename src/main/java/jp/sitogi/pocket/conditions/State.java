package jp.sitogi.pocket.conditions;

public enum State {

    UNREAD("unread"),
    ARCHIVE("archive"),
    ALL("all"),
    ;

    private final String value;

    State(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
       return value;
    }

}
