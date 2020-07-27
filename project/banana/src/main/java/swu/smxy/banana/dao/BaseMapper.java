/*
 * @Date: 2020-07-25 17:56:25
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-07-25 18:15:22
 * @FilePath: \banana\src\main\java\swu\smxy\banana\dao\BaseMapper.java
 */ 
package swu.smxy.banana.dao;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;

public interface BaseMapper<T> {
  /**
   * @description: 
   * @param {type} 
   * @return: 
   */  
  public List<T> getAll();

  /**
   * @description: 
   * @param {type} 
   * @return: 
   */  
  public T getById(Integer entityId);
  
  public int update(T entity);

  public int insertBatch(List<T> entities);

  public int insert(T entity);
  
  public int delete(T entity);

  public int deleteById(Integer entityId);
  
}