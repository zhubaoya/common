package com.superjson.common.controller;

import com.alibaba.fastjson.JSONObject;
import com.superjson.common.anno.SysLog;
import com.superjson.common.service.MemberService;
import com.superjson.common.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author： zhubaoya
 * 创建时间：  2021-02-04 15:12:01
 * 描   述：  会员控制层
 */
@RestController
@RequestMapping("/svc-sign/v1/member")
public class MemberController {

    private Logger logger = LoggerFactory.getLogger(RsaController.class);

    @Resource
    private MemberService memberService;

    @SysLog
    @GetMapping(value = "/pageObj")
    public JSONObject getInfo() {
        return ResultUtil.success(memberService.getInfo(), "success");
    }
}
