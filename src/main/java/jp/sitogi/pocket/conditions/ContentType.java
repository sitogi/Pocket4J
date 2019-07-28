package jp.sitogi.pocket.conditions;

public enum ContentType implements Condition {

    ARTICLE("article"),
    VIDEO("video"),
    IMAGE("image"),
    ;

    private final String contentType;

    ContentType(final String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String toQueryStr() {
        return "contentType=" + contentType;
    }

}
