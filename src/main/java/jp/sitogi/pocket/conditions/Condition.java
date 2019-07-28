package jp.sitogi.pocket.conditions;

import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;

public interface Condition {

    void appendJsonBody(JsonGenerator generator) throws IOException;

}
