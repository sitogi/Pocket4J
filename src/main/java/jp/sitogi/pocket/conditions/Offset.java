package jp.sitogi.pocket.conditions;

import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;

public class Offset implements Condition {

    private final int offset;

    public Offset(int offset) {
        this.offset = offset;
    }

    @Override
    public void appendJsonBody(final JsonGenerator generator) throws IOException {
        generator.writeNumberField("offset", offset);
    }

}
