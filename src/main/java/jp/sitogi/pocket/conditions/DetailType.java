package jp.sitogi.pocket.conditions;

public enum DetailType {

    SIMPLE("simple"),
    COMPLETE("complete"),
    ;

    private final String value;

    DetailType(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
