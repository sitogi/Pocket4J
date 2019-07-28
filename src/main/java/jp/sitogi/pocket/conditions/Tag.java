package jp.sitogi.pocket.conditions;

import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;

public class Tag implements Condition {

    private final String value;

    private Tag(String value) {
        this.value = value;
    }

    public static Tag of(String value) {
        return new Tag(value);
    }

    public static Tag none() {
        return new Tag("_untagged_");
    }

    @Override
    public void appendJsonBody(final JsonGenerator generator) throws IOException {
        generator.writeStringField("tag", value);
    }
}
