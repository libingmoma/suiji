package com.example.demo.Controller;

import com.example.demo.Base.BaseController;
import com.example.demo.Model.Student;
import com.example.demo.Service.StudentService;
import com.example.demo.util.FastJsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.bytebuddy.utility.RandomString;
import org.bouncycastle.crypto.prng.RandomGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 学生控制层
 *
 * @author fang.zhijun
 */
@RestController
@RequestMapping("/student")
@Api(description = "用户接口")
public class StudentController extends BaseController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    //过期时间60秒
    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    /**
     * 列表
     */
    @GetMapping(value = "/all", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "全部用户", notes = "全部用户")
    public String all(){
        List<Student> result = studentService.showAllStudent();
        return FastJsonUtils.resultSuccess(200, "拉取学生列表成功", result);
    }

    @GetMapping("/register_or_login/send_auth_code")
    @ApiOperation(value = "获取验证码", notes = "注册、登录获取验证码")
    public String registerOrLoginStepOne(@ApiParam(name = "phone", value = "手机号",required = true)
                                         @RequestParam String phone) {
        String json=sendVerifyCode(phone);
        Map<String,Object> resMap=FastJsonUtils.getAllInfo(json);
        if(resMap.containsKey("smsId"))
            return FastJsonUtils.resultSuccess(200, "验证码发送成功", null);
        else return FastJsonUtils.resultSuccess(200, "验证码发送失败", null);
    }

    @PostMapping("/register_or_login/verify_auth_code")
    @ApiOperation(value = "验证验证码", notes = "验证验证码")
    public String registerOrLoginStepTwo(@ApiParam(name = "phone", value = "手机号",required = true)@RequestParam String phone,
                                         @ApiParam(name = "code", value = "验证码",required = true)@RequestParam String code) {
        boolean flag=verifyCode(phone,code);
        Map<String,Object> map=new HashMap<>();
        if(flag){
            map.put("result",true);
            //登录
            if(studentService.SelectByPhone(phone).size()==1) {
                Student stu=studentService.SelectByPhone(phone).get(0);
                map.put("uid",stu.getUid());
                return FastJsonUtils.resultSuccess(200, "验证通过,用户登录成功", map);
            }
            //注册
            else{
                long uid= getIdGeneratorUtils().nextId();
                Student stu=new Student();
                stu.setUid(uid);
                stu.setPhone(phone);
                studentService.addStudent(stu);//插入
                map.put("uid",stu.getUid());
                return FastJsonUtils.resultSuccess(200, "验证通过,用户注册成功", map);
            }
        }
        //验证码错误
        else {
            map.put("result",true);
            return FastJsonUtils.resultSuccess(200, "验证码错误，用户注册/登录失败", map);
        }
    }

    public boolean verifyCode(String phone,String code){
        String uri = "https://api2.bmob.cn/1/verifySmsCode/"+code;
        Map<String, String> map = new HashMap<>();
        map.put("mobilePhoneNumber", phone);

        try {
            ResponseEntity<String> apiResponse = restTemplate.postForEntity
                    (
                            uri,
                            generatePostJson(map),
                            String.class
                    );
            if (apiResponse.getStatusCode().value() == 200) {
                String json = apiResponse.getBody();
                Map<String, Object> resMap = FastJsonUtils.getAllInfo(json);
                return resMap.get("msg").equals("ok");
            }
        }
        catch(Exception e){
            return false;
        }
        return false;
    }

    public String sendVerifyCode(String phone){
        String uri = "https://api2.bmob.cn/1/requestSmsCode";

        Map<String, String> map = new HashMap<>();
        map.put("mobilePhoneNumber", phone);

        ResponseEntity<String> apiResponse = restTemplate.postForEntity
                (
                        uri,
                        generatePostJson(map),
                        String.class
                );
        return apiResponse.getBody();
    }

    public HttpEntity<Map<String, String>> generatePostJson(Map<String, String> jsonMap) {

        //如果需要其它的请求头信息、都可以在这里追加
        HttpHeaders httpHeaders = new HttpHeaders();

        MediaType type = MediaType.parseMediaType("application/json;charset=UTF-8");

        httpHeaders.setContentType(type);
        httpHeaders.set("X-Bmob-Application-Id","f397a2b89250b22bd4482c8a19adcb20");
        httpHeaders.set("X-Bmob-REST-API-Key","3c61f80666e631db54adb751658ce775");

        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(jsonMap, httpHeaders);

        return httpEntity;
    }

    @PostMapping("/login_v2")
    @ApiOperation(value = "登录_v2", notes = "登录_v2")
    public String login(@ApiParam(name = "phone", value = "手机号",required = true)@RequestParam String phone,
                        @ApiParam(name = "password", value = "密码",required = true)@RequestParam String password) {
        Student stu=new Student();
        stu.setPhone(phone);
        stu.setPassword(password);
        if(studentService.auth(stu))
            return FastJsonUtils.resultSuccess(200, "用户登录成功", stu);
        else
            return FastJsonUtils.resultSuccess(200, "用户登录失败", null);
    }

    @PostMapping("/update_info")
    @ApiOperation(value = "修改用户信息", notes = "修改用户信息")
    public String updateInfo(@ApiParam(name = "uid", value = "用户id",required = true)@RequestParam Long uid,
                             @ApiParam(name = "name", value = "用户名")@RequestParam(required = false, defaultValue = "") String name,
                             @ApiParam(name = "password", value = "密码")@RequestParam(required = false, defaultValue = "") String password,
                             @ApiParam(name = "description", value = "用户描述")@RequestParam(required = false, defaultValue = "") String description
    ) {
        Student newStu=studentService.searchByUid(uid).get(0);
        if(!"".equals(name))
            newStu.setName(name);
        if(!"".equals(password))
            newStu.setPassword(password);
        if(!"".equals(description))
            newStu.setDescription(description);
        studentService.update(newStu);
        return FastJsonUtils.resultSuccess(200, "修改成功", null);
    }

    @GetMapping("/search")
    @ApiOperation(value = "查找用户", notes = "根据用户id/用户描述查找用户")
    public String search(@ApiParam(name = "uid", value = "用户id")@RequestParam(required = false) Long uid,
                         @ApiParam(name = "description", value = "用户描述")@RequestParam(required = false, defaultValue = "") String description) {
        List<Student> students;
        if (uid == null && description.equals(""))
            return FastJsonUtils.resultSuccess(200, "请输入查询条件", null);
        else if (uid != null)
            students = studentService.searchByUid(uid);
        else
            students = studentService.searchByDescription(description);
        return FastJsonUtils.resultSuccess(200, "用户查询成功", students);
    }

}
