package org.javatribe.score.service;

import org.javatribe.score.po.Result;

/**
 * @ClassName TeamService
 * @Description TODO
 * @Author 江南小俊
 * @Date 2018/10/20 22:28
 * @Version 1.0.0
 **/
public interface TeamService {
    Result listTeam() throws Exception;
    Result getTeam(Integer teamId) throws Exception;
}
