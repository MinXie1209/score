package org.javatribe.score.po;

import java.io.Serializable;

/**
 * @ClassName ScorePro
 * @Description 评委已打分的队伍（编号，队名，作品名,打分）
 * @Author 江南小俊
 * @Date 2018/10/21 15:44
 * @Version 1.0.0
 **/
public class ScorePro extends Team implements Serializable {

    private Double scoreNum;

    public Double getScoreNum() {
        return scoreNum;
    }

    public void setScoreNum(Double scoreNum) {
        this.scoreNum = scoreNum;
    }

}
