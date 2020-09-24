package swu.smxy.banana.configuration;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import swu.smxy.banana.dao.UserMapper;
//import swu.smxy.banana.entity.SysPermission;
//import swu.smxy.banana.entity.SysRole;
import swu.smxy.banana.entity.User;

public class ShiroRealm extends AuthorizingRealm {

	@Autowired
	private UserMapper userMapper;
	
	/**
     * 权限配置
     */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		User userInfo = (User)principals.getPrimaryPrincipal();
		
//		for (SysRole role : userInfo.getRoleList()) {
//			info.addRole(role.getRole());
//			//用户拥有的权限
//			for (SysPermission p : role.getPermissions()) {
//				info.addStringPermission(p.getPermission());
//			}
//		}
		
		return info;
	}
	
	/**
     * 进行身份认证,判断用户名密码是否匹配正确
     */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		 //获取用户的输入的账号
        String username = (String) token.getPrincipal();
        System.out.println(token.getCredentials());
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //Shiro有时间间隔机制，2分钟内不会重复执行该方法
        //获取用户信息
        // TODO Connect to mybatis get session
        User userInfo = userMapper.getByName(username);

        if (userInfo == null) {
            return null;
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
            /**
             * 用户名
             */
            userInfo,
            /**
             * 密码
             */
            userInfo.getPassword(),
            /**
             * realm name
             */
            getName()
        );
        return info;
	}

}
