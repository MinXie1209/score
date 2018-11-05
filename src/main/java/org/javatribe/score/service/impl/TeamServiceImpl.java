package org.javatribe.score.service.impl;

import org.javatribe.score.enums.ResultEnum;
import org.javatribe.score.mapper.TeamMapper;
import org.javatribe.score.po.Result;
import org.javatribe.score.po.Team;
import org.javatribe.score.service.TeamService;
import org.javatribe.score.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName TeamServiceImpl
 * @Description TODO
 * @Author 江南小俊
 * @Date 2018/10/20 22:33
 * @Version 1.0.0
 **/
@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamMapper teamMapper;
    @Autowired
    private RedisTemplate<String, Team> teamRedisTemplate;
    @Autowired
    private RedisTemplate<String, List<Team>> teamListRedisTemplate;

    /**
     * 获取所有队伍信息
     *
     * @return
     * @throws Exception
     */
    @Override
    public Result listTeam() throws Exception {

        if (teamListRedisTemplate.opsForValue().get("listTeam") != null) {
            System.out.println("listTeam已缓存");
            return ResultUtils.success(teamListRedisTemplate.opsForValue().get("listTeam"));
        } else {
            List<Team> teams = teamMapper.selectByExample(null);
            Result result = ResultUtils.success(teams);
            teamListRedisTemplate.opsForValue().set("listTeam", teams);
            return result;
        }
    }


    /**
     * 获取某个队伍的信息
     *
     * @param teamId
     * @return
     * @throws Exception
     */
    @Override
    public Result getTeam(Integer teamId) throws Exception {
        Team team = teamMapper.selectByPrimaryKey(teamId);
        if (team == null) {
            return ResultUtils.error(ResultEnum.TEAM_NULL);
        }
        return ResultUtils.success(team);
    }
}
