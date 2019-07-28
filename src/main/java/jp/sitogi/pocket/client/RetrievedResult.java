package jp.sitogi.pocket.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("unused")
public class RetrievedResult {

    // TODO 他のフィールドの実装

    private String status;
    private String complete;
    private String error;
    @JsonProperty("list") // キー名そのままだと直感的ではないためフィールド名は別にしておく
    private RetrievedItems items;

    public String getStatus() {
        return status;
    }

    public String getComplete() {
        return complete;
    }

    public String getError() {
        return error;
    }

    public RetrievedItems getItems() {
        return items;
    }

}
