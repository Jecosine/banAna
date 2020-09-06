/*
 * @Date: 2020-09-02 22:35:18
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-09-05 22:46:03
 */
package swu.smxy.banana.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ItemType implements Serializable
{
    private String name;
    private List<ItemType> data;

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * @return List<ItemType> return the data
     */
    public List<ItemType> getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(List<ItemType> data) {
        this.data = data;
    }

}