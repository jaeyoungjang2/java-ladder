package step2.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class LadderGameManagerTest {
    @Test
    void test() {
        List<Boolean> list1 = new ArrayList<>();
        List<Boolean> list2 = new ArrayList<>();
        list1.add(Boolean.FALSE);
        list1.add(Boolean.TRUE);
        list1.add(Boolean.FALSE);

        list2.add(Boolean.TRUE);
        list2.add(Boolean.FALSE);
        list2.add(Boolean.FALSE);

        Line line1 = new Line(list1);
        Line line2 = new Line(list2);
        Ladder ladder = new Ladder();
        ladder.getLines().add(line1);
        ladder.getLines().add(line2);

        Name names = new Name("a,b,c,d");
        LadderGameManager ladderGameManager = new LadderGameManager(names);
        ladderGameManager.runGame(2, ladder);
        System.out.println(ladderGameManager.getLadderGames().get(0).getName());
        System.out.println(ladderGameManager.getLadderGames().get(0).getPosition());
        System.out.println(ladderGameManager.getLadderGames().get(1).getName());
        System.out.println(ladderGameManager.getLadderGames().get(1).getPosition());
        System.out.println(ladderGameManager.getLadderGames().get(2).getName());
        System.out.println(ladderGameManager.getLadderGames().get(2).getPosition());
        System.out.println(ladderGameManager.getLadderGames().get(3).getName());
        System.out.println(ladderGameManager.getLadderGames().get(3).getPosition());
    }
}