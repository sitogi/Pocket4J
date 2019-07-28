package jp.sitogi.pocket.conditions;

import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;

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
    public void appendJsonBody(final JsonGenerator generator) throws IOException {
        generator.writeStringField("state", value);

    }

}
