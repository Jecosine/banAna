/*
 * @Author: Jecosine
 * @Date: 2020-07-25 16:30:23
 * @LastEditTime: 2020-08-26 23:14:08
 * @LastEditors: Jecosine
 * @Description: In User Settings Edit
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

    @Select("select * from business limit #{count}")
    public List<Business> getSome(int count);
    /**
     * @description:
     * @param {type}
     * @return: list of business instance
     */
    @Select("select * from business")
    public List<Business> getAll();
    @Select("select businessName from business where businessId=#{businessId}")
    public String getNameById(String businessId);
    /**
     * @description: get by id
     * @param id - business id
     * @return: Business with specified id
     */
    @Select("select * from business where businessId=#{businessId}")
    public Business getById(String businessId);

    /**
     * @description: get by name
     * @param name - business name
     * @return: Business with specified name
     */
    @Select("select * from business where businessName=#{businessName}")
    public Business getByName(String businessName);
    // @Update("update business set ")
    // public int update(Business business);
    
    @Delete("delete from business where businessId=#{businessId}")
    public int deleteById(String businessId);

    @Delete("delete from business where businessId=#{businessId}")
    public int delete(Business business);

}