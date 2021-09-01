package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGameManager {
    private final List<LadderGame> ladderGames;

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
            for (int j = 0; j < ladderGames.size(); j++) {
                int position = ladderGames.get(j).getPosition();
                String name = ladderGames.get(j).getName();
                if (position == 0) {
                    if (ladder.getLines().get(i).getPoints().get(0)) {
                        ladderGames.set(j, new LadderGame(1, ladderGames.get(j).getName()));
                        continue;
                    }
                    ladderGames.set(j, new LadderGame(0, ladderGames.get(j).getName()));
                    continue;
                } else if (position == ladderGames.size() - 1) {
                    if (ladder.getLines().get(i).getPoints().get(position - 1)) {
                        ladderGames.set(j, new LadderGame(position - 1, ladderGames.get(j).getName()));
                        continue;
                    }
                    ladderGames.set(j, new LadderGame(position, ladderGames.get(j).getName()));
                    continue;
                }
                if (ladder.getLines().get(i).getPoints().get(position - 1)) {
                    ladderGames.set(j, new LadderGame(position - 1, ladderGames.get(j).getName()));
                    continue;
                }
                if (ladder.getLines().get(i).getPoints().get(position)) {
                    ladderGames.set(j, new LadderGame(position + 1, ladderGames.get(j).getName()));
                    continue;
                }
                ladderGames.set(j, new LadderGame(position, ladderGames.get(j).getName()));
                continue;
            }
        }


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
