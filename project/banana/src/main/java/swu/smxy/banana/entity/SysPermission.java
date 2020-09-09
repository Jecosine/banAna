package swu.smxy.banana.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


public class SysPermission implements Serializable {

	/**
     * 权限ID.
     */
	private int id;
	
	/**
     * 权限名称.
     */
	private String name;
	
	/**
     * 资源路径
     */
    private String url;
    
    /**
     * 权限字符串
     */
    private String permission;
    
    private Boolean available = Boolean.FALSE;
    @ManyToMany
    @JoinTable(name="SysRolePermission",joinColumns={@JoinColumn(name="permissionId")},inverseJoinColumns={@JoinColumn(name="roleId")})
    private List<SysRole> roles;
}
