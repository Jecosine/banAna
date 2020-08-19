/*
 * @Date: 2020-07-26 12:22:49
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-19 13:53:32
 * @FilePath: \banana\src\main\java\swu\smxy\banana\service\BaseService.java
 */
package swu.smxy.banana.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swu.smxy.banana.dao.BaseMapper;
@Service
public abstract class BaseService<T> {

  // @Autowired
  BaseMapper<T> mapper;

  public List<T> getAll() 
  {
    return mapper.getAll();
  }

  public T getById(String entityId) 
  {
    return mapper.getById(entityId);
  }

  public int deleteById(String entityId) 
  {
    return mapper.deleteById(entityId);
  }

  public int delete(T entity) 
  {
    return mapper.delete(entity);
  }

}