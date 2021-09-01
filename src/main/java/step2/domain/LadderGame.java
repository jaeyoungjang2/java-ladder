package step2.domain;

public class LadderGame {
    private final int position;
    private final String name;
    private String result;

    public LadderGame(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public LadderGame(int position, String name, String result) {
        this.position = position;
        this.name = name;
        this.result = result;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String getResult() {
        return result;
    }
}
