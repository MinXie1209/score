package org.javatribe.score.po;

import java.io.Serializable;

/**
 * @ClassName ScoreAvg
 * @Description TODO
 * @Author 江南小俊
 * @Date 2018/10/21 16:30
 * @Version 1.0.0
 **/
public class ScoreAvg extends Team implements Serializable {
    private Double avg;

    public Double getAvg() {
        return avg;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }
}
