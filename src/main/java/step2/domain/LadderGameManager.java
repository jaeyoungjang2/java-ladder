package step2.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameManager {
    private List<LadderGame> ladderGames;

    public LadderGameManager(Name name) {
        ladderGames = name.getParticipantNames()
                .stream()
                .map(s -> new LadderGame(name.getParticipantNames().indexOf(s), s))
                .collect(Collectors.toList());
    }

    public List<LadderGame> getLadderGames() {
        return ladderGames;
    }

    public void runGame(int value, Ladder ladder) {
        for (int i = 0; i < value; i++) {
            Line line = ladder.getLines().get(i);
            List<LadderGame> collect = ladderGames.stream()
                    .map(ladderGame -> gameByHeight(line, ladderGame))
                    .collect(Collectors.toList());
            ladderGames = collect;
        }
    }

    private LadderGame moveStrategy(int testIndex, Line line, LadderGame ladderGame) {
        if (testIndex - 1 >= 0 && testIndex - 1 < ladderGames.size() - 1 && line.getPoints().get(testIndex - 1)) {
            return new LadderGame(testIndex - 1, ladderGame.getName());
        }
        if (testIndex >= 0 && testIndex < ladderGames.size() - 1 && line.getPoints().get(testIndex)) {
            return new LadderGame(testIndex + 1, ladderGame.getName());
        }
        return new LadderGame(testIndex, ladderGame.getName());
    }

    private LadderGame gameByHeight(Line line, LadderGame ladderGame) {
        return moveStrategy(ladderGame.getPosition(), line, ladderGame);
    }

    public void calResult(Result results) {
        for (int i = 0; i < ladderGames.size(); i++) {
            int position = ladderGames.get(i).getPosition();
            String name = ladderGames.get(i).getName();
            String result = results.getStrings().get(ladderGames.get(i).getPosition());
            ladderGames.set(i, new LadderGame(position, name, result));
        }
    }
}
