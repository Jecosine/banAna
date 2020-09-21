/*
 * @Date: 2020-07-25 16:04:43
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-09-05 22:45:25
 * @FilePath: \banana\src\main\java\swu\smxy\banana\entity\Item.java
 */
package swu.smxy.banana.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Item implements Serializable
{
    private String itemId;
    private String itemName;
    private String pics;
    private Integer itemCount;
    private String businessId;
    private String businessName;
    private Integer remain;
    private String tsid;
    private String tid;
    private String location;
    private Float price;
    private Integer sale;
    private String cateId;
    private String typeCode;
    private String parentId;
    private String itemStatus;
    private List<ItemType> itemTypesList;
    /**
     * @return String return the itemId
     */
    public String getItemId()
    {
        return itemId;
    }

    /**
     * @param itemId
     *                   the itemId to set
     */
    public void setItemId(String itemId)
    {
        this.itemId = itemId;
    }

    /**
     * @return String return the itemName
     */
    public String getItemName()
    {
        return itemName;
    }

    /**
     * @param itemName
     *                     the itemName to set
     */
    public void setItemName(String itemName)
    {
        this.itemName = itemName;
    }

    /**
     * @return Integer return the itemCount
     */
    public Integer getItemCount()
    {
        return itemCount;
    }

    /**
     * @param itemCount
     *                      the itemCount to set
     */
    public void setItemCount(Integer itemCount)
    {
        this.itemCount = itemCount;
    }

    /**
     * @return String return the businessId
     */
    public String getBusinessId()
    {
        return businessId;
    }

    /**
     * @param businessId
     *                       the businessId to set
     */
    public void setBusinessId(String businessId)
    {
        this.businessId = businessId;
    }


    /**
     * @return Integer return the remain
     */
    public Integer getRemain() {
        return remain;
    }

    /**
     * @param remain the remain to set
     */
    public void setRemain(Integer remain) {
        this.remain = remain;
    }

    /**
     * @return String return the tsid
     */
    public String getTsid() {
        return tsid;
    }

    /**
     * @param tsid the tsid to set
     */
    public void setTsid(String tsid) {
        this.tsid = tsid;
    }

    /**
     * @return String return the tid
     */
    public String getTid() {
        return tid;
    }

    /**
     * @param tid the tid to set
     */
    public void setTid(String tid) {
        this.tid = tid;
    }

    /**
     * @return String return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
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
     * @return Integer return the sale
     */
    public Integer getSale() {
        return sale;
    }

    /**
     * @param sale the sale to set
     */
    public void setSale(Integer sale) {
        this.sale = sale;
    }

    /**
     * @return String return the cateId
     */
    public String getCateId() {
        return cateId;
    }

    /**
     * @param cateId the cateId to set
     */
    public void setCateId(String cateId) {
        this.cateId = cateId;
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
     * @return List<ItemType> return the itemTypesList
     */
    public List<ItemType> getItemTypesList() {
        return itemTypesList;
    }

    /**
     * @param itemTypesList the itemTypesList to set
     */
    public void setItemTypesList(List<ItemType> itemTypesList) {
        this.itemTypesList = itemTypesList;
    }


    /**
     * @return List<String> return the pics
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