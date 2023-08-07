package example0807.lotto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Player {
    private final Set<Integer> userNumber;

    public Player(Set<Integer> userNumber) {
        this.userNumber = userNumber;
    }

    public Set<Integer> getUserNumber() {
        return userNumber;
    }
}
