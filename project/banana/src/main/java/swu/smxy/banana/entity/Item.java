/*
 * @Date: 2020-07-25 16:04:43
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-07-26 12:59:21
 * @FilePath: \banana\src\main\java\swu\smxy\banana\entity\Item.java
 */ 
package swu.smxy.banana.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Item  implements Serializable {
  private String itemId;
  private String itemName;
  private Integer itemCount;
  private String businessId;
}