package org.javatribe.score.po;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Score extends ScoreKey {
    @Max(value = 10,message = "评分范围0-10")
    @Min(value = 0,message = "评分范围0-10")
    private Double scoreNum;

    public Double getScoreNum() {
        return scoreNum;
    }

    public void setScoreNum(Double scoreNum) {
        this.scoreNum = scoreNum;
    }
}