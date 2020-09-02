/*
 * @Date: 2020-09-02 22:35:18
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-09-02 22:40:17
 */
package swu.smxy.banana.entity;

import java.util.List;

public class ItemDetail
{
    private String name;
    private List<String> list;

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
     * @return List<String> return the list
     */
    public List<String> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<String> list) {
        this.list = list;
    }

}