/*
 * @Date: 2020-07-25 16:06:19
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-22 01:54:16
 * @FilePath: \banana\src\main\java\swu\smxy\banana\entity\Business.java
 */
package swu.smxy.banana.entity;

import java.io.Serializable;
import org.springframework.stereotype.Component;

@Component
public class Business implements Serializable, BaseEntity
{
    private String businessId;
    private String businessName;
    private String openDateTime;

    @Override
    public String toString()
    {
        return String.format("%s<%s>", businessName, businessId);
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
     * @return String return the businessName
     */
    public String getBusinessName()
    {
        return businessName;
    }

    /**
     * @param businessName
     *                         the businessName to set
     */
    public void setBusinessName(String businessName)
    {
        this.businessName = businessName;
    }

    /**
     * @return String return the openDateTime
     */
    public String getOpenDateTime()
    {
        return openDateTime;
    }

    /**
     * @param openDateTime
     *                         the openDateTime to set
     */
    public void setOpenDateTime(String openDateTime)
    {
        this.openDateTime = openDateTime;
    }
    public String getId()
    {
        return this.businessId;
    }
    public String getName()
    {
        return this.businessName;
    }
}