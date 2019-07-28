package jp.sitogi.pocket.conditions;

public class Favorite implements Condition {

    private final boolean favorite;

    public Favorite(boolean favorite) {
        this.favorite = favorite;
    }

    @Override
    public String toQueryStr() {
        // API には 0 か 1 で渡す
        return "favorite=" + (favorite ? 1 : 0);
    }

}
