package com.superjson.common.util;

/**
 * 创 建 人： zhubaoya
 * 创建时间：  2020-12-24 15:50:25
 * 描   述：  判断对象是否为空
 */
public class ObjectUtil<T> {

    /**
     * 判断对象为空
     * @param t
     * @return
     */
    public static <T>boolean isNull(T t){
        return t==null;
    }

    /**
     * 判断对象不为空
     * @param t
     * @return
     */
    public static <T>boolean isNotNull(T t){
        return t!=null;
    }
}
