package org.javatribe.score.service;

import org.javatribe.score.po.Result;
import org.javatribe.score.po.Score;

public interface ScoreService {
    Result listScore()throws Exception;

    Result listScoreByJudgeId(int judgeId)throws Exception;

    Result addScore(Score score)throws Exception;
}
