/*
 * @Date: 2020-07-25 15:56:36
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-07-26 12:56:48
 * @FilePath: \banana\src\main\java\swu\smxy\banana\entity\User.java
 */ 
package swu.smxy.banana.entity;

import java.io.Serializable;

import org.springframework.core.annotation.Order;

import lombok.Data;

@Data
public class User  implements Serializable {
  private String userId;
  private String userName;
  private String gender;

  @Override
  public String toString()
  {
    return String.format("%s<%s>", userName, userId);
  }
}