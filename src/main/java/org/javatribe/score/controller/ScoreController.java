package org.javatribe.score.controller;

import org.javatribe.score.annotation.TokenValid;
import org.javatribe.score.po.Result;
import org.javatribe.score.po.Score;
import org.javatribe.score.service.ScoreService;
import org.javatribe.score.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * @ClassName ScoreController
 * @Description TODO
 * @Author 江南小俊
 * @Date 2018/10/20 22:43
 * @Version 1.0.0
 **/
@RestController
@RequestMapping("/api")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    /**
     * 获取所有队伍分数信息（按分数排名）
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/score", method = RequestMethod.GET)
    public Result listScore() throws Exception {
        return scoreService.listScore();

    }

    /**
     * 获取评委评过的队伍信息
     *
     * @return
     * @throws Exception
     */
    @TokenValid
    @RequestMapping(value = "/score/judge/{judgeId}", method = RequestMethod.GET)
    public Result listScoreByJudgeId(@PathVariable(required = true) Integer judgeId) throws Exception {

        return scoreService.listScoreByJudgeId(judgeId);
    }

    /**
     * 对某支队伍进行评分
     *
     * @return
     * @throws Exception
     */
    @TokenValid
    @RequestMapping(value = "/score", method = RequestMethod.PUT)
    public Result addScore(@RequestBody @Valid Score score) throws Exception {
        return scoreService.addScore(score);
    }
}
