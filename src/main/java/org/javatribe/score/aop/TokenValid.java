package org.javatribe.score.aop;

import io.jsonwebtoken.Claims;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.javatribe.score.enums.ResultEnum;
import org.javatribe.score.exception.ResultException;
import org.javatribe.score.mapper.JudgeMapper;
import org.javatribe.score.po.Judge;
import org.javatribe.score.po.JudgeExample;
import org.javatribe.score.po.Score;
import org.javatribe.score.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName TokenValid
 * @Description TODO
 * @Author 江南小俊
 * @Date 2018/10/21 17:23
 * @Version 1.0.0
 **/
@Component
@Aspect
public class TokenValid {
    @Autowired
    private JudgeMapper judgeMapper;

    /**
     * 身份验证切点
     */
    @Pointcut("execution (* org.javatribe.score.controller.*.*(..))&&" + "@annotation(org.javatribe.score.annotation.TokenValid)")
    public void verifyToken() {

    }

    /**
     * 身份验证
     * 1.
     * 2.
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around(value = "verifyToken()")
    public Object verifyUser(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        try {
            String token = request.getHeader("token");
            Claims claims = CommonUtils.parseJWT(token);
            String judgeName = claims.getSubject();
            Object[] objects = joinPoint.getArgs();
            int postId = -1;
            //打分
            if (objects.length > 0) {

                for (Object object : objects) {
                    System.out.println("s:"+object.toString());
                    if (object instanceof Score) {
                        Score score = (Score) object;
                        postId = score.getJudgeId();
                    }
                    else {
                        //查看已打分
                        postId=(int)object;
                    }
                }
            }

            JudgeExample judgeExample = new JudgeExample();
            JudgeExample.Criteria criteria = judgeExample.createCriteria();
            criteria.andJudgeNameEqualTo(judgeName);
            List<Judge> judgeList = judgeMapper.selectByExample(judgeExample);
            if (judgeList.size() > 0) {
                if (postId != judgeList.get(0).getJudgeId()) {
                    throw new ResultException(ResultEnum.JUDGE_ID_ERROR);
                }
            }
            else{
                throw new ResultException(ResultEnum.JUDGE_NAME_ERROR);
            }
        } catch (MethodArgumentTypeMismatchException mme) {
            throw new ResultException(ResultEnum.TOKEN_ERROR);
        } catch (NumberFormatException ne) {
            throw new ResultException(ResultEnum.TOKEN_ERROR);
        } catch (ResultException re) {
            throw re;
        } catch (Exception e) {
            throw new ResultException(ResultEnum.TOKEN_ERROR);
        }

        return joinPoint.proceed(args);
    }
}
