/*
 * @Date: 2020-07-25 17:06:41
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-19 14:16:58
 * @FilePath: \banana\src\main\java\swu\smxy\banana\service\BusinessService.java
 */ 
package swu.smxy.banana.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swu.smxy.banana.dao.BaseMapper;
import swu.smxy.banana.dao.BusinessMapper;
import swu.smxy.banana.entity.Business;
import swu.smxy.banana.util.DBConnection;

@Service
public class BusinessService extends BaseService<Business> {
  /**
   * @description: get all business instances
   * @param <empty> 
   * @return: return list of Business instance
   */  
  // @Resource
  private BusinessMapper businessMapper;
  @Resource(name="sqlSessionFactory")
  private SqlSessionFactory sqlSessionFactory;
  // private SqlSessionFactory sqlSessionFactory = DBConnection.getFactory();

  public List<Business> getAll()
  {
    businessMapper = sqlSessionFactory.openSession().getMapper(BusinessMapper.class);
    List<Business> list = businessMapper.getAll();
    System.out.println("In Service: " + list.size());
    System.out.println("\t" + list.get(0).toString());
    
    return list;
  }
  /**
   * @description: get Business instance by business instance id
   * @param businessId String
   * @return: Business instance
   */  
  public Business getById(String businessId)
  {
    return businessMapper.getById(businessId);
  }
}