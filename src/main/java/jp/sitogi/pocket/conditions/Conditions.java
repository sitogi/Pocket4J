package jp.sitogi.pocket.conditions;

import java.util.ArrayList;
import java.util.List;

public class Conditions {

    private List<Condition> conditionList;

    private Conditions() {
        conditionList = new ArrayList<>();
    }

    public static Conditions newConditions() {
        return new Conditions();
    }

    public static Conditions defaultConditions() {
        final Conditions defaultCond = newConditions();
        defaultCond.state(State.UNREAD);
        return defaultCond;
    }

    public String toQueryStr() {
        final StringBuilder bf = new StringBuilder();

        // consumer_key と access_token は必須で付加済みなので ? の考慮は不要
        conditionList.forEach(c -> bf.append("&").append(c.toQueryStr()));

        return bf.toString();
    }

    public Conditions state(final State state) {
        conditionList.add(state);
        return this;
    }

    public Conditions favorite(final Favorite favorite) {
        conditionList.add(favorite);
        return this;
    }

    public Conditions tag(final Tag tag) {
        conditionList.add(tag);
        return this;
    }

    public Conditions contentType(final ContentType contentType) {
        conditionList.add(contentType);
        return this;
    }

    public Conditions sort(final Sort sort) {
        conditionList.add(sort);
        return this;
    }

    public Conditions detailType(final DetailType detailType) {
        conditionList.add(detailType);
        return this;
    }

    public Conditions search(final Search search) {
        conditionList.add(search);
        return this;
    }

    public Conditions domain(final Domain domain) {
        conditionList.add(domain);
        return this;
    }

    public Conditions since(final Since since) {
        conditionList.add(since);
        return this;
    }

    public Conditions count(final Count count) {
        conditionList.add(count);
        return this;
    }

    public Conditions offset(final Offset offset) {
        conditionList.add(offset);
        return this;
    }

    @Override
    public String toString() {
        return "";
    }

}
