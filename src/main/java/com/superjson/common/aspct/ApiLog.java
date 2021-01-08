package com.superjson.common.aspct;

import lombok.Data;

/**
 * 创 建 人： zhubaoya
 * 创建时间：  2020-12-25 13:57:01
 * 描   述：  日志记录
 */
@Data
public class ApiLog {
    private int id;
    private String description;
    private String basePath;
    private String uri;
    private Long startTime;
    private Integer spendTime;
    private String method;
    private String ip;
    private Object parameter;
    private Object result;
}
