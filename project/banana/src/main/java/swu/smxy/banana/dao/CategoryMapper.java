/*
 * @Date: 2020-08-31 01:55:47
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-31 02:21:45
 */
package swu.smxy.banana.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import swu.smxy.banana.entity.Category;

public interface CategoryMapper extends BaseMapper<Category>
{

    @Select("select * from category limit #{count}")
    public List<Category> getSome(int count);
    /**
     * @description:
     * @param {type}
     * @return: list of category instance
     */
    @Select("select * from category")
    public List<Category> getAll();

    /**
     * @description: get by id
     * @param id - category id
     * @return: Category with specified id
     */
    @Select("select * from category where cateId=#{categoryId}")
    public Category getById(String categoryId);
    /**
     * @description: get by id
     * @param id - category id
     * @return: Category with specified id
     */
    @Select("select * from category where parentId=#{parentId}")
    public List<Category> getByParentId(String parentId);
    /**
     * @description: get by name
     * @param name - category name
     * @return: Category with specified name
     */
    @Select("select * from category where cateName=#{categoryName}")
    public Category getByName(String categoryName);
    // @Update("update category set ")
    // public int update(Category category);
    
    @Delete("delete from category where cateId=#{categoryId}")
    public int deleteById(String categoryId);

    @Delete("delete from category where cateId=#{categoryId}")
    public int delete(Category category);
}