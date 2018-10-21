package org.javatribe.score.po;

public class Judge {
    private Integer judgeId;

    private String judgeName;

    public Judge() {
    }

    public Judge(String judgeName) {
        this.judgeName = judgeName;
    }

    public Judge(Integer judgeId, String judgeName) {
        this.judgeId = judgeId;
        this.judgeName = judgeName;
    }

    public Integer getJudgeId() {
        return judgeId;
    }

    public void setJudgeId(Integer judgeId) {
        this.judgeId = judgeId;
    }

    public String getJudgeName() {
        return judgeName;
    }

    public void setJudgeName(String judgeName) {
        this.judgeName = judgeName == null ? null : judgeName.trim();
    }
}