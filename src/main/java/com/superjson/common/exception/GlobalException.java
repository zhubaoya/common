package com.superjson.common.exception;


import com.alibaba.fastjson.JSONObject;

import com.superjson.common.returnVo.Result;
import com.superjson.common.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 创 建 人： zhubaoya
 * 创建时间：  2020-12-25 14:07:48
 * 描   述：  统一异常处理
 */
@ControllerAdvice
public class GlobalException {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalException.class);

    /**
     * 处理所有不可知的业务异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(CustomerException.class)
    public JSONObject handleCustomerException(CustomerException e) {
        Result result = e.getResult();
        return ResultUtil.otherError(result.getCode(),result.getMessage());
    }

    /**
     * 处理所有不可知的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public JSONObject handleException(Exception e) {
        LOGGER.error(e.getMessage());
        return ResultUtil.systemError(null);
    }



}
