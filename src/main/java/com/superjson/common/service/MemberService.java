package com.superjson.common.service;

import com.superjson.common.entity.Member;
import com.superjson.common.mapper.MemberMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author： zhubaoya
 * 创建时间：  2021-02-04 15:13:10
 * 描   述：  会员服务
 */
@Repository
@Transactional(rollbackFor = Exception.class)
public class MemberService {

    @Resource
    private MemberMapper memberMapper;

    public Member getInfo() {
        Member info = memberMapper.getInfo();
        return info;
    }
}
