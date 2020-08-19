/*
 * @Date: 2020-07-25 17:56:25
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-07-26 12:39:46
 * @FilePath: \banana\src\main\java\swu\smxy\banana\dao\BaseMapper.java
 */ 
package swu.smxy.banana.dao;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;

public interface BaseMapper<T> {

  public List<T> getAll();

  public T getById(String entityId);
  
  public int update(T entity);

  public int insertBatch(List<T> entities);

  public int insert(T entity);
  
  public int delete(T entity);

  public int deleteBatch(List<T> entities);

  public int deleteById(String entityId);
  
}