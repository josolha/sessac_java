package example0807.lotto;

public enum Rank {

    FIRST ("1등!"),
    SECOND ("2등!"),
    THIRD("3등!"),
    FOURTH("4등!"),
    NONE("꽝!");

    private final String rankString;

    Rank(String rankString) {
        this.rankString = rankString;
    }

    public static Rank getRankByCount(int count) {
        switch (count) {
            case 6:
                return FIRST;
            case 5:
                return SECOND;
            case 4:
                return THIRD;
            case 3:
                return FOURTH;
            default:
                return NONE;
        }
    }

    public String getRankString() {
        return rankString;
    }
}
