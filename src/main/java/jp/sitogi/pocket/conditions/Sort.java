package jp.sitogi.pocket.conditions;

import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;

public enum Sort implements Condition {

    NEWEST("newest"),
    OLDEST("oldest"),
    TITLE("title"),
    SITE("site"),
    ;

    private final String value;

    Sort(String value) {
        this.value = value;
    }

    @Override
    public void appendJsonBody(final JsonGenerator generator) throws IOException {
        generator.writeStringField("sort", value);
    }

}
