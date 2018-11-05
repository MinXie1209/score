package org.javatribe.score.po;

import java.io.Serializable;

public class ScoreKey implements Serializable {
    private Integer judgeId;

    private Integer teamId;

    public Integer getJudgeId() {
        return judgeId;
    }

    public void setJudgeId(Integer judgeId) {
        this.judgeId = judgeId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }
}