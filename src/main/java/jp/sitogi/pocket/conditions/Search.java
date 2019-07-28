package jp.sitogi.pocket.conditions;

import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;

public class Search implements Condition {

    private final String searchStr;

    public Search(String searchStr) {
        this.searchStr = searchStr;
    }

    public static Search contains(String searchStr) {
        return new Search(searchStr);
    }

    @Override
    public void appendJsonBody(final JsonGenerator generator) throws IOException {
        generator.writeStringField("search", searchStr);
    }

}
