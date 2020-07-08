package com.springboot.controller;

import com.springboot.model.ZfUser;
import com.springboot.util.ResultInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    // 登录
    @GetMapping(value = {"/login", "","/"})
    public ResultInfo login(ZfUser ZfUser){
        ResultInfo resultInfo = new ResultInfo();
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(ZfUser.getAccount(), ZfUser.getPwd());
        // 执行认证登陆
        try {
            subject.login(token);
//        } catch (UnknownAccountException uae) {
//            return resultInfo.result("未知账号");
//        } catch (IncorrectCredentialsException ice) {
//            return resultInfo.result("密码不正确");
//        } catch (LockedAccountException lae) {
//            return resultInfo.result("账户已锁定");
//        } catch (ExcessiveAttemptsException eae) {
//            return resultInfo.result("用户名或密码错误次数过多");
        } catch (AccountException ae) {
            return resultInfo.result("用户名或密码不正确！");
        }catch (AuthenticationException au) {
            return resultInfo.result("账户不存在");
        }
        if (subject.isAuthenticated()) {
            return resultInfo.result("登录成功");
        } else {
            token.clear();
            return resultInfo.result("登录失败");
        }
    }
}
