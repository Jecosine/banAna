/*
 * @Date: 2020-08-31 01:47:11
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-31 01:53:56
 */
package swu.smxy.banana.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Category implements Serializable {
    private String cateId;
    private String cateName;
    private String parentName;
    private int count;
    private List<Category> data;
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
     * @return String return the cateName
     */
    public String getCateName() {
        return cateName;
    }

    /**
     * @param cateName the cateName to set
     */
    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    /**
     * @return String return the parentName
     */
    public String getParentName() {
        return parentName;
    }

    /**
     * @param parentName the parentName to set
     */
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    /**
     * @return int return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }


    /**
     * @return List<Category> return the data
     */
    public List<Category> getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(List<Category> data) {
        this.data = data;
    }

}