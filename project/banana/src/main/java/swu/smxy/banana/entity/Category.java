/*
 * @Date: 2020-08-31 01:47:11
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-31 02:44:17
 */
package swu.smxy.banana.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Category implements Serializable {
    private String cateId;
    private String cateName;
    private String parentId;
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

}