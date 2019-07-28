package jp.sitogi.pocket.conditions;

public class Search implements Condition {

    private final String searchStr;

    public Search(String searchStr) {
        this.searchStr = searchStr;
    }

    public static Search contains(String searchStr) {
        return new Search(searchStr);
    }

    @Override
    public String toQueryStr() {
        return "search=" + searchStr;
    }

}
