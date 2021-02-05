package com.superjson.common.mapper;

import com.superjson.common.entity.Member;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author： zhubaoya
 * 创建时间：  2021-02-04 15:03:45
 * 描   述：  会员数据访问层
 */
@Mapper
public interface MemberMapper {

    /**
     * create by zhubaoya at 2021-02-04 15:14
     *
     * @return 会员信息
     * @description: 获取会员信息
     */
    Member getInfo();
}
