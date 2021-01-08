package com.superjson.common.controller;

import com.alibaba.fastjson.JSONObject;
import com.superjson.common.anno.SysLog;
import com.superjson.common.util.GenSignSrcUtil;
import com.superjson.common.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static com.superjson.common.constant.PublicKeyConstant.PUBLIC_KEY;
import static com.superjson.common.util.FileUtil.reqToMap;
import static com.superjson.common.util.Md5Util.md5;
import static com.superjson.common.util.RsaUtil.encryptByPublicKey;


/**
 * 创 建 人： zhubaoya
 * 创建时间：  2020-12-23 16:31:15
 * 描   述：  处理RSA的控制器
 */
@RestController
@RequestMapping("/svc-sign/v1/rsa")
public class RsaController {

    private Logger logger = LoggerFactory.getLogger(RsaController.class);

    @SysLog
    @PostMapping("sign")
    public JSONObject getSign(HttpServletRequest request) {
        Map<String, Object> signMap = reqToMap(request);
        String signParamsForZy = GenSignSrcUtil.getSignParams(signMap);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("sign", encryptByPublicKey(md5(signParamsForZy), (String) signMap.get(PUBLIC_KEY)));
        } catch (Exception e) {
            logger.error("加密异常，e={},param={}", e.getMessage(), signParamsForZy);
            return ResultUtil.systemError("加密异常，e=" + e.getMessage() + ",param=" + signParamsForZy);
        }
        JSONObject success = ResultUtil.success(jsonObject, "success");
        logger.info("加密结果，请求数据={},返回数据={}", signMap, success);
        return success;
    }

}
