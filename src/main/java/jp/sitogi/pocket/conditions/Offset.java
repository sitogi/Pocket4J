package jp.sitogi.pocket.conditions;

public class Offset implements Condition {

    private final int offset;

    public Offset(int offset) {
        this.offset = offset;
    }

    @Override
    public String toQueryStr() {
        return "offset=" + offset;
    }

}
