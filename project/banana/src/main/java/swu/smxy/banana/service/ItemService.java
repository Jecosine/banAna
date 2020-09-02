/*
 * @Date: 2020-09-02 23:07:34
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-09-02 23:09:34
 */
package swu.smxy.banana.service;

import org.apache.ibatis.annotations.Select;

import swu.smxy.banana.entity.Item;

public class ItemService extends BaseService<Item, ItemMapper> {
    @Select("select * from item limit #{count}")
    public List<Item> getSome(int count);
    /**
     * @description:
     * @param {type}
     * @return: list of item instance
     */
    @Select("select * from item")
    public List<Item> getAll();

    /**
     * @description: get by id
     * @param id - item id
     * @return: Item with specified id
     */
    @Select("select * from item where itemId=#{itemId}")
    public Item getById(String itemId);

    /**
     * @description: get by name
     * @param name - item name
     * @return: Item with specified name
     */
    @Select("select * from item where itemName=#{itemName}")
    public Item getByName(String itemName);
    // @Update("update item set ")
    // public int update(Item item);
    
    @Delete("delete from item where itemId=#{itemId}")
    public int deleteById(String itemId);

    @Delete("delete from item where itemId=#{itemId}")
    public int delete(Item business);
}