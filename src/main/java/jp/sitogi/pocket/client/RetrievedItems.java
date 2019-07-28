package jp.sitogi.pocket.client;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("unused")
public class RetrievedItems {

//    private RetrieveItem item;
//
//    public RetrieveItem getItem() {
//        return item;
//    }


    private Map<String, RetrievedItem> map = new HashMap<>();

    @JsonAnySetter
    void setDetails(String key, RetrievedItem item) {
        map.put(key, item);
    }

    public Map<String, RetrievedItem> getItemMap() {
        return map;
    }

    public List<RetrievedItem> getItemList() {
        return new ArrayList<>(map.values());
    }

}
