package jp.sitogi.pocket.conditions;

public class Count implements Condition {

    private final int count;

    public Count(int count) {
        this.count = count;
    }

    public static Count to(int count) {
        return new Count(count);
    }

    @Override
    public String toQueryStr() {
        return "count=" + count;
    }

}
