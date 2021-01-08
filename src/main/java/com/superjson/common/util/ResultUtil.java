package com.superjson.common.util;

import com.alibaba.fastjson.JSONObject;
import com.superjson.common.returnVo.BaseCodeEnum;
import com.superjson.common.returnVo.Result;

/**
 * 创 建 人： zhubaoya
 * 创建时间：  2020-12-24 15:12:10
 * 描   述：  接口返回信息的工具类
 */
public class ResultUtil<T> {

    /**
     * 成功
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> JSONObject success(T t,String desc) {
        return (JSONObject) JSONObject.toJSON(Result.ResultDesc(BaseCodeEnum.SUCCESS, t,desc));
    }

    /**
     * 失败返回值
     *
     * @param <T>
     * @return
     */
    public static <T> JSONObject failure(String desc) {
        return (JSONObject) JSONObject.toJSON(Result.ResultDesc(BaseCodeEnum.FAILURE, null,desc));
    }

    /**
     * 系统异常
     *
     * @param <T>
     * @return
     */
    public static <T> JSONObject systemError(String desc) {
        return (JSONObject) JSONObject.toJSON(Result.ResultDesc(BaseCodeEnum.SYSTEM_ERROR, null, desc));
    }

    /**
     * 系统异常
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> JSONObject authFAilture(T t,String desc) {
        return (JSONObject) JSONObject.toJSON(Result.ResultDesc(BaseCodeEnum.AUTH_FAILURE, t,desc));
    }

    /**
     * 其他错误信息，后续添加
     *
     * @param
     * @param <T>
     * @return
     */
    public static <T> JSONObject otherErrorByCode(BaseCodeEnum code,String desc) {
        return (JSONObject) JSONObject.toJSON(Result.ResultDesc(code,null,desc));
    }

    /**
     * 其他错误信息，后续添加
     *
     * @param <T>
     * @return
     */
    public static <T> JSONObject otherError(String code, String message) {
        return (JSONObject) JSONObject.toJSON(new Result(code, message,null));
    }

}
