package com.superjson.common.util;

import com.alibaba.fastjson.JSONObject;
import com.superjson.common.controller.RsaController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;

/**
 * 创 建 人： zhubaoya
 * 创建时间：  2021-01-08 18:42:40
 * 描   述：  则是信息流工具类，包括文件操作，req请求流
 */
public class FileUtil {

    private static Logger logger = LoggerFactory.getLogger(RsaController.class);

    public static Map<String, Object> reqToMap(HttpServletRequest request) {

        logger.info("开始解析请求流");

        BufferedReader br = null;
        InputStreamReader isr = null;
        try {
            isr = new InputStreamReader(request.getInputStream());
            br = new BufferedReader(isr);
        } catch (IOException e) {
            logger.error("读取参数流异常");
            e.printStackTrace();
        }

        StringBuffer sb = new StringBuffer();
        String s;
        try {
            while (true) {
                if (!((s = br.readLine()) != null)) break;
                sb.append(s);
            }
        } catch (IOException e) {
            logger.error("解析参数流异常");
            e.printStackTrace();
        } finally {
            closeIsReader(isr, br);
        }


        Map<String, Object> map = JSONObject.parseObject(sb.toString(), Map.class);
        logger.info("解析请求流结束，请求数据={}", map);

        return map;
    }

    /**
     * 关闭输入流
     * @param readers
     */
    public static void closeIsReader(Reader... readers) {
        if (readers != null || readers.length > 0) {
            try {
                for (Reader reader : readers) {
                    reader.close();
                }
            } catch (IOException e) {
                logger.error("关闭参数流异常");
                e.printStackTrace();
            }
        }
    }
}
