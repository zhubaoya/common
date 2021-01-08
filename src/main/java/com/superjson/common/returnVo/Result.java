package com.superjson.common.returnVo;

import org.apache.commons.lang3.StringUtils;

/**
 * 创 建 人： zhubaoya
 * 创建时间：  2020-12-24 14:44:34
 * 描   述：  返回信息
 */
public class Result<T> {

    /**
     * 额外描述信息
     */

    private String code;
    private String message;
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMessage(BaseCodeEnum baseCode, String message, String desc) {
        if (StringUtils.isNotBlank(desc)) {
            this.message = this.message + "【" + desc + "】";
        } else {
            this.message = baseCode.getMessage();
        }
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result(String code, String message, T t) {
        this.code = code;
        this.message = message;
        this.data = t;
    }

    public static <T>Result ResultDesc(BaseCodeEnum baseCode, T t,String desc) {
        Result result=new Result();
        result.code = baseCode.getCode();
        if (StringUtils.isNotBlank(desc)) {
            result.message = baseCode.getMessage() + "【" + desc + "】";
        } else {
            result.message = baseCode.getMessage();
        }
        result.setData(t);
        return result;
    }

    public Result(){

    }

}
