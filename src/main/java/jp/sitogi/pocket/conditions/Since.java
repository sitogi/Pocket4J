package jp.sitogi.pocket.conditions;

import java.util.Date;

public class Since implements Condition {

    private final Date date;

    public Since(Date date) {
        this.date = date;
    }

    @Override
    public String toQueryStr() {
        // API には UNIX 時間で渡す
        return "timestamp=" + date.getTime();
    }

}
