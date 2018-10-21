package org.javatribe.score.service;

import org.javatribe.score.po.Result;

public interface JudgeService {
    /**
     * 注册评委
     * @param judgeName
     * @return
     */
    Result registerJudge(String judgeName) throws Exception;
}
