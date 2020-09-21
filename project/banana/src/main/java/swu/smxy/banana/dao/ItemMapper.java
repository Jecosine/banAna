/*
 * @Date: 2020-09-02 23:08:24
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-09-04 17:42:12
 */
package swu.smxy.banana.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import swu.smxy.banana.entity.Item;

@Component
public interface ItemMapper extends BaseMapper<Item>
{
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

    @Update("update item set remain=#{remain}, itemStatus=#{itemStatus} where itemId=#{itemId}")
    public int updateStock(Item item);
    /**
     * @description: get by name
     * @param name - item name
     * @return: Item with specified name
     */
    @Select("select * from item where itemName=#{itemName}")
    public Item getByName(String itemName);
    // @Update("update item set ")
    // public int update(Item item);
    @Select("select item.*, business.businessName from item, business where cateId=#{cateId} and business.businessId=item.businessId")
    public List<Item> getByCate(String cateId);
    @Delete("delete from item where itemId=#{itemId}")
    public int deleteById(String itemId);

    @Delete("delete from item where itemId=#{itemId}")
    public int delete(Item business);

    @Select("select * from item where parentId=#{itemId} and typeCode=#{typeCode}")
    public Item getByIdAndType(String itemId, String typeCode);

    @Select("select * from subitem where parentId=#{itemId}")
    public List<Item> deleteByItem(Item item);

    @Select("select item.*,business.businessName  from item, business where UPPER(itemName) like CONCAT('%', #{key}, '%') and business.businessId=item.businessId limit 100")
    public List<Item> blurSearchItem(String key);
    @Select("select item.*,business.businessName  from item, business where UPPER(itemName) like CONCAT('%', '小米', '%') and business.businessId=item.businessId limit 12")
    public List<Item> recomList();
}