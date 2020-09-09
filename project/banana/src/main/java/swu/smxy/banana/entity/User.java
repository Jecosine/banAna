/*
 * @Date: 2020-07-25 15:56:36
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-09-01 18:33:23
 * @FilePath: \banana\src\main\java\swu\smxy\banana\entity\User.java
 */
package swu.smxy.banana.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Component
public class User implements Serializable, BaseEntity
{
    private String userId;
    private String userName;
    private String gender;
    private String password;
    private String qq;
    private String email;
    private String phone;
    private List<Address> address;
    
    /**
     * 用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
     */
    private byte state;
    /**
     * 立即从数据库中进行加载数据;
     */
    @ManyToMany(fetch= FetchType.EAGER)//
    @JoinTable(name = "SysUserRole", joinColumns = { @JoinColumn(name = "userId") }, inverseJoinColumns ={@JoinColumn(name = "roleId") })
    /**
     * 一个用户具有多个角色
     */
    private List<SysRole> roleList;//
    
    
    @Override
    public String toString()
    {
        return String.format("%s<%s>", userName, userId);
    }

    /**
     * @return String return the userId
     */
    public String getUserId()
    {
        return userId;
    }

    /**
     * @param userId
     *                   the userId to set
     */
    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    /**
     * @return String return the userName
     */
    public String getUserName()
    {
        return userName;
    }

    /**
     * @param userName
     *                     the userName to set
     */
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    /**
     * @return String return the gender
     */
    public String getGender()
    {
        return gender;
    }

    /**
     * @param gender
     *                   the gender to set
     */
    public void setGender(String gender)
    {
        this.gender = gender;
    }
   
    
    public String getPassword()
    {
    	return password;
    }
    
    public void setPassword(String password)
    {
    	this.password = password;
    }

    /**
     * @return String return the qq
     */
    public String getQq() {
        return qq;
    }

    /**
     * @param qq the qq to set
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * @return List<Address> return the address
     */
    public List<Address> getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(List<Address> address) {
        this.address = address;
    }


    /**
     * @return String return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String getId()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getName()
    {
        // TODO Auto-generated method stub
        return null;
    }


    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }
    
    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

}