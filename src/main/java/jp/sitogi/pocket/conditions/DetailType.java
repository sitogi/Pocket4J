package jp.sitogi.pocket.conditions;

public enum DetailType implements Condition {

    SIMPLE("simple"),
    COMPLETE("complete"),
    ;

    private final String detailType;

    DetailType(final String detailType) {
        this.detailType = detailType;
    }

    @Override
    public String toQueryStr() {
        return "detailType=" + detailType;
    }

}
