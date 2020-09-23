package swu.smxy.banana.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Order implements Serializable{
    private String orderId;
    private String orderDateTime;
    private String businessId;
    private String userId;
    private String businessName;
    private Float orderPrice;
    private List<CartItem> orderItemList;
    private String orderItemListParsed;
    private String orderStatus;
    private String parentId;
    private String address;
    /**
     * @return String return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * @return String return the orderDateTime
     */
    public String getOrderDateTime() {
        return orderDateTime;
    }

    /**
     * @param orderDateTime the orderDateTime to set
     */
    public void setOrderDateTime(String orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    /**
     * @return Float return the orderPrice
     */
    public Float getOrderPrice() {
        return orderPrice;
    }

    /**
     * @param orderPrice the orderPrice to set
     */
    public void setOrderPrice(Float orderPrice) {
        this.orderPrice = orderPrice;
    }

    /**
     * @return List<CartItem> return the orderItemList
     */
    public List<CartItem> getOrderItemList() {
        return orderItemList;
    }

    /**
     * @param orderItemList the orderItemList to set
     */
    public void setOrderItemList(List<CartItem> orderItemList) {
        this.orderItemList = orderItemList;
    }


    /**
     * @return String return the orderStatus
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * @param orderStatus the orderStatus to set
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
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
     * @return String return the orderItemListParsed
     */
    public String getOrderItemListParsed() {
        return orderItemListParsed;
    }

    /**
     * @param orderItemListParsed the orderItemListParsed to set
     */
    public void setOrderItemListParsed(String orderItemListParsed) {
        this.orderItemListParsed = orderItemListParsed;
    }


    /**
     * @return String return the parentId
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * @param parentId the parentId to set
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }


    /**
     * @return String return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

}