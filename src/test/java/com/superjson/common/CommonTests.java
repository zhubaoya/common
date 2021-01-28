package com.superjson.common;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

/**
 * 创 建 人： zhubaoya
 * 创建时间：  2021-01-28 16:17:45
 * 描   述：  普通测试类
 */
public class CommonTests {

    @Test
    public void test() {
        JSONObject jsonObject = JSONObject.parseObject("{\"id\":\"ss\"}");
        System.out.println(jsonObject);
    }
}
