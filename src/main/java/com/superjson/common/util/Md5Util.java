package com.superjson.common.util;

import java.security.MessageDigest;

public class Md5Util {

    /**
     * 对字符串进行md5,各个语言均有md5
     *
     * @param str 签名字符串
     * @return
     */
    public static String md5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            //原因在于汉字编码，在加密时设置一下编码UTF-8，问题解决。
            md.update(str.getBytes("UTF-8"));
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            str = buf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

}
