package com.superjson.common.util;

import org.apache.commons.lang3.StringUtils;

import javax.xml.ws.soap.Addressing;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static com.superjson.common.constant.PublicKeyConstant.*;
import static com.superjson.common.util.Md5Util.md5;
import static com.superjson.common.util.RsaUtil.encryptByPublicKey;


/**
 * 创 建 人： zhubaoya
 * 创建时间：  2020-12-23 17:54:00
 * 描   述：  生成各种签名原串
 */
public class GenSignSrcUtil {

    /**
     * 获取需要签名的数据,未进行MD5
     *
     * @param map 参数集合
     * @create zhubaoya
     */
    public static String getSignParams(Map<String, Object> map) {
        // 根据KEY排序
        Map<String, Object> sortedParamMap = new TreeMap<>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            //略过sign、serialVersionUID、以t_开头的参数
            if (entry.getKey().equalsIgnoreCase(PARAM_SIGN) || entry.getKey().toLowerCase().startsWith(PARAM_STARTWITH)
                    || entry.getKey().equalsIgnoreCase(serialVersionUID) || entry.getKey().equalsIgnoreCase(PUBLIC_KEY)) {
                continue;
            }
            sortedParamMap.put(entry.getKey(), entry.getValue());
        }
        // 最终结果
        List<Object> allList = new LinkedList<>();
        for (Object value : sortedParamMap.values()) {
            if (value instanceof String) {
                if (StringUtils.isBlank((String) value)) {
                    continue;
                }
            }
            allList.add(value);

        }
        String a = StringUtils.join(allList.iterator(), PARAM_SPLIT);
        return a;
    }

}
