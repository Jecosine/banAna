/*
 * @Date: 2020-07-25 16:04:43
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-21 18:56:25
 * @FilePath: \banana\src\main\java\swu\smxy\banana\entity\Item.java
 */
package swu.smxy.banana.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Item implements Serializable {
  private String itemId;
  private String itemName;
  private Integer itemCount;
  private String businessId;

  /**
   * @return String return the itemId
   */
  public String getItemId() {
    return itemId;
  }

  /**
   * @param itemId the itemId to set
   */
  public void setItemId(String itemId) {
    this.itemId = itemId;
  }

  /**
   * @return String return the itemName
   */
  public String getItemName() {
    return itemName;
  }

  /**
   * @param itemName the itemName to set
   */
  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  /**
   * @return Integer return the itemCount
   */
  public Integer getItemCount() {
    return itemCount;
  }

  /**
   * @param itemCount the itemCount to set
   */
  public void setItemCount(Integer itemCount) {
    this.itemCount = itemCount;
  }

  /**
   * @return String return the businessId
   */
  public String getBusinessId() {
    return businessId;
  }

  /**
   * @param businessId the businessId to set
   */
  public void setBusinessId(String businessId) {
    this.businessId = businessId;
  }

}