package step4.exceptions;

public class NonExistBeforeException extends IllegalArgumentException {

    private static final String NON_EXIST_BEFORE = "next 메서드는 before direction이 존재할 경우에만 사용할 수 있습니디.";

    public NonExistBeforeException() {
        super(NON_EXIST_BEFORE);
    }
}
