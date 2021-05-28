package com.example.demo.Controller;

import com.example.demo.Base.BaseController;
import com.example.demo.Model.Jitang;
import com.example.demo.Service.JitangService;
import com.example.demo.util.FastJsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jitang")
@Api(description = "鸡汤接口")
public class JitangController extends BaseController {

    @Autowired
    private JitangService jitangService;

    /**
     * 列表测试
     */

    @GetMapping(value = "/all", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "全部鸡汤", notes = "全部鸡汤")
    public String all() {
        List<Jitang> result = jitangService.showAllcourse();
        return FastJsonUtils.resultSuccess(200, "拉取鸡汤列表成功", result);
    }

    @GetMapping(value = "/delete", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "删除鸡汤", notes = "删除鸡汤")
    public String delete(@ApiParam(name = "jid", value = "鸡汤id", required = true) @RequestParam long jid) {
        jitangService.deleteJitang(jid);
        Map<String, Object> result = new HashMap<>();
        result.put("jid", jid);
        return FastJsonUtils.resultSuccess(200, "删除鸡汤成功", result);
    }

    @GetMapping(value = "/insert", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "添加鸡汤", notes = "添加鸡汤")
    public String insert(@ApiParam(name = "content", value = "鸡汤content", required = true) @RequestParam String content) {
        jitangService.insertJitang(content);
        Map<String, Object> result = new HashMap<>();
        result.put("content", content);
        return FastJsonUtils.resultSuccess(200, "添加鸡汤成功", result);
    }

}