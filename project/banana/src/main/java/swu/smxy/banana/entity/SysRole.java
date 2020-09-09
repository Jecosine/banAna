package swu.smxy.banana.entity;

import java.util.List;
import javax.persistence.*;
import org.springframework.stereotype.Component;

@Component
public class SysRole {

	/**
     * 角色标识程序中判断使用,如"admin",这个是唯一的
     */
	private String role;
	/**
     *  是否可用,如果不可用将不会添加给用户
     */
	private Boolean available = Boolean.FALSE;
	
	/**
	 * 角色权限关系：多对多关系;
  	*/
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name="SysRolePermission",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="permissionId")})
    private List<SysPermission> permissions;
    /**
     * 用户角色关系定义;
     */
    @ManyToMany
	@JoinTable(name="SysUserRole",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="userId")})
    /**
     * 一个角色对应多个用户
     */
     private List<User> users;	
	    
	    
}
