package org.javatribe.score.controller;

import org.javatribe.score.enums.ResultEnum;
import org.javatribe.score.exception.ResultException;
import org.javatribe.score.po.Result;
import org.javatribe.score.service.JudgeService;
import org.javatribe.score.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName JudgeController
 * @Description 评委控制器
 * @Author 江南小俊
 * @Date 2018/10/20 21:28
 * @Version 1.0.0
 **/
@RestController()
@RequestMapping("/api")
public class JudgeController {
    @Value("${code}")
    private int code;
    @Autowired
    JudgeService judgeService;
    @RequestMapping(value = "/judge",method = RequestMethod.PUT)
    public Result<String> registerJudge(@RequestParam(required = true) String judgeName,@RequestParam(required = true) int code) throws Exception {
        if(code==this.code){
            return judgeService.registerJudge(judgeName);
        }
        return ResultUtils.error(ResultEnum.CODE_ERROR);
    }
}
