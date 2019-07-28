package jp.sitogi.pocket.conditions;

import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;

public enum DetailType implements Condition {

    SIMPLE("simple"),
    COMPLETE("complete"),
    ;

    private final String detailType;

    DetailType(final String detailType) {
        this.detailType = detailType;
    }

    @Override
    public void appendJsonBody(final JsonGenerator generator) throws IOException {
        generator.writeStringField("detailType", detailType);

    }

}
