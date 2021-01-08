package com.superjson.common.anno;

import java.lang.annotation.*;

/**
 * 创 建 人： zhubaoya
 * 创建时间：  2020-12-24 15:12:10
 * 描   述：  日志切面工具类
 */
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

}
