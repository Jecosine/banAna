/*
 * @Date: 2020-07-25 15:56:36
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-31 19:10:10
 * @FilePath: \banana\src\main\java\swu\smxy\banana\entity\User.java
 */
package swu.smxy.banana.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class User implements Serializable, BaseEntity
{
    private String userId;
    private String userName;
    private String gender;
    private String qq;
    private List<Address> address;
    private String phone;
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
    public String getId()
    {
        return this.userId;
    }
    public String getName()
    {
        return this.userName;
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

}