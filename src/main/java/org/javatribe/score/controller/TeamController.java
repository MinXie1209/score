package org.javatribe.score.controller;

import org.javatribe.score.po.Result;
import org.javatribe.score.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName TeamController
 * @Description TODO
 * @Author 江南小俊
 * @Date 2018/10/20 22:27
 * @Version 1.0.0
 **/
@RestController
@RequestMapping("/api")
public class TeamController {
    @Autowired
    private TeamService teamService;

    /**
     * 获取所有队伍信息
     * @return
     */
    @RequestMapping(value = "/team",method = RequestMethod.GET)
    public Result listTeam() throws Exception{
        return  teamService.listTeam();

    }

    /**
     * 获取某支队伍信息
     * @param teamId
     * @return
     */
    @RequestMapping(value = "/team/{teamId}",method = RequestMethod.GET)
    public Result getTeam(@PathVariable(required = true)Integer teamId) throws Exception{
       return teamService.getTeam(teamId);
    }

}
