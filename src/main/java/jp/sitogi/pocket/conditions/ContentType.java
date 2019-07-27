package jp.sitogi.pocket.conditions;

public enum ContentType {

    ARTICLE("article"),
    VIDEO("video"),
    IMAGE("image"),
    ;

    private final String value;

    ContentType(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
