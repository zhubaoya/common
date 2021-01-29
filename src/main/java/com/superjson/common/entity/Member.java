package com.superjson.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 创 建 人： zhubaoya
 * 创建时间：  2021-01-29 16:01:47
 * 描   述：  会员
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Member implements Serializable {

    public static final String Table = "t_user";

    private static final long serialVersionUID = -975769462920892707L;

    private String name;
    private String address;
    private Integer age;
    private String token;
    private Long id;
}
