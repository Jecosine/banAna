/*
 * @Date: 2020-09-02 16:40:56
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-09-02 17:00:19
 */
package swu.smxy.banana.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.stereotype.Component;

@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class CartItem {
    private String cartId;
    private String itemId;
    private Integer itemCount;
    private String businessId;
    private String businessName;
    private String userId;
    private Float price;
    private String pics;
    private String itemName;
    private String typeCode;
    private String typeJson;
    private List<List<String>> typeObject;
    private List<Integer> typeCodeObject;
    private String selected;
    private String itemStatus;
    /**
     * @return String return the cartId
     */
    public String getCartId() {
        return cartId;
    }

    /**
     * @param cartId the cartId to set
     */
    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

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

    /**
     * @return String return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return Float return the price
     */
    public Float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Float price) {
        this.price = price;
    }


    /**
     * @return String return the pics
     */
    public String getPics() {
        return pics;
    }

    /**
     * @param pics the pics to set
     */
    public void setPics(String pics) {
        this.pics = pics;
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
     * @return String return the businessName
     */
    public String getBusinessName() {
        return businessName;
    }

    /**
     * @param businessName the businessName to set
     */
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }


    /**
     * @return String return the typeCode
     */
    public String getTypeCode() {
        return typeCode;
    }

    /**
     * @param typeCode the typeCode to set
     */
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    /**
     * @return String return the typeJson
     */
    public String getTypeJson() {
        return typeJson;
    }

    /**
     * @param typeJson the typeJson to set
     */
    public void setTypeJson(String typeJson) {
        this.typeJson = typeJson;
    }

    /**
     * @return List<List<String>> return the typeObject
     */
    public List<List<String>> getTypeObject() {
        return typeObject;
    }

    /**
     * @param typeObject the typeObject to set
     */
    public void setTypeObject(List<List<String>> typeObject) {
        this.typeObject = typeObject;
    }

    /**
     * @return List<Integer> return the typeCodeObject
     */
    public List<Integer> getTypeCodeObject() {
        return typeCodeObject;
    }

    /**
     * @param typeCodeObject the typeCodeObject to set
     */
    public void setTypeCodeObject(List<Integer> typeCodeObject) {
        this.typeCodeObject = typeCodeObject;
    }


    /**
     * @return String return the selected
     */
    public String getSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(String selected) {
        this.selected = selected;
    }




    /**
     * @return String return the itemStatus
     */
    public String getItemStatus() {
        return itemStatus;
    }

    /**
     * @param itemStatus the itemStatus to set
     */
    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }

}