package jp.sitogi.pocket.conditions;

public enum Sort implements Condition {

    NEWEST("newest"),
    OLDEST("oldest"),
    TITLE("title"),
    SITE("site"),
    ;

    private final String value;

    Sort(String value) {
        this.value = value;
    }

    @Override
    public String toQueryStr() {
        return "sort=" + value;
    }

}
