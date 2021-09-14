package step4.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.column.LadderColumn;

class LadderStartColumnTest {

    @DisplayName("사다리 타기 게임 칼럼 이름과 인덱스의 정보가 정확히 매칭되는지 확인.")
    @Test
    void columnName() {
        String names = "A,B,C";
        LadderColumn ladderStartColumn = new LadderColumn(names);
        Assertions.assertThat(ladderStartColumn.name(0)).isEqualTo("A");
    }
}