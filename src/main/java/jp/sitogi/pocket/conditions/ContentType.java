package jp.sitogi.pocket.conditions;

import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;

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
    public void appendJsonBody(final JsonGenerator generator) throws IOException {
        generator.writeStringField("contentType", contentType);
    }

}
