package com.superjson.common.exception;


import com.superjson.common.returnVo.Result;

/**
 * 创 建 人： zhubaoya
 * 创建时间：  2020-12-25 14:36:57
 * 描   述：  业务异常处理
 */
public class CustomerException extends RuntimeException{

    private Result result;

    public CustomerException(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
