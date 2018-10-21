package org.javatribe.score.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.javatribe.score.po.*;

public interface ScoreMapper {
    int countByExample(ScoreExample example);

    int deleteByExample(ScoreExample example);

    int deleteByPrimaryKey(ScoreKey key);

    int insert(Score record);

    int insertSelective(Score record);

    List<Score> selectByExample(ScoreExample example);

    Score selectByPrimaryKey(ScoreKey key);

    int updateByExampleSelective(@Param("record") Score record, @Param("example") ScoreExample example);

    int updateByExample(@Param("record") Score record, @Param("example") ScoreExample example);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);

    List<ScorePro> selectByJudgeId(Integer judgeId);
    List<ScoreAvg> selectScoreAvg();
}