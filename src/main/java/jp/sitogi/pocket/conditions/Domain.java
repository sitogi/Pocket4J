package jp.sitogi.pocket.conditions;

public class Domain implements Condition {

    private final String domain;

    public Domain(String domain) {
        this.domain = domain;
    }

    public static Domain of(String domain) {
        return new Domain(domain);
    }

    @Override
    public String toQueryStr() {
        return "domain=" + domain;
    }

}
