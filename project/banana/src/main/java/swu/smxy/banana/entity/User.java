/*
 * @Date: 2020-07-25 15:56:36
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-22 01:54:27
 * @FilePath: \banana\src\main\java\swu\smxy\banana\entity\User.java
 */
package swu.smxy.banana.entity;

import java.io.Serializable;

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
    
    public String getQq()
    {
    	return qq;
    }
    
    public void setQq(String qq) 
    {
    	this.qq = qq;
    }
    
    public String getEmail()
    {
    	return email;
    }
    
    public void setEmail(String email) 
    {
    	this.email = email;
    }
    
    public String getPhone()
    {
    	return phone;
    }
    
    public void setPhone(String phone)
    {
    	this.phone = phone;
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}