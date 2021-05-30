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

    @GetMapping(value = "/show", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "全部鸡汤", notes = "全部鸡汤")
    public String all() {
        List<Jitang> result = jitangService.showAlljitang();
        return FastJsonUtils.resultSuccess(200, "拉取鸡汤列表成功", result);
    }
    @GetMapping(value = "/change", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "更新鸡汤", notes = "更新鸡汤")
    public String update(@ApiParam(name = "content", value = "鸡汤content", required = true) @RequestParam String content,
                         @ApiParam(name = "newcontent", value = "更新的鸡汤content", required = true) @RequestParam String newcontent
                        ) {
        jitangService.deleteJitang(content);
        jitangService.insertJitang(newcontent);
        Map<String, Object> result = new HashMap<>();
        result.put("content", newcontent);
        return FastJsonUtils.resultSuccess(200, "更新鸡汤成功", result);
    }



}
