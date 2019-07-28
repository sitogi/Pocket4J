package jp.sitogi.pocket.conditions;

import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;

public class Favorite implements Condition {

    private final boolean favorite;

    public Favorite(boolean favorite) {
        this.favorite = favorite;
    }

    @Override
    public void appendJsonBody(final JsonGenerator generator) throws IOException {
        generator.writeStringField("favorite", String.valueOf((favorite ? 1 : 0)));
    }

}
