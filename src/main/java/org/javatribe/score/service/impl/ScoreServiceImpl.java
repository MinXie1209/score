package org.javatribe.score.service.impl;

import org.javatribe.score.enums.ResultEnum;
import org.javatribe.score.exception.ResultException;
import org.javatribe.score.mapper.ScoreMapper;
import org.javatribe.score.po.Result;
import org.javatribe.score.po.Score;
import org.javatribe.score.po.ScoreExample;
import org.javatribe.score.service.ScoreService;
import org.javatribe.score.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ScoreServiceImpl
 * @Description TODO
 * @Author 江南小俊
 * @Date 2018/10/20 22:49
 * @Version 1.0.0
 **/
@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;

    /**
     * 查询所有所有队伍的评分结果（队名，作品名，平均分）
     * 1.当所有评委对队伍打完分数后，才暴露该队伍的信息
     * @return
     * @throws Exception
     */
    @Override
    public Result listScore() throws Exception {
        return ResultUtils.success(scoreMapper.selectScoreAvg());
    }

    /**
     * 查询某个评委评过的队伍信息（队名，作品名，分数）
     *
     * @param judgeId
     * @return
     * @throws Exception
     */
    @Override
    public Result listScoreByJudgeId(int judgeId) throws Exception {

        return ResultUtils.success(scoreMapper.selectByJudgeId(judgeId));
    }

    /**
     * 评分
     * 1.直接进行评分插入
     * 2.重复插入会抛出异常
     * @param score
     * @return
     * @throws Exception
     */
    @Override
    public Result addScore(Score score) throws Exception {
        try {
            scoreMapper.insertSelective(score);
        } catch (Exception e) {
            throw new ResultException(ResultEnum.RESCORE);
        }

        return ResultUtils.success();
    }
}
