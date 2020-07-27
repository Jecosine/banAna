package swu.smxy.banana.entity;

import org.springframework.core.annotation.Order;

import lombok.Data;

@Data
public class User {
  private String userId;
  private String userName;
  private String gender;

  @Override
  public String toString()
  {
    return String.format("%s<%s>", userName, userId);
  }
}