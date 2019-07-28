package jp.sitogi.pocket.conditions;

import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;
import java.util.Date;

public class Since implements Condition {

    private final Date date;

    public Since(Date date) {
        this.date = date;
    }

    @Override
    public void appendJsonBody(final JsonGenerator generator) throws IOException {
        generator.writeStringField("since", String.valueOf(date.getTime()));
    }

}
