/*
 * @Author: Jecosine
 * @Date: 2020-07-25 16:30:23
 * @LastEditTime: 2020-08-21 20:56:17
 * @LastEditors: Jecosine
 * @Description: In User Settings Edit
 * @FilePath: \banana\src\main\java\swu\smxy\banana\dao\BusinessMapper.java
 */
package swu.smxy.banana.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import swu.smxy.banana.entity.Business;

// @Repository
@Component
public interface BusinessMapper extends BaseMapper<Business>
{
    /**
     * @description:
     * @param {type}
     * @return: list of business instance
     */
    @Select("select * from business")
    public List<Business> getAll();

    /**
     * @description:
     * @param {type}
     * @return:
     */
    @Select("select * from business where businessId=#{businessId}")
    public Business getById(String businessId);

    // @Update("update business set ")
    // public int update(Business business);

    @Delete("delete from business where businessId=#{businessId}")
    public int deleteById(String businessId);

    @Delete("delete from business where businessId=#{businessId}")
    public int delete(Business business);

}