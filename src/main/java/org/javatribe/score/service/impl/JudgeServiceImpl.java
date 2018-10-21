package org.javatribe.score.service.impl;

import org.javatribe.score.mapper.JudgeMapper;
import org.javatribe.score.po.Judge;
import org.javatribe.score.po.JudgeExample;
import org.javatribe.score.po.Result;
import org.javatribe.score.service.JudgeService;
import org.javatribe.score.utils.CommonUtils;
import org.javatribe.score.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName JudgeServiceImpl
 * @Description TODO
 * @Author 江南小俊
 * @Date 2018/10/20 21:41
 * @Version 1.0.0
 **/
@Service
public class JudgeServiceImpl implements JudgeService {
    @Autowired
    private JudgeMapper judgeMapper;
    /**
     * 注册评委
     * 1.查询是否被注册
     * 2.不是则进行插入
     * @param judgeName
     * @return
     * @throws Exception
     */
    @Override
    public Result registerJudge(String judgeName) throws Exception{
        JudgeExample example = new JudgeExample();
        JudgeExample.Criteria criteria = example.createCriteria();
        criteria.andJudgeNameEqualTo(judgeName);
        Judge judge=new Judge(judgeName);
        List<Judge>judgeList=judgeMapper.selectByExample(example);
        if(judgeList.size()==0){
            judgeMapper.insertSelective(judge);
        }
        else{
            judge.setJudgeId(judgeList.get(0).getJudgeId());
        }
        String token=CommonUtils.createJWT(judgeName, 30*60*1000L);
        HashMap<String,Object> map=new HashMap<>();
        map.put("token",token);
        map.put("judgeId",judge.getJudgeId());
        return ResultUtils.success(map);

    }
}
