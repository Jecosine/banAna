/*
 * @Date: 2020-09-02 16:40:56
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-09-02 16:42:58
 */
package swu.smxy.banana.entity;

import org.springframework.stereotype.Component;

@Component
public class CartItem {
    private String cartId;
    private String itemId;
    private Integer itemCount;
    private String businessId;
    private String userId;
    private Float price;

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

}