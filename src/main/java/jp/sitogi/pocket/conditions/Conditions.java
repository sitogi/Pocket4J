package jp.sitogi.pocket.conditions;

import java.util.Date;

public class Conditions {

    private State state;
    private boolean favorite;
    private String tag;
    private ContentType contentType;
    private Sort sort;
    private DetailType detailType;
    private String search;
    private String domain;
    private Date since;
    private int count;
    private int offset;

    private Conditions(){

    }

    public static Conditions newConditions(){
        return new Conditions();
    }

    public Conditions state(final State state) {
        this.state = state;
        return this;
    }

    public Conditions favorite(final boolean favorite) {
        this.favorite = favorite;
        return this;
    }

    public Conditions tag(final String tag) {
        this.tag = tag;
        return this;
    }

    public Conditions contentType(final ContentType contentType) {
        this.contentType = contentType;
        return this;
    }

    public Conditions sort(final Sort sort) {
        this.sort = sort;
        return this;
    }

    public Conditions detailType(final DetailType detailType) {
        this.detailType = detailType;
        return this;
    }

    public Conditions search(final String search) {
        this.search = search;
        return this;
    }

    public Conditions domain(final String domain) {
        this.domain = domain;
        return this;
    }

    public Conditions since(final Date since) {
        this.since = since;
        return this;
    }

    public Conditions count(final int count) {
        this.count = count;
        return this;
    }

    public Conditions offset(final int offset) {
        this.offset = offset;
        return this;
    }

    public String build() {
        final StringBuilder bf = new StringBuilder();

        if (state == null) {

        }



        return bf.toString();
    }

    @Override
    public String toString() {
        return "";
    }

}
