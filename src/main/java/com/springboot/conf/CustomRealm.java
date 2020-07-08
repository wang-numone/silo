package com.springboot.conf;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springboot.model.ZfUser;
import com.springboot.service.IZfUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {
    @Autowired
    IZfUserService iZfUserService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> stringSet = new HashSet<>();
        stringSet.add("user:show");
        stringSet.add("user:admin");
        info.setStringPermissions(stringSet);
        return info;
    }

    /**
     * 这里可以注入userService,为了方便演示，我就写死了帐号了密码
     * private UserService userService;
     * <p>
     * 获取即将需要认证的信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("-------身份认证方法--------");
        String userName = (String) authenticationToken.getPrincipal();
        String userPwd = new String((char[]) authenticationToken.getCredentials());
        //根据用户名从数据库获取密码
        QueryWrapper<ZfUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", userName);
        ZfUser zfUser = iZfUserService.getOne(queryWrapper);
        if(zfUser == null){
            throw new AuthenticationException("账户不存在");
        }else if (!userName.equals(zfUser.getAccount())) {
            throw new AccountException("用户名错误");
        } else if (!userPwd.equals(zfUser.getPwd() )) {
            throw new AccountException("密码不正确");
        }
        return new SimpleAuthenticationInfo(zfUser.getAccount(), zfUser.getPwd(),getName());
    }
}
