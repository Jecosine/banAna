/*
 * @Date: 2020-07-26 12:22:49
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-22 02:40:01
 * @FilePath: \banana\src\main\java\swu\smxy\banana\service\BaseService.java
 */
package swu.smxy.banana.service;

import java.util.List;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;  
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swu.smxy.banana.dao.BaseMapper;

// @Service
public class BaseService<T, E extends BaseMapper<T>>
{

    // @Autowired
    private E mapper;
    // get generic class
    Class <E> entityClass = (Class <E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1]; 
    
    @Resource(name = "sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;

    protected SqlSessionFactory getFactory()
    {
        return this.sqlSessionFactory;
    }

    /**
     * @description: get specified amount entity instances
     * @return {@code List<T>} - Return list of entity instance
     */
    public List<T> getSome(int count)
    {
        mapper = (E) sqlSessionFactory.openSession().getMapper(entityClass);
        return mapper.getSome(count);
    }
    /**
     * @description: get all entity instances
     * @return {@code List<T>} - Return list of entity instance
     */
    public List<T> getAll()
    {
        mapper = (E) sqlSessionFactory.openSession().getMapper(entityClass);
        return mapper.getAll();
    }
    /**
     * @description: get entity instance by name
     * @param entityName - entity name
     * @return: {@code T} entity instance
     */
    public T getByName(String entityName)
    {
        mapper = (E) sqlSessionFactory.openSession().getMapper(entityClass);
        return mapper.getByName(entityName);
    }
    /**
     * @description: get entity by id
     * @param entityId {@code String} - entity id
     * @return {@code T} - entity instance
     */
    public T getById(String entityId)
    {
        mapper = (E) sqlSessionFactory.openSession().getMapper(entityClass);
        return mapper.getById(entityId);
    }

    public int deleteById(String entityId)
    {
        mapper = (E) sqlSessionFactory.openSession().getMapper(entityClass);
        return mapper.deleteById(entityId);
    }

    public int delete(T entity)
    {
        mapper = (E) sqlSessionFactory.openSession().getMapper(entityClass);
        return mapper.delete(entity);
    }

}