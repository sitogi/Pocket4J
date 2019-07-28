package jp.sitogi.pocket.conditions;

public enum State implements Condition {

    UNREAD("unread"),
    ARCHIVE("archive"),
    ALL("all"),
    ;

    private final String value;

    State(final String value) {
        this.value = value;
    }

    @Override
    public String toQueryStr() {
        return "state=" + value;
    }

}
