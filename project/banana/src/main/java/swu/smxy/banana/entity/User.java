/*
 * @Date: 2020-07-25 15:56:36
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-19 13:24:09
 * @FilePath: \banana\src\main\java\swu\smxy\banana\entity\User.java
 */ 
package swu.smxy.banana.entity;

import java.io.Serializable;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
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