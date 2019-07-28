package jp.sitogi.pocket.conditions;

import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;

public class Count implements Condition {

    private final int count;

    public Count(int count) {
        this.count = count;
    }

    public static Count to(int count) {
        return new Count(count);
    }

    @Override
    public void appendJsonBody(final JsonGenerator generator) throws IOException {
        generator.writeStringField("count", String.valueOf(count));
    }

}
