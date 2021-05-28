package com.example.demo.Controller;
import com.example.demo.Base.BaseController;
import com.example.demo.Model.Content;
import com.example.demo.Service.ContentService;
import com.example.demo.util.FastJsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/content")
@Api(description = "内容接口")
public class ContentController extends BaseController {
    @Autowired
    private ContentService contentService;


    @GetMapping(value = "/all", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "全部内容", notes = "全部内容")
    public String all() {
        List<Content> result = contentService.showAllContent();
        return FastJsonUtils.resultSuccess(200, "拉取内容列表成功", result);
    }



    @ResponseBody
    @PostMapping(value = "/commit", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "保存内容", notes = "保存内容")
    public String commit(@ApiParam(name = "ctype", value = "内容类型",required = true) @RequestParam int ctype,

                         @ApiParam(name = "cdescription", value = "内容描述") @RequestParam(required = false, defaultValue = "") String cdescription,
                         @ApiParam(name = "rtime", value = "记录时间") @RequestParam(required = false, defaultValue = "") String rtime,
                         @ApiParam(name = "picuri", value = "图片uri",required = true) @RequestParam String picuri) {
        System.out.println(ctype);
        long cid = super.getIdGeneratorUtils().nextId();
        Content content = new Content(cid, ctype, cdescription, picuri,rtime);
        contentService.addContent(content);
        Map<String, Object> result = new HashMap<>();
        result.put("cid", cid);
        return FastJsonUtils.resultSuccess(200, "保存内容成功", result);
    }

    @GetMapping(value = "/delete", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "删除内容" , notes = "删除内容")
    public String delete(@ApiParam(name = "rtime", value = "记录时间",required = true) @RequestParam String rtime) {
        contentService.deleteByRtime(rtime);
        Map<String, Object> result = new HashMap<>();
        result.put("rtime", rtime);
        return FastJsonUtils.resultSuccess(200, "删除商品成功", result);
    }
}
