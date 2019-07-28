package jp.sitogi.pocket.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("unused")
public class RetrievedItem {

    // TODO 他のフィールドの実装

    @JsonProperty("item_id")
    private String itemId;

    @JsonProperty("given_url")
    private String url;

    @JsonProperty("given_title")
    private String title;

    @JsonProperty("time_added")
    private String addedTime;

    public String getItemId() {
        return itemId;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getAddedTime() {
        return addedTime;
    }

    public LocalDateTime getAddedDate() {
        return LocalDateTime.ofEpochSecond(Long.parseLong(addedTime), 0,
                ZoneId.systemDefault().getRules().getOffset(Instant.now()));
    }

}
