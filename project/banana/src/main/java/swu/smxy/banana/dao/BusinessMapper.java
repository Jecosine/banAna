/*
 * @Author: Jecosine
 * @Date: 2020-07-25 16:30:23
 * @LastEditTime: 2020-07-25 16:57:36
 * @LastEditors: Jecosine
 * @Description: In User Settings Edit
 * @FilePath: \banana\src\main\java\swu\smxy\banana\dao\BusinessMapper.java
 */ 
package swu.smxy.banana.dao;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
import swu.smxy.banana.entity.Business;


public interface BusinessMapper {

  @Select("select * from business")
  /**
   * @description: 
   * @param {type} 
   * @return: list of business instance
   */  
  public List<Business> getAllBusiness();
}