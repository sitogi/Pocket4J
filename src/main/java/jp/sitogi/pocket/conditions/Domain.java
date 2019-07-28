package jp.sitogi.pocket.conditions;

import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;

public class Domain implements Condition {

    private final String domain;

    public Domain(String domain) {
        this.domain = domain;
    }

    public static Domain of(String domain) {
        return new Domain(domain);
    }

    @Override
    public void appendJsonBody(final JsonGenerator generator) throws IOException {
        generator.writeStringField("domain", domain);
    }

}
