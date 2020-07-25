/*
 * @Date: 2020-07-25 16:06:19
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-07-25 19:30:50
 * @FilePath: \banana\src\main\java\swu\smxy\banana\entity\Business.java
 */ 
package swu.smxy.banana.entity;

import lombok.Data;

// @Data
public class Business {
    private String businessId;
    private String businessName;
    private String openDateTime;

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
     * @return String return the openDateTime
     */
    public String getOpenDateTime() {
        return openDateTime;
    }

    /**
     * @param openDateTime the openDateTime to set
     */
    public void setOpenDateTime(String openDateTime) {
        this.openDateTime = openDateTime;
    }

}