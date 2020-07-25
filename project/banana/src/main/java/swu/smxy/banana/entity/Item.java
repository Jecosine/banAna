package swu.smxy.banana.entity;

import lombok.Data;

@Data
public class Item {
  private String itemId;
  private String itemName;
  private Integer itemCount;
  private String businessId;
}