package com.superjson.common.returnVo;

/**
 * 创 建 人： zhubaoya
 * 创建时间：  2020-12-25 16:26:11
 * 描   述：  code 枚举类
 */
public enum BaseCodeEnum {

    // 成功
    SUCCESS("0", "成功"),

    //参数问题
    PARAM_BLANK("1000", "入参错误"),
    RESULT_BLANK("1001", "第三方接口无数据返回"),
    SAX_EXCEPTION("1002", "解析异常"),
    SAX_STATUS_EXECEPTION("1003", "第三方接口返回状态异常"),

    // 系统问题
    SYSTEM_ERROR("5000", "系统异常"),

    // 授权
    AUTH_FAILURE("9998", "授权失败"),
    FAILURE("9999", "失败");


    BaseCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String code;

    private String message;

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

}
