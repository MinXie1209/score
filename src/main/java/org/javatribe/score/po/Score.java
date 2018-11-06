package org.javatribe.score.po;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class Score extends ScoreKey implements Serializable {
    @Max(value = 100,message = "评分范围0-100")
    @Min(value = 0,message = "评分范围0-100")
    private Double scoreNum;

    public Double getScoreNum() {
        return scoreNum;
    }

    public void setScoreNum(Double scoreNum) {
        this.scoreNum = scoreNum;
    }
}