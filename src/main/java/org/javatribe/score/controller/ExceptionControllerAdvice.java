package org.javatribe.score.controller;


import org.javatribe.score.exception.ResultException;
import org.javatribe.score.po.Result;
import org.javatribe.score.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;


/**
 * @author 江南小俊
 * @create 2018-06-17 17:37
 * @desc 控制器增强类-异常统一处理
 **/
@ControllerAdvice
public class ExceptionControllerAdvice {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<String> handler(Exception e) {

        if (e instanceof ResultException) {
            return ResultUtils.error(((ResultException) e).getCode(),e.getMessage());
        }
        else if(e instanceof MethodArgumentNotValidException){
            //处理返回的错误信息
            StringBuffer errorMsg = new StringBuffer();
            MethodArgumentNotValidException c = (MethodArgumentNotValidException) e;
            List<ObjectError> errors = c.getBindingResult().getAllErrors();
            for (ObjectError error : errors) {
                errorMsg.append(error.getDefaultMessage()).append(";");
            }
            return ResultUtils.error(errorMsg.toString());
        }
        else {

            logger.info(e.getClass().toString());
            logger.info("系统错误",e);

            return ResultUtils.error(e.getMessage());
        }

    }
}
